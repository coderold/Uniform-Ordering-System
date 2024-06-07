package UniformOrdering;

import java.io.*;

public class addToList {
	
	String studentNo, name, courseCode, discount;
	
	String students = "StudentSheet1.csv";

	
	//constructors
	addToList(String studentNo, String name, String courseCode, String discount){
		this.studentNo = studentNo;
		this.name = name;
		this.courseCode = courseCode;
		this.discount = discount;
	}
	
	//object method
	void add(){
		
		try {
			FileWriter writer = new FileWriter(students, true);
			writer.write("\n"+ studentNo + "," + name + "," + courseCode + "," + discount);
			System.out.println("New student added succesfully.\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	


}
