import java.util.Scanner;

public class Palindrome {

	public Palindrome() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkPalindrome(String word)
	{
		char ch[]= word.toCharArray();
		int count =0;
		for(int i=0;i<ch.length/2;i++)
		{
				if(ch[i] == ch[ch.length-i-1])
				{
				count=0;
				}
				else{
				count++;
				}
		}
		if(count == 0)
		{
		return true;
		}
		else
		{
		return false;
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Palindrome obj = new Palindrome();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String word = sc.next();
		if(obj.checkPalindrome(word)){
			System.out.println("Word is Palindrome");
		}
		else
		{
			System.out.println("Word is not Palindrome");
		}
		

	}

}
