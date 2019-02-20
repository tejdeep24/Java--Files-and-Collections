package ex8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Search_cities {
	
	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/ex8/cities.txt";
	private Scanner scan;
	private String currentLine;
	private String cities[];
	private String key;
	private Map<String,List<String>> mp = new HashMap<String,List<String>>();
	private List<String> list;
	public Search_cities() {
		try {
			scan = new Scanner(new File(INPUT_FILE_PATH));
			while(scan.hasNext())
			{
				list = new ArrayList<String>();
				currentLine = scan.nextLine().trim();
				cities = currentLine.split(":|,");
				key=cities[0];
				for(int i=1;i<cities.length;i++)
				{
					list.add(cities[i]);
				}
				mp.put(key,list);
		}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Search_cities(-,-) Exception:" + e);
		}
	}
	private String search(String city)
	{
		String area = null;
		for(String entry:mp.keySet())
		{
			String key = entry.toString();
			if(key.equals(city))
			{
				area=mp.get(key).toString();
			}
		}
		return area;
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Search_cities obj = new Search_cities();
		System.out.println("Enter the city to search");
		String search_city = sc.next();
		String areas = obj.search(search_city);
		System.out.println("The areas in the searched city");
		try{
		if(areas.isEmpty())
		{
			System.out.println("City was Invalid...please check");
		}
		else{
		System.out.println(areas);
		}
		}
		catch(Exception e)
		{
			System.out.println("City was Invalid...please check");
		}

	}

}
