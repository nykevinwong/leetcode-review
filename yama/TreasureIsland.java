import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreasureIsland implements IInterviewQuestion
{   //求並印出一起點至一終點的最短路徑
    public List<int[]> minimumRoute(char[][] maze)
    {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dir = new int[][] { {0,1},{1,0},{ 0,-1},{-1,0}}; //四鄰接方向的位置
        q.offer(new int[]{0,0}); // 將起始節點存入廣優搜佇例
        maze[0][0]= (char)count++; // 用步數值標記成訪問過

        while(q.size() > 0)
        {
            int size = q.size(); //針對當前佇例的所有節點先處理，記錄要處理的當前節點量
            for(int i=0;i<size;i++) //針對當前佇例的所有節點先處理
            {
                int[] pos = q.poll(); //取出節點
             
                for(int j=0;j<dir.length;j++) // 針對節點的四或八方向的鄰接節點處理
                {
                    int nx = pos[0] + dir[j][0];
                    int ny = pos[1] + dir[j][1];
                    // 不在網格內的座標，是不存在任何鄰接節點的，要跳過。
                    if(nx < 0 || nx >= maze[0].length || ny < 0 || ny >= maze.length) continue;

                    if(maze[ny][nx]=='O') // 如果是未訪問過的節點
                    {
                        maze[ny][nx]= (char)count; // 用步數值標記成訪問過
                        q.offer(new int[] {nx,ny}); // 將該節點放入佇例，好下次處理該節點的鄰節接點.
                    }
                    else if(maze[ny][nx]=='X') //如果是終點節點
                    { // found the target
                        System.out.println("Steps: " + (count)); //輸出需要的步數
                        // 用該陣列製作起點到終點的座標路徑圖
                        List<int[]> res = createSolution(maze, pos[0], pos[1]);  
                        return res;
                    }
                }

            }
            count++;
        }

        return null;        
    }

    public List<int[]> createSolution(char[][] maze, int lastX, int lastY)
    {
        List<int[]> res = new ArrayList<>();
        Stack<int[]> s = new Stack<>();
        System.out.println("Creating the solution.");
        s.push(new int[] {lastX,lastY} );
        int count = (int)(maze[lastY][lastX]);
        count--;
        
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                System.out.print(((char)(maze[i][j]+'0')) + "|");
            }
            System.out.println();
        }

        while(count >= 0)
        {
            int[][] dir = new int[][] { {0,1},{1,0},{ 0,-1},{-1,0}};
            for(int i=0;i<dir.length;i++)
            {
                int nx = lastX + dir[i][0];
                int ny = lastY + dir[i][1];
                if(nx < 0 || nx >= maze[0].length || ny < 0 || ny >= maze.length) continue;
                if((int)maze[ny][nx]==count) 
                {
                    s.push(new int[] {nx, ny});
                    lastX = nx; lastY = ny;
                    count--;
                    break;
                }
            }
        }

        while(!s.isEmpty()) { res.add(s.pop()); };
        
        return res;
    }

    public void performTest()
    {
        List<int[]> res = minimumRoute(new char[][] {
            {'O','O','O','O'},
            {'D','O','D','O'},
            {'O','O','O','O'},
            {'X','D','D','O'},
        });

        for(int[] pos: res)
        {
            System.out.print("(" + pos[1] + "," + pos[0] + ") ,");
        }
        System.out.println();
    }
    
    public String toString() { return "Treasure Island ([I]**) [https://leetcode.com/discuss/interview-question/347457]: ";}

}