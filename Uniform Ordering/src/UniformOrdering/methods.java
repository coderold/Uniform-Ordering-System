package UniformOrdering;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class methods{
	
	static String students = "students.csv";
	static Scanner input = new Scanner(System.in);
	
	public static String course = "";
	public static String uniform ="uniform stocks\\";
	public static String pe ="uniform stocks\\PE & NSTP.csv";
	public static String studentDailyUniform;
	public static boolean found = false, run = true;
	
	private static String name, studentNo;
	
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
					course = row[2].toUpperCase();
					
					found = true;
					Student.logPanel.setVisible(false);
					Student.studentName.setText  ("Name       : "+row[1]);
					Student.studentNum.setText   ("Student No  : "+row[0]);
					Student.studentCourse.setText("Course         : "+row[2]);
					Student.sidePanel.add(Student.infoPanel, BorderLayout.NORTH);
					Student.frame.add(Student.sidePanel, BorderLayout.WEST);
					
					name = row[1];
					studentNo = row[0];
					
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
	
	static void printOngoingList(String fileName) {
		String path ="orders\\" + fileName;
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			String title = fileName.substring(0, fileName.lastIndexOf('.'));
			System.out.println("\n"+ title +": \n");
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
			studentDailyUniform = uniform + "ICT & ENGINEERING.csv";
		}else if (course.equals("COMM")|| course.equals("MA")) {
			studentDailyUniform = uniform + "ARTS & SCIENCES.csv";
		}else if (course.equals("BSA")|| course.equals("BSBAOM")) {
			studentDailyUniform = uniform + "BSAIS.csv";
		}else if (course.equals("HM")) {
			studentDailyUniform = uniform + "BSHM.csv";
		}else if (course.equals("TM")) {
			studentDailyUniform = uniform + "BSTM.csv";
		}
		
		
	}
	
	public static void printDailyUniformStocks(){
		fileSearch();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(studentDailyUniform));
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
		fileSearch();
		
		Student.menuPanel.setVisible(false);
		Student.currentWindow = "order";
		Student.backPanel.setVisible(true);
        Student.back.addActionListener(e-> back());
        Student.orderPanel.setVisible(true);
        Student.main.add(Student.orderPanel);
        
        
        Student.size = new JComboBox();
        
        try {
			
		BufferedReader reader = new BufferedReader(new FileReader(studentDailyUniform));
		List<String> firstColumn = new ArrayList<>();
		String line = reader.readLine();
		String col;

		if (line != null) {
             Student.typeBox = new JComboBox(removeNulls(line.split(",")));
             Student.typeBox.getToolTipText();
        }
		
		while ((col = reader.readLine()) != null) {
            String[] fields = col.split(",");
            if (fields.length > 0) {
                firstColumn.add(fields[0]);
            }
        }
		String column [] = firstColumn.toArray(new String[0]);
		Student.size = new JComboBox(column);
		
		reader.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
        
		
		Student.headTitle.setText("Placing an Order");
		Student.orderPanel.setLayout(new BorderLayout(5,5));
		
		JPanel orderHead = new JPanel();
		orderHead.setBackground(Color.LIGHT_GRAY);
		JPanel orderFoot = new JPanel();
		orderFoot.setBackground(Color.LIGHT_GRAY);
		
		orderFoot.setPreferredSize(new Dimension(0,40));
		orderFoot.setLayout(new BorderLayout());
		Student.checkOut = new JButton("Check Out");
		Student.checkOut.addActionListener(e-> checkOut());
		orderFoot.add(Student.checkOut, BorderLayout.EAST);
		
		JLabel orderHT = new JLabel("Orders:");
		orderHT.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		orderHT.setForeground(Color.black);
		orderHT.setFont(new Font("Roboto",Font.BOLD,12));
		orderHead.add(orderHT);
		Student.orderPanel.add(orderHead,BorderLayout.NORTH);
		Student.orderPanel.add(orderFoot,BorderLayout.SOUTH);
		
		
		if(run) {
			JPanel content = new JPanel();
			Student.orderPanel.add(content,BorderLayout.CENTER);
			JPanel addOrder = new JPanel();
			addOrder.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			addOrder.setBackground(Color.LIGHT_GRAY);
			//addOrder.setPreferredSize(new Dimension(500,50));
			addOrder.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			Student.quantity = new JTextField("1");
			
			
			addOrder.add(new JLabel("Uniform:"));
			addOrder.add(Student.typeBox);
			addOrder.add(new JLabel("Size:"));
			addOrder.add(Student.size);
			addOrder.add(new JLabel("Quantity:"));
			addOrder.add(Student.quantity);
			content.add(addOrder);
			run = false;
		}
		
	}
	
	static void status() {
		Student.menuPanel.setVisible(false);
		Student.currentWindow = "status";
		Student.backPanel.setVisible(true);
        Student.back.addActionListener(e-> back());
	}
	
	static void menu() {
		//menu 
		
		Student.main.setLayout(new BorderLayout(5,5));
		Student.main.setBackground(Color.white);
		Student.main.add(Student.menuPanel, BorderLayout.CENTER);
		Student.main.add(Student.menuHead, BorderLayout.NORTH);
		Student.backPanel.setVisible(false);
		Student.currentWindow = "menu";
		Student.headTitle.setText("Menu");
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
            String[][] data = readCSV(studentDailyUniform);
            if (data != null) {
                String[] columnNames = data[0]; 
                String[][] tableData = new String[data.length - 1][];
                System.arraycopy(data, 1, tableData, 0, data.length - 1);
                JTable table = new JTable(tableData, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                Student.menuPanel.setVisible(false);
                Student.tablePanel.add(scrollPane, BorderLayout.CENTER);
                Student.main.add(Student.tablePanel);
                Student.tablePanel.setVisible(true);
                Student.currentWindow = "check";
                Student.backPanel.setVisible(true);
                Student.back.addActionListener(e-> back());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		Student.headTitle.setText("Available Sizes");
	}
	
	static void back() {
		
		if(Student.currentWindow.equals("menu")) {
			Student.backPanel.setVisible(false);
			Student.headTitle.setText("Menu");
		}else if(Student.currentWindow.equals("check")) {
			Student.backPanel.setVisible(false);
			Student.tablePanel.setVisible(false);
			Student.menuPanel.setVisible(true);
			Student.currentWindow = "menu";
		}else if(Student.currentWindow.equals("order")) {
			Student.backPanel.setVisible(false);
			Student.orderPanel.setVisible(false);
			Student.menuPanel.setVisible(true);
			Student.currentWindow = "menu";
		}else if(Student.currentWindow.equals("status")) {
			Student.backPanel.setVisible(false);
			Student.statusPanel.setVisible(false);
			Student.menuPanel.setVisible(true);
			Student.currentWindow = "menu";
		}
	}
	
	public static String[] removeNulls(String[] array) {
        return Arrays.stream(array)
                .filter(e -> e != "")
                .toArray(String[]::new);
    }
	
	private static JFrame popframe = new JFrame("Confirm CheckOut");
	public static void checkOut() {
		
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		popframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popframe.setVisible(true);
		popframe.setSize(300, 200);
		popframe.setLayout(new BorderLayout());
		
		JLabel confirmText = new JLabel();
		confirmText.setText("Are you sure to check out the Following:");
		
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		textPanel.add(confirmText);
		textPanel.add(new JLabel("Uniform     :   " + Student.typeBox.getSelectedItem()));
		textPanel.add(new JLabel("Size     	       :   " + Student.size.getSelectedItem()));
		textPanel.add(new JLabel("Quantity    :   " + Student.quantity.getText()));
		
		textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		textPanel.setBackground(Color.LIGHT_GRAY);
		
		JButton confirmButton = new JButton("Confirm");
		JButton cancelButton = new JButton("Cancel");
		buttonPanel.add(confirmButton);
		buttonPanel.add(cancelButton);
		
		confirmButton.addActionListener(e -> confirm());
		cancelButton.addActionListener(e -> cancel());
		
		
		popframe.add(textPanel, BorderLayout.CENTER);
		popframe.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	static void confirm() {
		
		Object uniform, size;
		String quantity;
		
		uniform = Student.typeBox.getSelectedItem();
		size = Student.size.getSelectedItem();
		quantity = Student.quantity.getText();
		
		
		try {
			FileWriter writer = new FileWriter("orders//Ongoing Orders.csv", true);
			writer.write("\n"+ studentNo + "," + name + "," + uniform + "," + size + "," + quantity);
			System.out.println("New student added succesfully.\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		popframe.dispose();
	}
	
	static void cancel() {
		popframe.dispose();
	}
	
	static void orderStatus() {
		
		/**Student.menuPanel.setVisible(false);
		Student.currentWindow = "status";
		Student.backPanel.setVisible(true);
        Student.back.addActionListener(e-> back());
        Student.statusPanel.setVisible(true);
        Student.ongoing.setVisible(true);
        
        JPanel ongoing = new JPanel();
        ongoing.setLayout(new BorderLayout(5,5));
        JPanel onHead = new JPanel();
        JLabel onlabel = new JLabel("Ongoing Orders");
        onHead.add(onlabel);
        onHead.setBackground(Color.gray);
        onHead.setPreferredSize(new Dimension(100,50));
        ongoing.add(onHead, BorderLayout.NORTH);
        Student.statusPanel.add(ongoing);
        Student.main.add(Student.statusPanel);
        **/
        //JPanel completed = new JPanel();
        
        
		
	}
	
	static void checkOrderStatus(String studentNum, String file) {
		String currentLine;
		
		if(file.equals("ongoing")) {
			file = "orders//Ongoing Orders.csv";
		}else if (file.equals("completed")) {
			file = "orders//Completed Orders.csv";
		}
		
		

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while((currentLine = reader.readLine()) != null) {
				String row [] = currentLine.split(",");
				if(row[0].equals(studentNum)) {
					
					found = true;
					Student.logPanel.setVisible(false);
					Student.studentName.setText  ("Name       : "+row[1]);
					Student.studentNum.setText   ("Student No  : "+row[0]);
					Student.studentCourse.setText("Course         : "+row[2]);
					Student.sidePanel.add(Student.infoPanel, BorderLayout.NORTH);
					Student.frame.add(Student.sidePanel, BorderLayout.WEST);
					
					name = row[1];
					studentNo = row[0];
					
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
	
}
