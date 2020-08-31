import java.util.*;
/*
  [1,2,3] 有多少子陣列?
  形公式可求出: (1+3)*3/2 = 6
  子陣列: [1], [2], [3], [1,2], [2,3], [1,2,3]
  也可用執行樹狀態圖(backtracking 來畫):
  在[1,3]區間中，只包含[3]的子陣列數量 count([3])= f([1,3]) - f([1,2]) = 6 - (1+2)*2/2 = 6-3 = 3
  在[1,2]區間中，只包含[2]的子陣列數量 count([2])= f([1,2]) - f([1,1]) = 3 - 1 = 2
  https://math.stackexchange.com/questions/1941224/number-of-occurrences-in-contiguous-subarrays
*/
class SubarraysWithKDifferentIntegers implements IInterviewQuestion
{
    //Longest SubString With K Distinct Characters
    //要了解該程式，必須懂得解 
    //傳回陣A所有子陣列中，剛有k個種類的數字的子陣列數量.
    public int subarraysWithKDistinct(int[] A, int K) {        
        CategoryCounter<Integer> w1 = new CategoryCounter<Integer>();
        CategoryCounter<Integer> w2 = new CategoryCounter<Integer>();
        int left1=0, left2 =0;
        int count = 0;
        
        for(int i=0;i < A.length;++i)
        {
            int x = A[i];
            w1.add(x);
            w2.add(x);
            
            //當前i位置就有K+種類，移除當前left1位置的字母來更新種類數直至w1只有K種.
            //w1 此時的  [left1, i] 的區間包括K種類及K以下種類的子區間
            while(w1.kinds() > K ) w1.remove(A[left1++]);

            //當前i位置就有K+種類，移除當前left2位置的字母來更新種類數直至w2只有K-1種.
            //w2 此時的 [left2, i] 的區間包括K-1及K-1以下種類的子區間
            while(w2.kinds() >= K ) w2.remove(A[left2++]);
            
            // w1區間長度 - w2區間長度 = 只有包含K種類區間的子陣列數目 
            count+= left2-left1;            
        }
        
        return count;
    }

    public void performTest()
    {
        Helper.equals( subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2) , 7, "{1,2,1,2,3} = ");
        Helper.equals( subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3) , 3, "{1,2,1,3,4} = ");

    }

    public String toString() { 
        return "Subarrays with K Different Integers (*) [https://leetcode.com/problems/subarrays-with-k-different-integers/]";
    }

 }
