<<<<<<< HEAD
import java.util.*; 
import java.util.stream.*;
=======
import java.util.*;
>>>>>>> 6c15c5ce1c0bad2db53324d8d00144b7f4e0f26b

public class Ex03{
	public static void main(String... args){
		
		Student s1 = new Student("A",2011,95);
		Student s2 = new Student("B",2011,98);
		Student s3 = new Student("C",2011,82);
		
		//List<Student> students = new ArrayList<>();
		
		//students.add(s1);
		//students.add(s2);
		//students.add(s3);
		
		Stream<String> students;
//		= Stream.of(s1,s2,s3);
		
		double highestScore =  
			students.stream()
			.filter((Student s) -> s.getGradYear() == 2011)
			.map((Student s) -> s.getScore())
			.max();

		
		System.out.println("Highest grade is " + highestScore);
	}
	
}