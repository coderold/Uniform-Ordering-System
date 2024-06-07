package UniformOrdering;

import java.util.*;

public class Admin extends methods{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Admin!\n\n");
		
		while(true) {
			System.out.println("\n1.Show Students List\n2.Add a Student to List\n3.Delete Student from List\n4.Check Ongoing Orders\n5.Complete an Order");
			int adminInput = input.nextInt();
			if(adminInput == 1) {
				printStudentList();
			}else if(adminInput == 2) {
				printStudentList();
			}
			else {
				break;
			}
		}
		
		
		
		input.close();
		

	}

}
