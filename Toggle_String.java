import java.util.Scanner;

public class Toggle_String {

	
	public String toggleString(String line)
	{
		char ch[] = line.toCharArray();
		
		for(int i =0;i<ch.length;i++)
		{
			int ascii = ch[i];
			if(ascii >=65 && ascii <=90)
			{
				ch[i]=(char)(ascii+32);
			}
			else if(ascii >=97 && ascii <=122)
			{
				ch[i]=(char)(ascii-32);
			}
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toggle_String obj = new Toggle_String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String line =sc.next();
		String result = obj.toggleString(line);
		System.out.println(result);
	}

}
