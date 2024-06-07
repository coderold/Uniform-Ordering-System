package UniformOrdering;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Student extends methods{

	public static JTextField tf, quantity;
	public static JFrame frame;
	public static JPanel logPanel,infoPanel, menuPanel, menuHead, tablePanel,
	petablePanel, backPanel, orderPanel, statusPanel;
	
	public static JLabel studentName, studentNum ,studentCourse,headTitle;
	public static JButton check, placeOrder, orderStatus, back, checkOut, addQ;
	public static JTable sizes;
	public static JComboBox typeBox, size;
	//main panels
	public static JPanel headpanel, main, sidePanel, footer;
	
	public static String currentWindow;
	public static String type[];
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		JLabel header = new JLabel("Uniform Ordering System");
		header.setFont(new Font("Roboto",Font.BOLD,20));
		header.setForeground(Color.BLACK);
		header.setVerticalTextPosition(JLabel.CENTER);
		
		
		headpanel = new JPanel();
		main = new JPanel();
		footer = new JPanel();
		sidePanel = new JPanel();
		
		//main panel dimensions
		headpanel.setPreferredSize(new Dimension(100,50));
		main.setPreferredSize(new Dimension(100,100));
		footer.setPreferredSize(new Dimension(100,50));
		sidePanel.setPreferredSize(new Dimension(200,50));
		
		//main panel bg
		headpanel.setBackground(Color.LIGHT_GRAY);
		main.setBackground(Color.GRAY);
		footer.setBackground(Color.LIGHT_GRAY);
		sidePanel.setBackground(Color.LIGHT_GRAY);
		
		
		//sidePanel
		sidePanel.setLayout(new BorderLayout(5,5));
		
		headpanel.add(header);
		
		//log in
		JLabel logIn = new JLabel("Enter your Student Number:");
		JButton logButton = new JButton("Log in");
		logButton.setFocusable(false);
		logButton.addActionListener(e -> studentLogIn(tf.getText()));
		
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(100, 25));
		logPanel = new JPanel();
		logPanel.add(logIn);
		logPanel.add(tf);
		logPanel.add(logButton);
		logPanel.setBackground(Color.LIGHT_GRAY);
		main.add(logPanel);
		
		//info
		studentName = new JLabel();
		studentName.setFont(new Font("Roboto",Font.BOLD,15));
		studentName.setForeground(Color.BLACK);

		studentNum = new JLabel();
		studentNum.setFont(new Font("Roboto",Font.PLAIN,12));
		studentNum.setForeground(Color.BLACK);
		
		studentCourse = new JLabel();
		studentCourse.setFont(new Font("Roboto",Font.PLAIN,12));
		studentCourse.setForeground(Color.BLACK);

		
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.PAGE_AXIS));
		infoPanel.add(studentName);
		infoPanel.add(studentNum);
		infoPanel.add(studentCourse);
		infoPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		infoPanel.setBackground(Color.gray);
		
		//menu 
		check = new JButton("Check Available Sizes");
		placeOrder = new JButton("Place an Order");
		orderStatus = new JButton("Order Status");
		
		//check table
		check.addActionListener(e -> sizes());
		tablePanel = new JPanel();
		tablePanel.setVisible(false);
		petablePanel = new JPanel();
		petablePanel.setVisible(false);
		
		//order
		placeOrder.addActionListener(e-> order());
		orderPanel = new JPanel();
		orderPanel.setVisible(false);
		
		//order status
		orderStatus.addActionListener(e-> order());
		statusPanel = new JPanel();
		statusPanel.setVisible(false);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		menuPanel.setPreferredSize(new Dimension(100,100));
		menuPanel.setBackground(Color.gray);
		menuPanel.add(check);
		menuPanel.add(placeOrder);
		menuPanel.add(orderStatus);
		
		menuHead = new JPanel();
		menuHead.setLayout(new BorderLayout());
		menuHead.setPreferredSize(new Dimension(100,35));
		menuHead.setBackground(Color.gray);
		
		headTitle = new JLabel("Menu");
		back = new JButton("back");
		back.addActionListener(e -> back());
		backPanel = new JPanel();
		backPanel.setBackground(Color.gray);
		backPanel.add(back);
		headTitle.setFont(new Font("Roboto",Font.BOLD,15));
		headTitle.setForeground(Color.black);
		headTitle.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		menuHead.add(headTitle, BorderLayout.CENTER);
		menuHead.add(backPanel, BorderLayout.EAST);
		backPanel.setVisible(false);
		
		
		
		//frame
		ImageIcon image = new ImageIcon("logo.png");
		frame = new JFrame();
		frame.setTitle("Student Ordering System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(750,500);
		frame.setLayout(new BorderLayout(5,5));
		
		//panels
		frame.add(headpanel, BorderLayout.NORTH);
		frame.add(main, BorderLayout.CENTER);
		frame.add(footer, BorderLayout.SOUTH);


		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(Color.white);
		//frame.getContentPane().setBackground(new Color(102,177,193));
		
		
		
		
		
		/**System.out.println("Welcome Student!\n");
		studentLogIn();
		while(found) {
			System.out.println("\n1.Check Uniform Stocks.\n2.Place an Order.\n3.Order Status.\n4.Back.");
			int userInput = input.nextInt();
			
			if(userInput == 1) {
				if(course.equals("HM")) {
					System.out.println("\n1.Daily Uniform\n2.Food & Beverages\n3.Kitchen\n4.PE & NSTP");
					userInput = input.nextInt();
					if(userInput == 1) {
						printDailyUniformStocks();
					}else if (userInput == 2) {
						printList("BSHM F & B.csv");
					}else if (userInput == 3) {
						printList("BSHM KITCHEN.csv");
					}else if (userInput == 4) {
						printList("PE & NSTP.csv");
					}else {
						System.out.println("\nInvalid input.");
						userInput = 1;
					}
					
					
				}else {
					System.out.println("\n1.Daily Uniform\n2.PE & NSTP");
					userInput = input.nextInt();
					if(userInput == 1) {
						printDailyUniformStocks();
					}else if (userInput == 2) {
						printList("PE & NSTP.csv");
					}else {
						System.out.println("\nInvalid input.");
						userInput = 1;
					}
				}
			}else if(userInput == 2) {
				//putangina mo
				//to do
				//place an order
				//create place an order method that will ask the user their order
				//place it on ongoing order csv
				
				System.out.println("Placing an order:\n");
				if(course.equals("HM")) {
					System.out.println("\n1.Daily Uniform\n2.Food & Beverages\n3.Kitchen\n4.PE & NSTP");
					userInput = input.nextInt();
					if(userInput == 1) {
						printDailyUniformStocks();
					}else if (userInput == 2) {
						printList("BSHM F & B.csv");
					}else if (userInput == 3) {
						printList("BSHM KITCHEN.csv");
					}else if (userInput == 4) {
						printList("PE & NSTP.csv");
					}else {
						System.out.println("\nInvalid input.");
						userInput = 1;
					}
					
					
				}else {
					System.out.println("\n1.Daily Uniform\n2.PE & NSTP");
					userInput = input.nextInt();
					if(userInput == 1) {
						printDailyUniformStocks();
					}else if (userInput == 2) {
						printList("PE & NSTP.csv");
					}else {
						System.out.println("\nInvalid input.");
						userInput = 1;
					}
				}
				
			}else if(userInput == 3) {
				//check ongoing order csv and find user's student id
				//if found, print ongoing status
				//if not, print you have no orders at the moment.
			}else if(userInput == 4) {
				//back
			}else {
				System.out.println("Invalid Input.");
			}
			
		}**/
		
		input.close();
	}


}
