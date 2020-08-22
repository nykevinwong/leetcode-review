
import java.util.HashSet;
import java.util.HashMap;

/*  @@DESCRIPTION
Amazon 題: 最常用字.
給一段文章及禁用字(粗話字)清單. 將禁用字排除在外，找出文章中的最高頻字.
最佳解是不能排序。將禁用字轉小寫存入HashSet排除重覆字。文章轉小寫拆成字組. 針對非禁用字計數. 不斷地更新當前最大值及當前最高頻字.
*/
class MostCommonWord implements IInterviewQuestion
{
    public String mostCommonWord(String paragraph, String[] banned) {
        // W means non-word character. + means more than one non-word can be used. 
        String[] words = paragraph.split("\\W+"); 
        HashSet<String> bannedWords = new HashSet<>(); //除去重覆元素，只要獨特(distinct)元素用.
        HashMap<String,Integer> m = new HashMap<>();//記錄字出現次數(frequency)
        String maxWord = null;
        int max = 0; // 記錄全域最高頻字的出現次數,用以快速記錄全域"唯一"最高頻字
        for(String b : banned) // 建造禁用字表，重覆的禁用字不需要，
        bannedWords.add(b.toLowerCase()); //轉小寫方便比較字串或當哈希表鍵值。
        
        for(String w: words) //遍歷文章段落上每個字
        {
            w = w.toLowerCase(); //轉成小寫好比較字串
            if(!bannedWords.contains(w)) //如果不是禁用字
            {   //計算該字的出現次數
                m.put(w, m.getOrDefault(w,0)+1);
                int count =m.get(w); //取出該字出現次數
                if(count > max) //如果該字比全域最高頻字的出現次數還高
                {
                    maxWord = w; //記錄成全域最高頻字
                    max = count; //記錄成全域最高頻字的出現次數
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