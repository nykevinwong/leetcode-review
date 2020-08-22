import java.util.*;

class MergeIntervals implements IInterviewQuestion
{
    public int[][] merge(int[][] intervals) {
        // 空值或只有一個元素時，不用合併。原始陣列就是答案.
		if (intervals== null || intervals.length <= 1) return intervals;

		// 區間排序用起點排，若兩起點相等，用終點排序。
		Arrays.sort(intervals, (i,j) -> i[0]==j[0] ? i[1]-j[1]:i[0]-j[0]);

		LinkedList<int[]> llRes = new LinkedList<>();//方便快速插入刪除的資料結構
		llRes.add(intervals[0]); // 標兵,簡化邏輯,減少程式碼檢查
        
		for (int i=1;i < intervals.length;i++) {
            int[] merged = llRes.getLast();   
            //上面排序後，前起點必定小於當前起點.                     
			if (intervals[i][0] <= merged[1])// 前個終點大於當前起點，兩區間相交(overlapped)
            { // 已知排序後，合併區間
				merged[1] = Math.max(merged[1], intervals[i][1]); 
                // 將最後一個換成合併好的區間.
                llRes.removeLast(); 
               llRes.addLast(merged);
            }
			else { // 不相交區間 disjoint intervals                          
				llRes.add(intervals[i]);
			}
		}
        //轉換linked List成陣列
		return llRes.toArray(new int[llRes.size()][]);
    }

    public void performTest()
    {
        int[][] res = merge(new int[][] { {1,3},{2,6},{8,10},{15,18} });
        Helper.arrayEquals(res, new int[][] { {1,6}, {8,10}, {15,18} } );
    }

    public String toString() { 
        return "Merge Intervals (*) [https://leetcode.com/problems/merge-intervals/]";
    }
}
