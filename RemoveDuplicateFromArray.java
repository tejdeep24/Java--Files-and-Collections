
public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
	
		int array[] = { 1,5,6,12,3,1,5,7,4,2,6,9 };// array of ten    
		int size = array.length;
		System.out.println("Size before deletion: " + size);
		for (int i = 0; i < size; i++) 
		{
			for (int j = i + 1; j < size; j++) 
			{
				if (array[i] == array[j]) 
				{
					while (j < (size) - 1) 
					{
						array[j] = array[j + 1];// shifting the values
						j++;
					}
					size--;
				}
			}
		}
		System.out.println("Size After deletion: " + size);
		for (int k = 0; k < size; k++) 
		{
		System.out.print(array[k]+" "); // printing the values
		}
	}

}
