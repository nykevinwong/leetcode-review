import java.io.*;
import java.util.*;

public class FourSum {
  
  static int[] findArrayQuadruplet(int[] arr, int s) {  
    int len = 0;
    int[][] lookup = new int[arr.length * arr.length][];
        

    for(int c =0 ; c < arr.length;c++)
      for(int d =c+1; d < arr.length;d++)
      {
        lookup[len++] = new int[] { c, d, arr[c], arr[d]};
      }
    
    // N^2 * log(N^2)
    Arrays.sort(lookup, (i, j) -> (i[2]+i[3])-(j[2]+j[3]) );
    /*
    for(int a =0; a < arr.length; a++)
      for(int b =a+1; b < arr.length; b++)
      {
        int sum = arr[a]+arr[b];        
        int index = binarySerach(lookup, 0, len, s - sum);
        if(index!=-1)
        {
          int[] res = lookup[index];
          return new int[] {arr[a], arr[b], res[2], res[3] };
        }
      }
    */
    
        return new int[] {-1};
  }
  
  public static int binarySerach(int[][] arr, int l, int r, int target)
  {
      while(l <= r)
      {
        int mid = l+(r-l)/2;
        int midValue = arr[mid][2]+arr[mid][3];
        
        if(target > midValue)
        {
          l=mid+1;
        }
        else if(target < midValue)
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