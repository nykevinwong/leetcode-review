import java.util.Arrays;
import java.util.PriorityQueue;

/*  @@DESCRIPTION
K Close Potins to Origin. 離原點最近的K個點.
*/
class KClosetPointstoOrigin implements IInterviewQuestion  {

    public int[][] KClosetPoints_Sort(int[][] points, int K) { // 用距離公式及排序       
        Arrays.sort(points, (p1, p2) -> (p1[0]*p1[0] +p1[1]*p1[1]) - (p2[0]*p2[0] +p2[1]*p2[1]) );
        // int[][] temp = new int[K];
        // for(int i=0;i<K;i++) temp[i]=points[i];
        // return temp;
        return Arrays.copyOfRange(points, 0, K); // 只要前K最近的點
    }

    public int[][] KClosetPoints_PQ(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(  
            (p1, p2) -> (p2[0]*p2[0] +p2[1]*p2[1]) - (p1[0]*p1[0] +p1[1]*p1[1])  );
        // 用最大堆積的N*Log(K)技巧取最小K個. 最大堆積，取資料時，是由大到小的順序取出.

        //N*lok(K) 技巧，將所有大於最小K個的值都取出不要.
        for(int[] p:points) 
        {
            pq.offer(p);
            if(pq.size() > K)  pq.poll();
        }
        // 留下的K個就是最小的K個，但最大堆積的存放順序是大到小的順序，需要反轉才是由小到大的順序。
        int[][] res = new int[K][2]; // 分配一組 K個座標大小的陣列
        while(K > 0) res[--K] = pq.poll(); // 反轉存入陣列
        return res; //傳回前K最近的點
    }
    //快速排序法改成O(N)快速排選法: 原理，先分割分組排序，然後用分割中點索引值判斷，
    public int[][] KClosetPoints_QSelect(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = partition(points, l, r);
//當前分割中點就是第k位,由於是零基底陣列，K左邊值的就是沒排序好的正確答案。            
            if (mid == K) break; 
            if (mid < K) {
                l = mid + 1; //快選右邊，縮左邊邊界.
            } else {
                r = mid - 1; // 快選左邊，縮右邊邊界.
            }
        }
        // 傳回答案，答案不是ascending order.
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] arr, int l, int r) {
        int[] pivot = arr[l];// (swap code part 1) 以左邊值為分割值，暫存分割值

        while (l < r) { // 在當前分割分組區間,而且l跟r不能相撞.
            // 右方陣列值大於分割值是合理的，繼續直到找出小於分割值的右陣列值。
            // 找不到時，r 最終等於l就停止.
            while (l < r && compare(arr[r], pivot) >= 0) r--; 
            arr[l] = arr[r]; // (swap code part 2) 該值換到arr[l]位置 
            // 左方陣列值(非軸值)大於分割值是合理的，繼續直到找出大於分割值的右陣列值。
            // 找不到時，l 最終等於r就停止.
            while (l < r && compare(arr[l], pivot) <= 0) l++;
            arr[r] = arr[l]; // (swap code part 3)
        } //若原陣列該區間已排序好，最後則換回來.

        arr[l] = pivot;//(swap code part 4) 當前l就是原始軸值應該在的位置
        return l;
    }
    
    private int compare(int[] p1, int[] p2) { // 排序的方式: 照距離由大至小
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }


    public void performTest()
    {
        System.out.println("KClosetPoints_Sort: " + Helper.arrayEquals(KClosetPoints_Sort(new int[][] { {-5,4}, {-6,-5}, {4,6} }, 2) , new int[][] { {-5, 4}, {4,6} } ) ) ;
        System.out.println("KClosetPoints_PQ: " + Helper.arrayEquals(KClosetPoints_PQ(new int[][] { {-5,4}, {-6,-5}, {4,6} }, 2) , new int[][] { {-5, 4}, {4,6} } ) );
        System.out.println("KClosetPoints_QSelect: " + Helper.arrayEquals(KClosetPoints_QSelect(new int[][] { {-5,4}, {-6,-5}, {4,6} }, 2) , new int[][] { {-5, 4}, {4,6} } ) );
    }

    
    public String toString() { 
        return "K Closest Points to Origin ([I] *)[https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.]";
    }
}
