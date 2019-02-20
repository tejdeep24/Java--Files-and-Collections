package ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Collections_FileHandling {
	
	private File f;
	private FileWriter writer;
	private Scanner scan;
	private String filenames[];
	private Set<String> st = new HashSet<String>();
	private StringBuffer sb = new StringBuffer();
	private static final int Split_size = 20;
	@SuppressWarnings({ "hiding" })
	public void readFilesInDirectory(String InputDirectory)
	{
		String INPUT_DIRECTORY = InputDirectory;
		f = new File(INPUT_DIRECTORY);
		filenames=f.list();
		for(int i=0;i<filenames.length;i++)
		{
			try {
				scan = new Scanner(new File(INPUT_DIRECTORY+"/"+filenames[i]));
				while(scan.hasNext())
				{
					String currentLine = scan.nextLine().trim();
					st.add(currentLine);
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Collections_FileHandling.readFilesInDirectory(-,-) Exception:"+e); 
			}
			catch (IOException e) {
				System.out.println("Collections_FileHandling.readFilesInDirectory(-,-) Exception:"+e);
			}
		}
		Iterator<String> it = st.iterator();
		int count =0;
		System.out.println(st.size());
		int i=1;
		while(i<=st.size())
		{
			count++;
			try {
				writer = new FileWriter(INPUT_DIRECTORY+"/"+"emailOutput"+count+".xls");
				}
			catch (IOException e) {
				e.printStackTrace();
				}
			for(int j=1;j<=Split_size;j++)
			{
				try{
				sb.append(it.next());
				sb.append("\n");
				}
				catch(Exception e)
				{
					System.out.println("Email list ended");
					break;
				}
			}
			try {
				writer.append(sb);
			} catch (IOException e) {
				e.printStackTrace();
			}
			closeResources();
			i = i+Split_size;
			sb.setLength(0);
		}
		
	}
	private void closeResources()
	{
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Collections_FileHandling.closeResources(-,-) Exception:" + e);
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collections_FileHandling obj = new Collections_FileHandling();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Directory path");
		String path = sc.next();
		obj.readFilesInDirectory(path);
	}

}
