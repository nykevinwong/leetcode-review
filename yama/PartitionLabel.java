/* @@DESCRIPTION
763. Partition Labels. 劃分字母區間.
將只包含小寫字母的字串盡可能的畫分成多個區間，同一字母只能出現在一個區間中，傳回每個區間的長度.
解法是遍歷整個字串，用包含26個元素的陣列對照表記錄每個字母出現的最後位置. 再遍歷整個字串，當前字串的位置如果等於當前最大最後位置即可計算區間長度.

*/
import java.util.ArrayList;
import java.util.List;

public class PartitionLabel implements IInterviewQuestion
{
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        List<Integer> res = new ArrayList<Integer>();
        //建立26個小寫字母，每個字在字串上出現的最後位置的對照表
        for(int i=0;i<S.length();i++)
            last[S.charAt(i)-'a'] = i;           
        // lastMax是當前區間最大最後位置。 start 是區間起始位置
        int lastMax = 0, start = 0; 
        //遍歷整個字串，處理每個字母
        for(int i=0;i<S.length();i++)
        {   //當前字母的最後位置跟之前某字母的最後位置比，取最大最後位置者.
            //當前最大最後位置者，可能是當前字母，也可能是之前某個在字串上的字母。
            lastMax = Math.max( last[S.charAt(i)-'a'], lastMax);           
            //如果當前最大最後位置，是當前索引，表代當前字母及所有之前字母只出現在這個區間。
            if(lastMax==i)
            {   // 計算區間長度，並存入ArrayList.
                res.add(lastMax-start+1);                    
                start = i+1; //記錄下個區間起始位置，好計算下個區間長度.
            }
        }
        
        return res;//傳回所有劃分字母區間
    }

    public void performTest()
    {
        Helper.equals(partitionLabels("ababcbacadefegdehijhklij"), new Integer[] {9,7,8}, "Partition Label -> ababcbacadefegdehijhklij ");

    }

    public String toString() { return "Partition Labels([E]*) [https://leetcode.com/problems/partition-labels/]: ";}
}
