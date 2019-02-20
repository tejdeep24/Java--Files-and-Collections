import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class WordCount {

	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/Wordcount/data.txt";
	private Scanner scan;
	private String currentLine;
	private String words[];
	private Map<String,Integer> map = new HashMap<String,Integer>();
	private List<String> list = new ArrayList<String>();
	private void countWords()
	{
		try 
		{
			scan =new Scanner(new File(INPUT_FILE_PATH));
			while(scan.hasNext())
			{
				
				currentLine = scan.nextLine().trim();
				words = currentLine.split(" ");
				for(int i =0;i<words.length;i++)
				{
					//System.out.println(words[i]);
					list.add(words[i]);
				}
				for(int i =0;i<words.length;i++)
				{
					//System.out.println(words[i]);
					map.put(words[i],1);
				}
			}
			//System.out.println(Arrays.asList(list));
			//System.out.println(Arrays.asList(map));
			int count =0;
			for(String key : map.keySet())
			{
				for(String value :list)
				{
					if(key.equals(value))
					{
						count++;
					}
				}
				System.out.print(key+" "+count);
				count=0;
				System.out.println();
			}
			
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	
		WordCount obj = new WordCount();
		obj.countWords();
	}

}
