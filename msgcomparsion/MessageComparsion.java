package msgcomparsion;

public class MessageComparsion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1 = "congratulations! 2g225 has been successfully activated on your phone 9441404241 thank you. reliance";
		String msg2 = "congratulations! 3g500 has been successfully activated on your phone 8971739408 thank you. reliance";
		
		String msg1Words[];
		String msg2Words[];
		
		msg1Words = msg1.split(" ");
		msg2Words = msg2.split(" ");
		
		System.out.println("Differences in the messages");
		
		for(int i=0;i<msg1Words.length;i++)
		{
			if(!(msg1Words[i].equals(msg2Words[i])))
			{
				System.out.println(msg1Words[i]+" "+"and"+" "+msg2Words[i]);
			}
		}
	}

}
