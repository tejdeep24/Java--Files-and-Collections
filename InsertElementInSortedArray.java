
public class InsertElementInSortedArray {

	public static void main(String[] args) {
		
		int A[]={1,5,8,10,20,34,57,69,81};
		int B[]={12,3,7};
		int C[] = new int[A.length+B.length];
		int temp;
		for(int i=0;i<A.length;i++)
		{
			C[i]=A[i];
		}
		for(int j=0;j<B.length;j++)
		{
			C[A.length+j] = B[j];
		}
		System.out.println("Sorted Elements of C");
		for(int k=0;k<C.length;k++)
		{
			for(int m=k+1;m<C.length;m++)
			{
				if(C[k] > C[m])
				{
				temp = C[k];
				C[k] = C[m];
				C[m] = temp;
				}
			}
		}
		for(int l=0;l<C.length;l++)
		{
			System.out.print(C[l]+" ");
		}
	}

}
