import java.io.File;

public class FilesScan {
	public static void main(String[] arg) {
		final File folder = new File("C:\\Users\\Patra's Home\\Downloads\\OpenCV\\opencv");
		listFilesForFolder(folder);
	}
	
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}
}
