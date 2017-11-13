import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// illustrates how to use Files class to compare two paths
class PathCompare2 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("Test");
		Path path2 = Paths.get("C:\\Users\\rafael.possenti\\Desktop\\git_A\\OCP-study-guide\\Ganesh\\JAVA NIO2\\Test");
		System.out.println("Files.isSameFile(path1, path2) is: " + Files.isSameFile(path1, path2));
	}
}