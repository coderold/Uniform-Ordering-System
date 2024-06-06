package UniformOrdering;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class methods{
	
	static String students = "students.csv";
	static Scanner input = new Scanner(System.in);
	
	public static String course = "";
	public static String uniform ="uniform stocks\\";
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
					Student.studentName.setText  ("Name       : "+row[1]);
					Student.studentNum.setText   ("Student No  : "+row[0]);
					Student.studentCourse.setText("Course         : "+row[2]);
					Student.sidePanel.add(Student.infoPanel, BorderLayout.NORTH);
					Student.frame.add(Student.sidePanel, BorderLayout.WEST);
					menu();
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
		String path ="uniform stocks\\" + fileName;
		
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
	
	static void menu() {
		//menu 
		Student.backPanel = new JPanel();
		Student.check = new JButton("Check Available Sizes");
		Student.placeOrder = new JButton("Place an Order");
		Student.orderStatus = new JButton("Order Status");
				
		Student.check.addActionListener(e -> sizes());
				
		Student.menuPanel = new JPanel();
		Student.menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		Student.menuPanel.setPreferredSize(new Dimension(100,100));
		Student.menuPanel.setBackground(Color.gray);
		Student.menuPanel.add(Student.check);
		Student.menuPanel.add(Student.placeOrder);
		Student.menuPanel.add(Student.orderStatus);
				
		Student.menuHead = new JPanel();
		Student.menuHead.setLayout(new BorderLayout());
		Student.menuHead.setPreferredSize(new Dimension(100,35));
		Student.menuHead.setBackground(Color.gray);
		Student.main.setLayout(new BorderLayout(5,5));
		Student.main.setBackground(Color.white);
		Student.main.add(Student.menuPanel, BorderLayout.CENTER);
		Student.main.add(Student.menuHead, BorderLayout.NORTH);
		
		JLabel headTitle = new JLabel("Menu");
		
		headTitle.setFont(new Font("Roboto",Font.BOLD,15));
		headTitle.setForeground(Color.black);
		headTitle.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		Student.menuHead.add(headTitle, BorderLayout.CENTER);
		Student.menuHead.add(Student.backPanel, BorderLayout.EAST);
		Student.currentWindow = "menu";
		
	
	}
	
	
	public static String[][] readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
        }
        if (data.isEmpty()) {
            return null;
        }
        return data.toArray(new String[0][]);
    }
	
	public static void sizes() {
		fileSearch();
		try {
            //String filePath = "path_to_your_csv_file.csv"; // Specify the path to your CSV file
            String[][] data = readCSV(uniform);
            if (data != null) {
                String[] columnNames = data[0]; // Assuming first row is the header
                String[][] tableData = new String[data.length - 1][];
                System.arraycopy(data, 1, tableData, 0, data.length - 1);
                JTable table = new JTable(tableData, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                Student.menuPanel.setVisible(false);
                Student.tablePanel.add(scrollPane, BorderLayout.CENTER);
                Student.main.add(Student.tablePanel);
                Student.currentWindow = "check";
                back();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	static void back() {
		JButton back = new JButton("back");
		back.addActionListener(e -> back());
		
		Student.backPanel.setBackground(Color.gray);
		Student.backPanel.add(back);
		
		if(Student.currentWindow.equals("menu")) {
			Student.backPanel.setVisible(false);
		}else if(Student.currentWindow.equals("check")) {
			Student.backPanel.setVisible(true);
			menu();
		}
	}
	
	
}
