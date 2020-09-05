import java.util.LinkedList;
import java.util.Queue;

class TreasureIsland2 implements IInterviewQuestion
{   //求從某起點至其中一個終點的最短步數
    public int minimumRoute(char[][] maze)
    {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][] { {0,1}, {0,-1}, {1,0}, {-1,0} };

        // 將起始節點存入廣優搜佇例
        for(int i=0;i< maze.length;i++)
        {
            for(int j=0; j < maze[0].length;j++)
            {
                if(maze[i][j]=='S')//如果是起始點，可以有多個. 
                {
                    q.add(new int[] {j, i});
                }
            }
        }
        
        int count = 0;
        while(q.size() > 0)
        {
            int size = q.size();//針對當前佇例的所有節點先處理，記錄要處理的當前節點量

            for(int i=0;i<size;i++) //針對當前佇例的所有節點先處理
            {
                int[] pos = q.poll();//取出節點
                for(int k=0;k<dir.length;k++) // 針對節點的四或八方向的鄰接節點處理
                {
                    int nx = pos[0] + dir[k][0];
                    int ny = pos[1] + dir[k][1];
                    // 不在網格內的座標，是不存在任何鄰接節點的，要跳過。
                    if(nx <0 || nx >= maze[0].length || ny <0 || ny >= maze.length) continue;

                    if(maze[ny][nx]=='O') // 如果是未訪問過的節點
                    {
                        maze[ny][nx] = 'D'; // 設成訪問過
                        q.add(new int[] {nx, ny });// 記錄該節點，好下次處理該節點的鄰節接點.
                    }
                    else if(maze[ny][nx]=='X') //如果是終點標記
                    {
                        return count; 
                    }
                }
            }

            count++; //每批次處理當前節點後，等於廣優搜執行一次，也等於步數.
        }

        return count;
    }

    public void performTest()
    {
        int minStep = minimumRoute(new char[][] {
            {'S','O','O','S','S'}, // S:起點
            {'D','O','D','O','D'}, // x:終點
            {'O','O','O','O','O'}, // O: 可走的路
            {'X','D','D','O','O'}, // D:路障或已走的路
            {'X','D','D','D','O'},
        });

        System.out.println("Min Steps: " + minStep);
    }
    
    public String toString() { return "Treasure Island 2 [https://leetcode.com/discuss/interview-question/356150]: ";}
}
