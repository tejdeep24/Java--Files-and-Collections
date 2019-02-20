package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SumOfNumbersLineWiseInAllFiles {
	
	private static final String INPUT_FILE1_PATH = "D:/Deepu/Inputfile/ex2/number1.txt";
	private static final String INPUT_FILE2_PATH = "D:/Deepu/Inputfile/ex2/number2.txt";
	private static final String OUTPUT_FILE_PATH = "D:/Deepu/Inputfile/ex2/sum_numbers.txt";
	private static final String SEPARTOR = ",";

	private FileWriter writer;
	private Scanner scan1,scan2;
	private StringBuffer sb = new StringBuffer();
	private HashMap<Integer,Integer> hs1 =new HashMap<Integer,Integer>();
	private HashMap<Integer,Integer> hs2 =new HashMap<Integer,Integer>();
	public SumOfNumbersLineWiseInAllFiles() {
		
		try{
		scan1 = new Scanner(new File(INPUT_FILE1_PATH));
		scan2 = new Scanner(new File(INPUT_FILE2_PATH));
		writer = new FileWriter(OUTPUT_FILE_PATH);
		}
		catch(FileNotFoundException e){
			System.out.println("SumOfNumbersLineWiseInAllFile ex:"+ e);
		}
		catch(IOException e)
		{
			System.out.println("SumOfNumbersLineWiseInAllFile ex:"+ e);
		}
	}
	
	
	
	private void findSumLineWiseInAllFiles()
	{
		int lineNumber1=0;
		int lineNumber2=0;
		String numbers1[] = null;
		String numbers2[] = null;
		String numbers3[] = null;
		String currentLine1 = null;
		String currentLine2 = null;
		int total=0;
		while(scan1.hasNext())
		{
			lineNumber1++;
			currentLine1 = scan1.nextLine().trim();
			//System.out.println(currentLine1);
			if(currentLine1.isEmpty())
			{
				continue;
			}
			numbers1= currentLine1.split(SEPARTOR);
			while(scan2.hasNext()){
				lineNumber2++;
				currentLine2 = scan2.nextLine().trim();
				//System.out.println(currentLine2);
				if(currentLine2.isEmpty())
				{
					continue;
				}
					numbers2=currentLine2.split(SEPARTOR);
						total=findTotal(numbers1,numbers2);
						int count = numbers1.length + numbers2.length;
						printToFile(lineNumber1,total,count);
						break;		
			}
			if(scan2.hasNext()== false && lineNumber1 != lineNumber2)
			{
				total=findTotal(numbers1);
				int count = numbers1.length;
				printToFile(lineNumber1,total,count);
			}
		}
		while(scan2.hasNext()){
			lineNumber2++;
			currentLine2 = scan2.nextLine().trim();
			if(currentLine2.isEmpty())
			{
				continue;
			}
				numbers3=currentLine2.split(SEPARTOR);
					total=findTotal(numbers3);
					int count = numbers3.length;
					printToFile(lineNumber2,total,count);
					
		}
	}
	
	private void closeResources()
	{
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
		}
	}
	
	private void printToFile(int lineNumber,int total,int count)
	{
		
		sb.setLength(0);
		sb.append("Line:");
		sb.append(lineNumber);
		sb.append("=");
		sb.append("\t");
		sb.append(total);
		sb.append("\n"); 
		hs1.put(lineNumber,total);
		hs2.put(lineNumber,count);
		System.out.println(sb);
		try {
			writer.append(sb);
		} catch (IOException e) {
			System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
		}
			
	}
	private int findTotal(String[] numbers1,String[] numbers2)
	{
		int total=0;
		for(String number : numbers1)
		{
			int num = Integer.parseInt(number);
			total = total + num;
		}
		for(String number : numbers2)
		{
			int num = Integer.parseInt(number);
			total = total + num;
		}
		return total;
		
	}
	private int findTotal(String numbers3[])
	{
		int total=0;
		for(String number : numbers3)
		{
			int num = Integer.parseInt(number);
			total = total + num;
		}
		return total;
		
	}
	private void findHighestTotal()
	{
		sb.setLength(0);
		sb.append("Line:");
		int maxValueInMap = Collections.max(hs1.values());
		for(Entry<Integer,Integer> entry: hs1.entrySet())
		{
			if(entry.getValue().equals(maxValueInMap))
			{
				sb.append(entry.getKey());
			}
		}
		sb.append("=");
		sb.append("\t");
		sb.append(Collections.max(hs1.values()));
		sb.append("\t");
		sb.append("holds the highest value.");
		sb.append("\n");
		System.out.println (sb);
			try {
				writer.append(sb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
			}
	}
	private void findMaxNumbers()
	{
		sb.setLength(0);
		sb.append("Line:");
		int maxValueInMap = Collections.max(hs1.values());
		for(Entry<Integer,Integer> entry: hs1.entrySet())
		{
			if(entry.getValue().equals(maxValueInMap))
			{
				sb.append(entry.getKey());
			}
		}
		sb.append("=");
		sb.append("\t");
		sb.append(Collections.max(hs2.values()));
		sb.append("\t");
		sb.append("contains Maximum numbers");
		sb.append("\n");
		System.out.println (sb);
		try {
			writer.append(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
		}
		closeResources();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumOfNumbersLineWiseInAllFiles obj = new SumOfNumbersLineWiseInAllFiles();
		obj.findSumLineWiseInAllFiles();
		obj.findHighestTotal();
		obj.findMaxNumbers();

	}

}
