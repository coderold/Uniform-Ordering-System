package UniformOrdering;

import java.io.*;

public class addToList {
	
	String studentNo, name, courseCode;
	
	String students = "students.csv";
	
	//constructors
	addToList(String studentNo, String name, String courseCode){
		this.studentNo = studentNo;
		this.name = name;
		this.courseCode = courseCode;
	}
	
	//object method
	void add(){
		
		try {
			FileWriter writer = new FileWriter(students, true);
			writer.write("\n"+ studentNo + "," + name + "," + courseCode);
			System.out.println("New student added succesfully.\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	


}
