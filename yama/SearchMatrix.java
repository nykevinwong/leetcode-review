
public class SearchMatrix implements IInterviewQuestion
{   // o(n):排除解法
    public boolean searchMatrix(int[][] matrix, int target) {
        //二維陣列為空值，或大小為零，就傳回找不到此值。
        if(matrix==null || matrix.length==0 || matrix[0].length==0 ) return false;
        int col = matrix[0].length-1;//最右邊的位置
        int row = 0;//第一行
        
        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col]==target) return true; //找到該值
            if(matrix[row][col] < target) row++; // 排除此行
            else col--; // 排除此列
        }
        
        return false; //找不到該值
    }

    public void performTest()
    {
        int[][] m = new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        Helper.equals(searchMatrix(m, 16), true, "Search 16 ");
        Helper.equals(searchMatrix(m, 13), true, "Search 13 ");
        Helper.equals(searchMatrix(m, 100), false, "Search 100 ");
    }

    public String toString() { return "Seach a 2D Matrix ([N]**) [https://leetcode.com/problems/search-a-2d-matrix-ii]: ";}
}
