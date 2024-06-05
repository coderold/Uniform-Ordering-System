package UniformOrdering;

import java.io.*;
import java.util.*;

public class methods{
	
	static String students = "C:\\Users\\BOSS\\Desktop\\Uniform Ordering\\students.csv";
	static Scanner input = new Scanner(System.in);
	
	public static String course = "";
	public static String uniform ="C:\\Users\\BOSS\\Desktop\\Uniform Ordering\\uniform stocks\\";
	public static boolean found = false;
	//printing list 
	static void printStudentList() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(students));
			String line = "";
			System.out.println("\nUpdated List: \n");
			while((line = reader.readLine()) != null) {
				String row [] = line.split(",");
				for(String index : row) {
					System.out.printf("%-15s", index);
				}
				System.out.println();
				
			}
			reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	static void deleteFromList() {
		System.out.print("\nWhich line you want to delete: ");
		int deleteLine = input.nextInt()+1;
		
		String tempFile = "temp.csv";
		File oldFile = new File(students);
		File newFile = new File(tempFile);
		
		int line = 0;
		String currentLine;
		
		try {
			//writers
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile,true));
			PrintWriter writer = new PrintWriter(bw);
			//reader
			BufferedReader reader = new BufferedReader(new FileReader(students));
			
			while((currentLine = reader.readLine()) != null) {
				line++;
				if(deleteLine != line) {
					writer.println(currentLine);
				}else {
					int deletedLine = line - 1;
					System.out.println("\nLine " + deletedLine + " has been sucessfully removed.");
				}
			}
			
			writer.flush();
			writer.close();
			bw.close();
			reader.close();
			
			//delete old file and rewrite it
			oldFile.delete();
			File dump = new File(students);
			newFile.renameTo(dump);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void addToList() {
		String studentNo = "", name = "", courseCode = "";
		
		System.out.print("Enter Student No   : ");
		studentNo = input.nextLine();
		System.out.print("Enter Student Name : ");
		name = input.nextLine();
		System.out.print("Enter Course Code  : ");
		courseCode = input.nextLine();
		
		
		addToList student = new addToList(studentNo, name, courseCode);
		student.add();
	}
	
	static void studentLogIn(String studentNum) {
		String currentLine;
		
		//System.out.print("Enter your student number: ");
		//String studentNum = input.nextLine();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(students));
			
			while((currentLine = reader.readLine()) != null) {
				String row [] = currentLine.split(",");
				if(row[0].equals(studentNum)) {
					System.out.println("Successfully logged in...\n\n");
					System.out.println("Hi, " + row[1]);
					course = row[2].toUpperCase();
					System.out.println("You are a " + course + " student.");
					found = true;
					Student.logPanel.setVisible(false);
				}
			}
			if(!found) {
				System.out.println("Student not Found.");
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static void printList(String fileName) {
		String path ="C:\\Users\\BOSS\\Desktop\\Uniform Ordering\\uniform stocks\\" + fileName;
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			String title = fileName.substring(0, fileName.lastIndexOf('.'));
			System.out.println("\n"+ title +" UNIFORM STOCKS\n");
			while((line = reader.readLine()) != null) {
				String row [] = line.split(",");
				for(String index : row) {
					System.out.printf("%-15s", index);
					System.out.print(" | ");
				}
				System.out.println();
				
			}
			reader.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	static void fileSearch() {
		
		//accessing the stock file
		if (course.equals("CS") || course.equals("IT") || course.equals("CPE")) {
			uniform = uniform + "ICT & ENGINEERING.csv";
		}else if (course.equals("COMM")|| course.equals("MA")) {
			uniform = uniform + "ARTS & SCIENCES.csv";
		}else if (course.equals("BSA")|| course.equals("BSBAOM")) {
			uniform = uniform + "BSAIS.csv";
		}else if (course.equals("HM")) {
			uniform = uniform + "BSHM.csv";
		}else if (course.equals("TM")) {
			uniform = uniform + "BSTM.csv";
		}
		
		
	}
	
	public static void printDailyUniformStocks(){
		fileSearch();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(uniform));
			String line = "";
			System.out.println("\nDAILY UNIFORM STOCKS \n");
			while((line = reader.readLine()) != null) {
				String row [] = line.split(",");
				for(String index : row) {
					System.out.printf("%-15s", index);
					System.out.print(" | ");
				}
				System.out.println();
				
			}
		//printList("PE & NSTP.csv");
		reader.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}
	
	static void order() {
	
	}
	
	
}
