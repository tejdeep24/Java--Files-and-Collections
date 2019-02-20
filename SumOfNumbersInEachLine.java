package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumOfNumbersInEachLine {
	
	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/ex1/numbers.txt";
	private static final String OUTPUT_FILE_PATH = "D:/Deepu/Inputfile/ex1/sum_numbers.txt";
	private static final String SEPARTOR = ",";
	
	private FileWriter writer;
	private Scanner scan;
	private StringBuffer sb = new StringBuffer();
	
	public SumOfNumbersInEachLine()
	{
		try{
			scan = new Scanner(new File(INPUT_FILE_PATH));
			writer = new FileWriter(OUTPUT_FILE_PATH);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("SumOfNumbersInEachLine() Ex:" + e);
		} catch (IOException e) {
			System.out.println("SumOfNumbersInEachLine() Ex:" + e);
		}
	}
	
	private void findSumLineWise(){
		int lineNumber=0;
		
		while(scan.hasNext())
		{
			lineNumber++;
			String currentLine = scan.nextLine().trim();
			if(currentLine.isEmpty())
			{
				continue;
			}
			String numbers[]= currentLine.split(SEPARTOR);
			int total = findTotal(numbers);
			printToFile(lineNumber,total,currentLine);
		}
		closeResources();
	}
	private void closeResources()
	{
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
		}
		scan.close();
	}
	private void printToFile(int lineNumber,int total,String currentLine)
	{
		sb.setLength(0);
		sb.append("Line:");
		sb.append(lineNumber);
		sb.append("\t");
		sb.append(currentLine.replaceAll(SEPARTOR,"+"));
		sb.append("=");
		sb.append(total);
		sb.append("\n");
		System.out.println (sb);
		try {
			writer.append(sb);
		} catch (IOException e) {
			System.out.println("SumOfNumbersInEachLine.printToFile(-,-) Exception:" + e);
		}	
	}
	private int findTotal(String numbers[])
	{
		int total=0;
		for(String number : numbers)
		{
			int num = Integer.parseInt(number);
			total = total + num;
		}
		return total;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		SumOfNumbersInEachLine obj = new SumOfNumbersInEachLine();
		obj.findSumLineWise();
		
	}

}
