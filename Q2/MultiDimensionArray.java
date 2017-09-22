package arrays;


public class MultiDimensionArray {


	 private int x[][] = new int[5][];
	
	
	 public static long getValue(int... indexOfDimension) {
	        //... 
				 
			int value = 0;
			for(int i=0; i<indexOfDimension.length; i++)
			{
				value = value+ indexOfDimension[i];
					
			}
			
			System.out.println("value  is: "+value );
	        return value;
	    }
	 
	  public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
		   // Your resolution 
		   // Time complexity:  
		   // Space complexity:
		  int xSize =0;
		  long sum = 0;
		  for(int i =0; i<lengthOfDeminsion.length; i++)
		  {
			 sum = sum+getValue(populate(mArray, lengthOfDeminsion[i], xSize)); 
			 if(xSize >=5)
				 break;
			 xSize++;
			 
		  }
		  System.out.println("Sum is: "+sum);
		    return sum;
		    }
		 
	
	  private static int [] populate(MultiDimensionArray mArray, int i, int xSize) {
		// TODO Auto-generated method stub
		  
		  mArray.x[xSize] = new int[i];
		 for( int j = 0; j<i; j++)
			 {
			  
			 	mArray.x[xSize][j] = 1;
			 }
		return mArray.x[xSize];
	}

	public static void main(String[] args)
	  {
		MultiDimensionArray mArray = new MultiDimensionArray();
		int [] lengthOfDeminsion = {1,4,2,6,8};
		
		  Long result = sum(mArray,lengthOfDeminsion);
		  System.out.println("Result is : " + result);
	     
	  }


}