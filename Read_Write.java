import java.util.Scanner;

public class Read_Write {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Input values:");
		int number = sc.nextInt();
		String line = sc.next();
		System.out.println("The output values");
		System.out.println(number*2);
		System.out.println(line.substring(line.length()/2)+line.substring(0,line.length()/2));
		
	}

}
