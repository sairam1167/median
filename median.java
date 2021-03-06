package simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class csvreader 
{
	  public static void main(String args[]) throws FileNotFoundException
	    {
	        
	    	 FileReader file = new FileReader( "C:\\sairam\\masters\\3rd sem Fall_2020\\Analysis of algoritham\\project 1\\datafile.csv" );
		        int arr[] = new int [2001];
		        int i=0;
		        try {
		            Scanner input = new Scanner(file);
		            while(input.hasNext())
		            {
		                arr[i] = input.nextInt();
		                i++;
		            }
		            input.close();
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		    
	            median.findMedian(arr);
	    }
	
	
    static void findMedian(int arr[])
   {
        int median = MedianU(arr,(arr.length)/2 + 1,0,arr.length-1);
    }
    
     static int MedianU(int arr[],int k,int x,int y)
    {
        
        
        if(x == y)
        {
            return arr[x];
        }
        
        int m = partition(arr,x,y);
        
        int length = m - x + 1;
        
      
        if(length == k)
        {
            return arr[m];
        }
        
       
        if(length > k)
        {
            return MedianU(arr,k,x,m-1);
        }
        
        else
        {
            return MedianU(arr,k-length,m+1,y);
        }
        
    }
    
     static int partition(int arr[],int x, int y)
    {
      
        int pivotValue = getPivotValue(arr, x, y);        
        
        
        while(x < y)
        {
            while(arr[x] < pivotValue)
            {
                x ++;
            }
            
            while(arr[y] > pivotValue)
            {
                y--;
            }
            
            if(arr[x] == arr[y])
            {
                x ++;
            }
            else if(x < y)
            {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
                
        }
        return y;
    }
     
     static int getPivotValue(int arr[],int x,int y)
       {
     
        if(x-y+1 <= 9)
        {
            Arrays.sort(arr);
            return arr[arr.length/2];
        }
        int temp[] = null;
        int medians[] = new int[(int)Math.ceil((double)(y-x+1)/5)];
        int medianIndex = 0;
        
        while(x <= y)
        {
            
            temp = new int[Math.min(5,y-x+1)];
            
            
            for(int j=0;j<temp.length && x <= y;j++)
            {
                temp[j] = arr[x];
                x++;
            }
            Arrays.sort(temp);
            medians[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }
        return getPivotValue(medians,0,medians.length-1);
       }
    
     
     static void printArray(int arr[],int x, int y)
     {
      System.out.print("[  ");
      for(int i=x;i<y;i++)
      {
         System.out.print(arr[i] + "  ");
      }
      
      System.out.println("]");
      }	
	 	} 
  
   
	