package ex5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class findEmailsFromList {
	private ArrayList<String> al1;
	public findEmailsFromList()
	{
		al1 = new ArrayList<String>();
		al1.add("tejdeep.java@gmail.com");
		al1.add("tejdeep.hadoop@gmail.com");
		al1.add("tej.java@yahoo.com");
		al1.add("renu.ui@gamil.com");
		al1.add("tej.hadoop@gmail.com");
		al1.add("renu.hadoop@gamil.com");
		
	}
	
	private ArrayList<String> getEmails(String str){
		
		String str_search = str;
		String email;
		ArrayList<String> ar = new ArrayList<String>();
		System.out.println("Email list:");
		System.out.println(al1);
		for(int i=0;i<al1.size();i++)
		{
			email=al1.get(i).toString();
			if(email.startsWith(str))
			{
				ar.add(email);
			}	
		}
		return ar;
		
	}
	public static void main(String[] args) {
		findEmailsFromList obj = new findEmailsFromList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String search_value = sc.next();
		ArrayList<String> emaillist = obj.getEmails(search_value);
		Iterator<String> it = emaillist.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
