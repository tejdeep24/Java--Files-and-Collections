package MonthlyAmountCreditInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MonthlyMessageInfo {

	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/MonthlyBill/message.txt";
	
	private Scanner scan;
	private String currentLine;
	private List<SalaryBean> list = new ArrayList<SalaryBean>();
	SalaryBean SB;
	private Date date;
	private Map<Integer,Float> map;
	private List<Map<Integer,Float>> li;
	private Map<String,List<Map<Integer,Float>>> map1=new HashMap<String,List<Map<Integer,Float>>>();
	public MonthlyMessageInfo()
	{
		try
		{
			scan = new Scanner(new File(INPUT_FILE_PATH));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	private void readMessageFile()
	{
		while(scan.hasNext())
		{
			currentLine = scan.nextLine().trim();
			float amount =Float.parseFloat(currentLine.substring(currentLine.indexOf("Rs")+2,currentLine.indexOf("on")));
			try 
			{
				date =new SimpleDateFormat("dd-MMM-yyyy").parse(currentLine.substring(currentLine.indexOf("on")+2));
			}
			catch(ParseException e){
				e.printStackTrace();
			}
			SB = new SalaryBean();
			SB.setSalary(amount);
			SB.setDate(date);
			list.add(SB);
		}
		Collections.sort(list,new SalaryBean());
		String prevm =" ";
		for(int i=0;i<list.size();i++)
		{
			SalaryBean sb = list.get(i);
			Date d = sb.getDate();
			float amount = sb.getSalary();
			@SuppressWarnings("deprecation")
			int month = d.getMonth();
			String months [] ={"Jan","Feb","March","April","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
			String Month_name = months[month];
			@SuppressWarnings("deprecation")
			int day = d.getDate();
			String currm = Month_name;
			map = new HashMap<Integer,Float>();
			map.put(day,amount);
			if(prevm.equals(" ") || !(prevm.equals(currm)))
			{
				li=new ArrayList<Map<Integer,Float>>();
				li.add(map);
				map1.put(Month_name,li);
			}
			else
			{
				li.add(map);
				map1.put(Month_name,li);
			}
			prevm=currm;
		}
		System.out.println(map1);
		printAmountDetails();
	}
	private void printAmountDetails()
	{
		System.out.println("Month wise total credited amount");
		float amount = 0;
		for(Entry<String,List<Map<Integer,Float>>> entry:map1.entrySet())
		{
			String month =entry.getKey();
			List<Map<Integer,Float>> list =entry.getValue();
			for(int i=0;i<list.size();i++)
			{
				Map<Integer,Float> map =list.get(i);
				for(Entry<Integer,Float> entry1:map.entrySet())
				{
					amount = amount+entry1.getValue();
				}
			}
			System.out.print(month+" "+"-->"+amount);
			System.out.println();
			amount=0;
		}
	}
	public static void main(String[] args) {
		MonthlyMessageInfo obj = new MonthlyMessageInfo();
		obj.readMessageFile();
	}

}
