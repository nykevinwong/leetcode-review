import java.io.*;
import java.util.*;

public class FourSum {
  
  static int[] findArrayQuadruplet(int[] arr, int s) {  


    for(int a =0; a < arr.length; a++)
      for(int b =a+1; b < arr.length; b++)
      {
        for(int c=b+1; c < arr.length; c++)
        {
            int sum = arr[a]+arr[b]+arr[c];        
            int index = binarySerach(arr, c+1, arr.length-1, s - sum);
            if(index!=-1)
            {
             
              return new int[] {arr[a], arr[b], arr[c], arr[index] };
            }
        }
      }
  
    
        return new int[] {-1};
  }
  
  public static int binarySerach(int[][] arr, int l, int r, int target)
  {
      while(l <= r)
      {
        int mid = l+(r-l)/2;
       
        
        if(target > arr[mid])
        {
          l=mid+1;
        }
        else if(target < arr[mid])
        {
          r=mid-1;
        }
        else
        {
          return mid;
        }
        
      }
    
      return -1;
  }

  
  public static void main(String[] args) {
    int[] res = findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20);
    System.out.println( Arrays.toString(res) );    
  }

}