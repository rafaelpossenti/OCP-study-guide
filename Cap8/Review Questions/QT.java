import java.io.*;

public class QT{
	
	private static void q5() throws IOException{
		String line;
		Console c = System.console();
		Writer w = c.writer();
		if ((line = c.readLine()) != null)
			w.append(line);
		w.flush();
		
	} 
	
	public static void deleteTree(File file) {
		if(!file.isFile())
			for(File entry: file.listFiles())
				deleteTree(entry);
		else file.delete();
	}
	
	private void echo() throws IOException {
		try (FileReader fileReader = new FileReader("zoo-data.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			System.out.println(bufferedReader.readLine());
		}
	}

	
	public static void main(String[] args){
		
	}
	
}