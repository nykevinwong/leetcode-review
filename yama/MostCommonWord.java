
import java.util.HashSet;
import java.util.HashMap;

/*  @@DESCRIPTION
Amazon 題: 最常用字.
給一段文章及禁用字清單. 找出文章中非禁用字的最高頻字.
最佳解是不能排序。將禁用字轉小寫存入HashSet排除從覆字。文章轉小寫拆成字組. 針對非禁用字計數. 不斷地更新當前最大值及當前最高頻字.
*/
class MostCommonWord implements IInterviewQuestion
{
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\W+"); // split by all non-character. + means more than one non-character can be used. 
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> m = new HashMap<>();
        String maxWord = null;
        int max = 0;
        for(String b : banned)
            set.add(b.toLowerCase());
        
        for(String w: words)
        {
            w = w.toLowerCase();
            if(!set.contains(w))
            {
                m.put(w, m.getOrDefault(w,0)+1);
                int count =m.get(w);
                if(count > max)
                {
                    maxWord = w;
                    max = count;
                }
            }
        }
        
        return maxWord;
    }

    public void performTest()
    {
        Helper.equals(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}), 
        "ball" , "Most Command Word ");
        Helper.equals(mostCommonWord("Bob. hIt, baLl", new String[] {"bob", "hit"}), 
        "ball" , "Most Command Word ");
    }
    
    public String toString() { return "Most Common Word ([I]**) [https://leetcode.com/problems/most-common-word/]: ";}

}