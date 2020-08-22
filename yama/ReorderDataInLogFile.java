
import java.util.Arrays;


public class ReorderDataInLogFile implements IInterviewQuestion
{
    // 有digial log及letter log 兩種。
    // (1)letter log 在digital log 之前.
    // (2)letter log 照第二子串字串a-z排。如果第二字串都相等，用第一字串a-z排.
    // (3)digital log 照原順序排.
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2); //用空白拆字串，只要前兩個拆下來的子字串。
            String[] split2 = log2.split(" ", 2); //用空白拆字串，只要前兩個拆下來的子字串。
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//查第二個子字串是否為數字
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));//查第二個子字串是否為數字
            if (!isDigit1 && !isDigit2) {//兩個字串的第二子字串都不是數字.
                int cmp = split1[1].compareTo(split2[1]);//第二字串a-z排
                if (cmp != 0) return cmp; //第二字串不相等，用第二字串排.
                return split1[0].compareTo(split2[0]); //第二字串相等，用第一字串a-z排
            }
            //其它 11, 10, 01 狀況
            // 11:都是數字log, 傳回0代表相等，暗示使用原來排序。
            // 10: 只有log1是數字log，傳回1 代表，左邊log1排到後面。
            // 01: 只有log2是數字log，傳回-1 代表，右邊log2排到後面。
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public void performTest()
    {
        Helper.equals( reorderLogFiles(new String[] { "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"} ) ,
        new String[] {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"}, "Reoder Log ");
    }

    public String toString() { return " Reorder Data in Log Files([E]*) [https://leetcode.com/problems/reorder-data-in-log-files/]: ";}
}
