
// 
public class NumberOfClusters implements IInterviewQuestion {
    // questions: https://www.glassdoor.com/Interview/Problem-2d-grid-each-node-has-1-colors-find-number-of-clusters-of-a-given-color-red-blue-green-blue-gre-QTN_2930567.htm
    // https://leetcode.com/problems/number-of-islands/
    public int[] numberOfClusters(char[][] grid) {
        //設定顏色及該顏色群集(色塊)數量的位置
        char[] colors = new char[] {'0','1','2'};
        int[] count = new int[] { 0,0,0};

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {   //沒必要訪問已訪問的節點
                if(grid[i][j]=='v') continue; 

                for(int k=0;k<colors.length;k++)
                {   //針對未訪問的位置，遍歷同一顏色來計算該顏色群集數
                     if(grid[i][j]==colors[k]) 
                    {
                        dfs(grid, i, j, colors[k]);
                        count[k]++;//計算該顏色群集數
                        break; //當前節點己訪問,且是該顏色，沒必要查其它顏色
                    }
                }
            }
        }

      //  System.out.println("counts: " + Arrays.toString(count));
        return count;
    }
    
    public void dfs(char[][] grid, int y, int x, char target)
    {   // 不在grid範圍內的不用查。
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length ) return;        
        if(grid[y][x]!= target) return;// 非要查的顏色不用深度遍歷
        
        grid[y][x]= 'v'; // 將該位置或節點設定已經訪問過
        // 遍歷當前節點的所有鄰接節點，由於是grid, 只有四個鄰接節點要去訪問。
        dfs(grid, y+1, x, target);
        dfs(grid, y-1, x, target);
        dfs(grid, y, x+1, target);
        dfs(grid, y, x-1, target);
    }

    public void performTest()
    {
        Helper.equals( numberOfClusters(new char[][] {
            {'1','1','0','1','0'},
            {'1','2','0','1','0'},
            {'1','2','2','2','2'},
            {'0','0','1','1','0'},
        }), new int[] {4,3,1} ,"Number of Culsters :");
        
    }

    public String toString() { return "Number Of Clusters ([E]**):";}
}
