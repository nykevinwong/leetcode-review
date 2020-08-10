import java.util.PriorityQueue;

/*  @@DESCRIPTION
Amazon 題: 連接所有繩子的最小成本
有一堆不同長度的繩子. 每次連接兩繩子的成本就是兩繩長度總和.
請問連接所有繩子的最小成本為何?
由於最小成本必定是要每次都只連接兩個最短繩子,解法是用最小堆積優先佇列存入所有繩長度.
每次取出兩最短繩長度相加. 新連成的繩子也可能還是最短繩之一,所以要把新繩子長度再放入佇列. 這樣一直計算下去，最後所有相加的總和就是最小成本。
*/

class MinimumCostToConnectRope implements IInterviewQuestion
{
    public int minCostToConnectRope(int[] ropes)
    {
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int len : ropes) { minHeap.add(len); }

        while(minHeap.size() > 1)
        {
            int combinedLen = minHeap.poll() + minHeap.poll();
            res += combinedLen;
            minHeap.offer(combinedLen);
        }

        return res;
    }

    public void performTest()
    {
        Helper.equals(minCostToConnectRope(new int[]{2, 4, 3}) , 14, "[2,4,3]: ");
        Helper.equals(minCostToConnectRope(new int[]{8, 4, 6, 12}) , 58, "[8,4,6,12]: ");
        Helper.equals(minCostToConnectRope(new int[]{2, 2, 3, 3}) , 20, "[2, 2, 3, 3]: ");
        Helper.equals(minCostToConnectRope(new int[]{1, 2, 5, 10, 35, 89}) , 224, "[1, 2, 5, 10, 35, 89]: ");

    }

    public String toString() { 
        return "Minimum Time to merge files/Minimum Cost to connect Ropes ([E]) [https://leetcode.com/discuss/interview-question/344677]";
    }
}