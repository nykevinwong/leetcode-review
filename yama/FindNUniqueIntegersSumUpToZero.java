import java.util.*;

class FindNUniqueIntegersSumUpToZero implements IInterviewQuestion {
    // 給一個陣列的長度，找出讓此陣列所有整數元素總和為零的整數值
    public int[] sumZero(int n) {
        
        int half = n/2; // 將陣列砍半，自己來設值
        int[] arr = new int[n];
        for(int i=0;i< half;i++)
        {
            arr[i]=-(n-i); // 左半是負值
            arr[n-i-1]= (n-i); // 右半是正值，全部相加為零。
        }
                    
        return arr;
    }

    public void performTest()
    {
        for(int i=0;i<5;i++)
        {
            int n = (int)(Math.random()*20+1);
            int[] res = sumZero(n);
            // 將res陣列每個值都相加成一個總和，第一及第二相加。總和加第三，以此類推。
            int sum = Arrays.stream(res).reduce(0, (a,b) -> a + b);
            System.out.println("n:" + n  + ", " + Arrays.toString(res) + ", sum = 0 ? => " + (sum==0));            

        }

    }

    public String toString() { 
        return "Subarrays with K Different Integers (*) [https://leetcode.com/problems/subarrays-with-k-different-integers/]";
    }
}