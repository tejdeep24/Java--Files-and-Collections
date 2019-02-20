package ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Multi_file_Creator {
	
	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/ex6/NASDAQ_daily_prices_J.csv";
	private static final String OUTPUT_FILE_PATH = "D:/Deepu/Inputfile/ex6/";
	private FileWriter writer;
	private File input_file;
	private Scanner scan;
	private Scanner scan1;
	private float noOfLines=0;
	private int BLOCK_SIZE=100;
	private StringBuffer sb = new StringBuffer();
	private String currentLine;
	public Multi_file_Creator() {
		
		try 
		{
			scan = new Scanner(new File(INPUT_FILE_PATH));
			while(scan.hasNext())
			{
				scan.next();
				noOfLines++;	
			}
			System.out.println(noOfLines);
			double noOfParts= Math.ceil((noOfLines/BLOCK_SIZE));
			System.out.println(noOfParts);
			
			scan1 = new Scanner(new File(INPUT_FILE_PATH));
			while(scan1.hasNext())
			{
				for(int i =1;i<=noOfParts;i++)
				{
					writer = new FileWriter(OUTPUT_FILE_PATH+"Part"+i+".txt");
					for(int j=0;j<BLOCK_SIZE;j++)
					{
						try{
						currentLine=scan1.nextLine();
						}
						//System.out.println(currentLine);
						
						catch(NoSuchElementException e)
						{
							System.out.println("File ended");
							break;
						}
						sb.setLength(0);
						sb.append(currentLine);
						sb.append("\n");
						System.out.println(sb);
						writer.append(sb);
					}
					writer.close();
					
					//System.out.println("hii");
				}
				
			}
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	private void readFile()
	{
		
	}
	public static void main(String[] args) {
		
		Multi_file_Creator obj = new Multi_file_Creator();
		obj.readFile();

	}

}
