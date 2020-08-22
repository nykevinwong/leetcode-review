import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

class PrisonCellsAfterNDays implements IInterviewQuestion {

    public int[] prisonAfterNDays(int[] cells, int N) {
        // 陣列為空值，沒有元素，或著N代表第零天，就傳回原始陣列。
        if(cells==null || cells.length == 0 || N <= 0) return cells;

            Set<String> set = new HashSet<>();//以整個cell陣列內容當鍵值存每天prision的狀態.
            
            while(0 < N) //共有N天的狀態要處理
            {
                int[] next = nextDayCell(cells); //取得下一天的狀態
                String curKey = Arrays.toString(next);// 下一天陣列內容狀態轉成字串，方便存取
                // 此狀態存在過，代表己經開始進入重覆狀態的環
                if(set.contains(curKey))
                {                
                    N%=set.size(); //N的餘數代表狀態陣列中對應的位置就是答案。
                    // 由於我們沒有天數對照狀態表，我們用nexyDayCall重新計算.
                    while(0 < N--) cells  = nextDayCell(cells);
                    
                    return cells; //這就是N的餘數所代表的prison狀態
                }
                else
                {  //此狀態沒存過,記錄下來
                    set.add(curKey);
                }
                                
                cells = next; // 處理完後，當前prision狀態就是下個prison狀態。  
                N-=1;// 天數過了一天
            }
            
            return cells;
        }
        
        public int[] nextDayCell(int[] cells)
        {   //建立新陣列來存下一天的狀態
            int[] temp = new int[cells.length];
            // 陣列第一個及最後位置的值必為零。因為無法得知第一位置左鄰居值及最後位右鄰居值。
            // 計算下一天的狀態,除了第一及最後位置外，遍歷所有位置。從第二個位置遍歷至倒數第一個. 
            for(int i=1;i<cells.length-1;i++) 
            {  // 下一天的同位置的狀態，是左右鄰居都為0或1，也就是相等時，下一天同位置的值為1.
                temp[i] = (cells[i-1]==cells[i+1]) ? 1:0;        
            }
            return temp;//傳回下一天狀態.
        }

    public void performTest()
    {
        Helper.equals(prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000) ,
            new int[]{0,0,1,1,1,1,1,0} , "prison After N Days:");

    }

    
    public String toString() { 
        return "prison After N Days [https://leetcode.com/problems/prison-cells-after-n-days/]";
    }
}