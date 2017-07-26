import java.io.*;

class CatFile {
	public static void cat(File file) {
		RandomAccessFile input = null;
		String line = null;
		try {
			input = new RandomAccessFile(file, "r");
			try {
				while ((line = input.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main (String [] args) {
		//cat(null);
	}
}
