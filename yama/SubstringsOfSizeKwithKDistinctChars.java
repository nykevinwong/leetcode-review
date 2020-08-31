import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class SubstringsOfSizeKwithKDistinctChars implements IInterviewQuestion
{
    public List<String> substringsOfSizeKwithKDistinctChars(String s, int k)
    {
        List<String> res = new ArrayList<>(); //存解答的子字串
        Set<String> set = new HashSet<>(); //
        int[] m = new int[256]; // 存字母出現次數,假設ASCII code is used

        for(int i=0, j = 0;i < s.length() && j < s.length(); )
        {
            if(m[s.charAt(i)]==0) // 第一次出現此字母
            {
                m[s.charAt(i++)]++; // 計算此字母出現次數，移動尾指標(快指標)
            }
            else  // 同樣的字母又出現一次，移動頭指標(慢指標)直到此字母在此[j,i]區間只出現過一次.
            {
                m[s.charAt(j++)]--; 
            }

            // 當前[j,i] 區間就是保證一個字母只能出現一次
            if(i-j==k) {  // 如果長度為K,由於字母一次只在此區間出現一次，那這子字串肯定是只有K個獨特字元。
                String sub = s.substring(j,i); // 取該區間的子字串
                //用 Set 確定，重覆的答案只存一次。
                if(!set.contains(sub)) { res.add(sub); }
                set.add(sub); // 這答案不能再出現，存入set，方便下次檢查.
                m[s.charAt(j++)]--; // 這區間不再計入答案，移動頭指標，也得更新字母頻表.
            }
            

        }
        return res;
    }

    public void performTest()
    {
        Helper.equals( substringsOfSizeKwithKDistinctChars("awaglknagawunagwkwagl",4), 
        new String[] {"wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"}, "SubString");
    }
    
    public String toString() { return "Substrings Of Size K with K Distinct Chars ([I]**) [https://leetcode.com/discuss/interview-question/370112]: ";}
}
