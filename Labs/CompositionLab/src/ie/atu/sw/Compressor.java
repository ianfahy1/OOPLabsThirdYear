package ie.atu.sw;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor {
	//Enum
	private Algorithim algorithim;
	
	//Constructor
	public Compressor(Algorithim algorithim) {
		this.algorithim = algorithim;
	}
	
	public byte[] compress(BackupFile file) throws IOException{
		return switch(algorithim) {
		case GZIP 	-> gzip(file.content());
		case ZIP 	-> zip(file.content(), file.name());
		case NONE 	-> file.content();
		};
	}
	
	public byte[] gzip(byte[] data) throws IOException{
		
		var out = new ByteArrayOutputStream(0);
		
		try(var gzip = new GZIPOutputStream(out)){
			gzip.write(data);
		}
		return out.toByteArray();
	}
	
	public byte[] zip(byte[] data, String name) throws IOException{
		
		var out = new ByteArrayOutputStream(0);
		
		try(var zip = new ZipOutputStream(out)){
			zip.putNextEntry(new ZipEntry(name));
			zip.write(data);
			zip.closeEntry();
		}
		
		return out.toByteArray();
	}}


