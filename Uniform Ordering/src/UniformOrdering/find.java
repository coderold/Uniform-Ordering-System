package UniformOrdering;

import java.io.*;

public class find {
	
	find(){
		String path = "C:\\Users\\BOSS\\Desktop\\Uniform Ordering\\students.csv";
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			while((line = reader.readLine()) != null) {
				String row [] = line.split(",");
				for(String index : row) {
					System.out.printf("%-10s", index);
					System.out.print(" | ");
				}
				System.out.println();
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
