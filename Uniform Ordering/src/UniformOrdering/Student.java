package UniformOrdering;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Student extends methods{

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		JLabel label = new JLabel();
		label.setText("Uniform Ordering System.");
		//frame
		JFrame frame = new JFrame();
		frame.setTitle("Student Ordering System");
		
		//icon
		ImageIcon image = new ImageIcon("logo.png");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(102,177,193));
		
		JPanel panel = new JPanel();
		JButton button = new JButton();
		frame.add(panel, BorderLayout.CENTER);
		panel.add(label);
		button.setText("CLick");
		panel.add(button);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setResizable(false);
		
		System.out.println("Welcome Student!\n");
		studentLogIn();
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
			}else if(userInput == 3) {
				//check ongoing order csv and find user's student id
				//if found, print ongoing status
				//if not, print you have no orders at the moment.
			}
			
		}
		
		
	}

}
