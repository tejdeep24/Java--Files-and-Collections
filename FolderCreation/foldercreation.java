package FolderCreation;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class foldercreation{

	private static final String File_Path = "D:/Deepu/Inputfile/data";
	private File file;
	private int customerId;
	private String folders;
	private String Folders[];
	private Map<Integer,String> map  = new HashMap<Integer,String>();
	
	private void createFolder()
	{
		map.put(101,"images,documents");
		map.put(102,"images,videos");
		map.put(103,"documents");
		map.put(104,"images,videos,personal");
		for(Entry<Integer,String> entry:map.entrySet())
		{
			customerId = new Integer(entry.getKey());
			folders = entry.getValue();
			Folders = folders.split(",");
			for(int i =0;i<Folders.length;i++)
			{
				file = new File(File_Path+"/"+customerId+"/"+Folders[i]);
				if(!file.exists())
				{
					if(file.mkdirs())
					{
						System.out.println("Sub Directroies for"+customerId+"created");
					}
				}
			}
			updateDataBase(customerId);
		}
	}
	private void updateDataBase(int customerId)
	{
		System.out.println("All Folders for "+customerId+" successfully created");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		foldercreation obj = new foldercreation();
		obj.createFolder();
	}

}
