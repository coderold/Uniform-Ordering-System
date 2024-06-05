package UniformOrdering;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Student extends methods{

	static JTextField tf;
	public static JPanel logPanel;
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		JLabel header = new JLabel("Uniform Ordering System.");
		JPanel headpanel = new JPanel();
		headpanel.add(header);
		headpanel.setBounds(150, 0, 200, 50);
		headpanel.setBackground(Color.RED);
		
		JLabel logIn = new JLabel("Enter your Student Number:");
		
		JButton logButton = new JButton("Log in");
		logButton.setFocusable(false);
		//logButton.setBounds(50,200,100,50);
		logButton.addActionListener(e -> studentLogIn(tf.getText()));
		
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(100, 25));
		
		logPanel = new JPanel();
		logPanel.add(logIn);
		logPanel.add(tf);
		logPanel.add(logButton);
		logPanel.setBounds(50,50,400,200);
		logPanel.setBackground(Color.GREEN);
		
		
		//frame
		JFrame frame = new JFrame();
		frame.setTitle("Student Ordering System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.add(headpanel);
		frame.add(logPanel);
		//icon
		ImageIcon image = new ImageIcon("logo.png");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(102,177,193));
		
		
		
		
		
		System.out.println("Welcome Student!\n");
		//studentLogIn();
		while(found) {
			System.out.println("\n1.Check Uniform Stocks.\n2.Place an Order.\n3.Order Status");
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
				
				userInput = input.nextInt();
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
			}
			
		}
		
		input.close();
	}


}
