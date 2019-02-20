package ex11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class even_odd_prime {

	private List<Integer> list1 =new ArrayList<Integer>();;
	private List<Integer> list2 =new ArrayList<Integer>();;
	private List<Integer> list3 =new ArrayList<Integer>();
	private Map<String,List<Integer>> map;
	public Map<String,List<Integer>> compute(int min,int max)
	{
		map = new HashMap<String,List<Integer>>();
		String evenkey = "even";
		String oddkey = "odd";
		String primekey = "prime";
		for(int num =min;num<=max;num++)
		{	
			if(checkEven(num) == true)
			{
				list1.add(num);
			}
			map.put(evenkey,list1);
			if(checkOdd(num) == true)
			{
				list2.add(num);
			}
			map.put(oddkey,list2);
			if(checkPrime(num) == true)
			{
				list3.add(num);
			}
			map.put(primekey, list3);
		}
		return map;
	}
	public boolean checkEven(int num){
		
		if(num % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean checkOdd(int num){
		
		if(num % 2 !=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean checkPrime(int num){
		int count =0;
		for(int i=1;i<=num;i++)
		{
			if(num%i ==0)
			{
				count++;
			}
		}
		if(count ==2)
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
		// TODO Auto-generated method stub
		
		even_odd_prime obj = new even_odd_prime();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the minimum range");
		int min = sc.nextInt();
		System.out.println("Enter the maximum range");
		int max = sc.nextInt();
		Map<String,List<Integer>> map = obj.compute(min,max);
		List<Integer>evenList = map.get("even");
		List<Integer> oddList = map.get("odd");
		List<Integer> primeList = map.get("prime");
		System.out.println("Even Numbers in "+min+"to "+max+":");
		for(int i =0;i<evenList.size();i++)
		{
			System.out.print(evenList.get(i)+" ");
		}
		System.out.println();
		System.out.println("Odd Numbers in "+min+"to "+max+":");
		for(int i =0;i<oddList.size();i++)
		{
			System.out.print(oddList.get(i)+" ");
		}
		System.out.println();
		System.out.println("Prime Numbers in "+min+"to "+max+":");
		for(int i =0;i<primeList.size();i++)
		{
			System.out.print(primeList.get(i)+" ");
		}
	}

}
