import java.util.LinkedList;
import java.util.Queue;
/* @@DESCRIPTION
994. Rotting Oranges 爛橙子
0 = 沒橙子在此， 1 = 爛橙子在此, 2 = 好橙子在此,
給一個九宮格或更大的宮格.裡面有相鄰的橙子，也可能有不相鄰的橙子或沒有橙子。
每一分鐘，爛橙子會弄爛四方相鄰新橙子. 算出爛橙子弄爛所有橙子所需時間。不可能全部弄爛就傳回負一.
解法是使用廣度優先搜索，將爛橙子座標當成起始佇列元素. 計算新橙子個數。 每一佇列迴圈周期，針對所有欄橙子的四方查是否有
新橙子，有就弄爛放入佇列，個數減一，所需分鐘加一. 如果某個好橙子不鄰接任何爛橙子，代表不可能全部弄爛. 
*/

public class RottinOranges  implements IInterviewQuestion {
    //https://leetcode.com/problems/rotting-oranges/
    // Zombie in Matrix: https://leetcode.com/discuss/interview-question/411357/
    // Minium hours to send file to all available servers
    public int orangesRotting(int[][] grid) {
        //使用廣優搜，必須用佇列(隊列)
        Queue<Integer[]> q = new LinkedList<>();
        int initalFreshOrangeCount =0; // 初始好橙子數
        // 設定廣優搜起點，遍歷整個網格
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
            {   // 以爛橙子當做廣優搜起點
                if(grid[i][j]==2) q.offer(new Integer[] {i,j});
                if(grid[i][j]==1) initalFreshOrangeCount++;//計算網格上的初始初始好橙子數
            }
        
        if(initalFreshOrangeCount==0) return 0; // 特別狀況(邊角案例)，沒有好橙子。不需要繼處理.
        // 四方向陣列
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        // 如果一開始沒有任何好橙子只有爛橙子，等於0分鐘就全爛了.
        // 如果一開始有一個好橙子及鄰接的一個爛橙子，當前爛橙子弄爛好橙子後，該新的爛橙子會在佇列。
        // 最後一次新的爛橙子組，沒有鄰接的好橙子弄爛，該次是不能計算。用-1來初始才是正確的.
        int time = -1; 
        
        while(q.size() > 0) // 還有爛橙子的話
        {
            int size = q.size(); //當前爛橙子數
            for(int i=0;i<size;i++) // 遍歷所有當前爛橙子組
            {
                Integer[] pos = q.poll(); // 取出當前爛橙子                        
                for(int j=0;j<dir.length;j++) // 查看當前爛橙子的鄰接節點是否有好橙子
                {  // 計算當前鄰接位置
                    int nx= pos[0] + dir[j][0];
                    int ny =pos[1] + dir[j][1];
                    //當前鄰接位置必須在網格內 
                    if(nx < 0 || ny < 0 || nx >= grid[0].length || ny >= grid.length) continue;
                    
                    if(grid[ny][nx]==1) // 當前鄰接位置有好橙子
                    { 
                        grid[ny][nx] = 2; // 弄爛當前好橙子，將好橙子設成爛橙子
                        initalFreshOrangeCount--;// 好橙子變少一個
                        q.offer(new Integer[]{ny,nx}); //存入當前爛橙子位置，好再下次弄爛其鄰接節點好橙子.
                    }
                }      
            }
            
            time++;
        }
        
        //初始好橙子數為零，代表全被弄爛了。
        return (initalFreshOrangeCount==0) ? time:-1; //-1 also means it's not possible to rotten every orange.
    }

    public void performTest()
    {
        Helper.equals(orangesRotting(new int[][] { {2,1,1},{1,1,0},{0,1,1} }), 4, "Min minutes to rotten all oranges: ");
        Helper.equals(orangesRotting(new int[][] { {2,1,1},{0,1,0},{1,0,1} }), -1, "Min minutes to rotten all oranges: ");
        Helper.equals(orangesRotting(new int[][] { {2,2,2},{0,2,0},{2,0,2} }), 0, "Min minutes to rotten all oranges: ");
    }

    public String toString() { return "Zombie in Matrix [Min hours to send file to all available servers] ([E]***):";}
}
