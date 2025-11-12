package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BackupTask {

	private List<BackupFile> files;
	private Compressor compressor;
	private Path path;
	
	public BackupTask(List<BackupFile> files, Compressor compressor, Path path) {
		super();
		this.files = files;
		this.compressor = compressor;
		this.path = path;
	}



	public void execute() throws IOException{
		for(BackupFile file : files) {
			byte[] data = compressor.compress(file);
			Path output = path.resolve("bk_" + file.name());
			Files.write(output, data);
		}
	}
}
