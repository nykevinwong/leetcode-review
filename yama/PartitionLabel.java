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
        
        for(int i=0;i<S.length();i++)
            last[S.charAt(i)-'a'] = i;           
        
        int lastMax = 0, start = 0;
        for(int i=0;i<S.length();i++)
        {
            lastMax = Math.max( last[S.charAt(i)-'a'], lastMax);           
            
            if(lastMax==i)
            {
                res.add(lastMax-start+1);                    
                start = i+1;
            }
        }
        
        return res;
    }

    public void performTest()
    {
        Helper.equals(partitionLabels("ababcbacadefegdehijhklij"), new Integer[] {9,7,8}, "Partition Label -> ababcbacadefegdehijhklij ");

    }

    public String toString() { return "Partition Labels([E]*) [https://leetcode.com/problems/partition-labels/]: ";}
}
