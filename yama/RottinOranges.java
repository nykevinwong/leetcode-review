import java.util.LinkedList;
import java.util.Queue;
/* @@DESCRIPTION
994. Rotting Oranges 爛橙子
給一個九宮格或更大的宮格.裡面有相鄰的橙子，也可能有不相鄰的橙子或沒有橙子。
每一分鐘，爛橙子會弄爛四方相鄰新橙子. 算出爛橙子弄爛所有橙子所需時間。不可能全部弄爛就傳回負一.
解法是使用廣度優先搜索，將爛橙子座標當成起始佇列元素. 計算新橙子個數。 每一佇列迴圈周期，針對所有欄橙子的四方查是否有新橙子，有就弄爛放入佇列，個數減一. 
所需分鐘加一. 如果新橙子不為零，代表不可能全部弄爛.
 
*/

public class RottinOranges  implements IInterviewQuestion {
    //https://leetcode.com/problems/rotting-oranges/
    // Zombie in Matrix: https://leetcode.com/discuss/interview-question/411357/
    // Minium hours to send file to all available servers
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        int count =0;
        // push source noddes
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2) q.offer(new Integer[] {i,j});
                if(grid[i][j]==1) count++;
            }
        
        if(count==0) return 0; // speicial case. no fresh orange at all from start.
        
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int time = -1;
        
        while(q.size() > 0)
        {
            int size = q.size();            
            for(int i=0;i<size;i++) // make sure to go through all nodes in current queue
            {
                Integer[] pos = q.poll(); // get position                        
                for(int j=0;j<dir.length;j++) // get adjacents of adjcent node.
                {
                    int nx= pos[0] + dir[j][0];
                    int ny =pos[1] + dir[j][1];

                    if(nx < 0 || ny < 0 || nx >= grid[0].length || ny >= grid.length) continue;
                    
                    if(grid[ny][nx]==1) // push an adjecent neighor which is a fresh orange in this case
                    { // in scoope
                        count--;
                        grid[ny][nx] = 2; // rotten the tomato, mark as visited
                        q.offer(new Integer[]{ny,nx}); 
                    }
                }      
            }
            
            time++;
        }
        
        return (count==0) ? time:-1; //-1 also means it's not possible to rotten every orange.
    }

    public void performTest()
    {
        Helper.equals(orangesRotting(new int[][] { {2,1,1},{1,1,0},{0,1,1} }), 4, "Min minutes to rotten all oranges: ");
        Helper.equals(orangesRotting(new int[][] { {2,1,1},{0,1,0},{1,0,1} }), -1, "Min minutes to rotten all oranges: ");
        Helper.equals(orangesRotting(new int[][] { {2,2,2},{0,2,0},{2,0,2} }), 0, "Min minutes to rotten all oranges: ");
    }

    public String toString() { return "Zombie in Matrix [Min hours to send file to all available servers] ([E]***):";}
}
