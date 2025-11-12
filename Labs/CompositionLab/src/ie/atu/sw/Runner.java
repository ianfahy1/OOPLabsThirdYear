package ie.atu.sw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws Exception{
		var algo = Algorithim.GZIP;
		var directory = Paths.get("backups");
		Files.createDirectories(directory);
		
		var files = List.of(
			new BackupFile("small." + algo.extension(), Files.readAllBytes(Path.of("small.txt"))),
			new BackupFile("medium." + algo.extension(), Files.readAllBytes(Path.of("medium.txt"))),
			new BackupFile("large." + algo.extension(), Files.readAllBytes(Path.of("large.txt")))
		);
		
		
		var compressor = new Compressor(Algorithim.GZIP);
		var task = new BackupTask(files, compressor, directory);
		task.execute();
	}
}
