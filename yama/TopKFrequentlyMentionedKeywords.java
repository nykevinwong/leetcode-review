
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/* @@DESCRIPTION
692. TOP K Frequent words. 前K個最高頻字或元素.
給一堆可能從覆的關鍵字，一堆評價文章。找出前K個最高頻字.同頻字要依照字母順序排.
解法是將每個評價文轉成小寫並拆成字組存入HashSet排除從覆字.儲存每字出現字數到對照表。
依出現次數由大排到小. 取前K個。
更快的方法是，使用最小堆積優先佇列. 用K log(K)的方法，讓佇列只留下最高頻字數的前K個.
將佇列提出的順序反轉就是前K個.
*/

public class TopKFrequentlyMentionedKeywords implements IInterviewQuestion
{   // related problems:
    // https://leetcode.com/problems/top-k-frequent-words/
    // https://leetcode.com/problems/top-k-frequent-elements/
    // solution from 35 - 79 = about 45 lines
    public List<String> nlogn_Sort(Map<String,Integer> m, int k)
    {   // sort in a descending order based on word frequency from large to small.
        List<String> res = new ArrayList(m.keySet());
        // 從字數出現次數大到小排. 相等次數者，依字串字母排序。
        Collections.sort(res, (w1, w2) -> (m.get(w1) == m.get(w2) ? w1.compareTo(w2) : m.get(w2)-m.get(w1)) );
        return res; //由出現次數高至低排列的答案
    }

    public List<String> nlogk_Sort(Map<String,Integer> m, int k)
    {   
        // 從字數出現次數小到大排. 相等次數者，依字串字母排序。由於是反轉後，才是正確的順序。字母排序也是相反的。
        // 用最小堆積從小數到大數排，小數先排出。最後會留下最大的。
        PriorityQueue<String> q = new PriorityQueue<>( (w1, w2) -> (m.get(w1) == m.get(w2) ? w2.compareTo(w1) : m.get(w1)-m.get(w2)));

        // 將數值放入最小堆積自已排序，堆積大於k個，就排出最小的。最後會只留下K個最大值。
        // 這方法是N*log(K) time complexity.
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            q.offer(entry.getKey());
            if (q.size() > k) { q.poll(); }  // ensure each insertion only uses log(k)       
        }
    
        // 將最小堆積內容取出反轉順序。 最小堆積從小到大排，答案是從大到小排。
        List<String> res = new ArrayList<>();        
        while (q.size() > 0) {
            String w = q.poll();
            res.add(w);
        }    
        Collections.reverse(res); //reverse the order        
        return res; //由出現次數高至低排列的答案
    }

    public List<String> TopKFrequent(String[] keywords, String[] reviews, int k, boolean nlogksort )
    {  // 關鍵字表存放需要被計數的字，符合者才被計數.
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords)); // 將重覆的關鍵字除去
        Map<String, Integer> m = new HashMap<>(); //字數對照表

        for(String r: reviews)
        {   // split based on non-character. characters:[a-zA-Z0-9_]
            String[] strs = r.split("\\W"); //將review 段落中的單字都取出，由段落的非單字如空白，標點等等來分割這些單字。
            Set<String> inReview = new HashSet<>(Arrays.asList(strs)); //將重覆的單字除去
            for(String w:inReview) //針對這個review中的個別單字計數
            {  
                w = w.toLowerCase();  // 轉成小寫，確保比較字串時，不用分大小寫.
                if(keywordSet.contains(w)) // 該字必須在關鍵字表才要計數
                {
                    m.put(w, m.getOrDefault(w,0)+1); // 計錄該單字的全域出現次數
                }
            }
        }

        // 取出單字全域出現次數最高的K者
       List<String> res = nlogksort ? nlogk_Sort(m,k) : nlogn_Sort(m, k);
       return res.subList(0,k); // [0,K)
    }

    public void performTest()
    {
        boolean[] nlogkFlag = new boolean[] { false, true};

        for(int i=0; i < nlogkFlag.length;i++)
        {
            boolean nlogk = nlogkFlag[i];
            String label = nlogk ? "nlogk": "nlogn";

            Helper.equals(TopKFrequent(new String[] { "anacell", "cetracular", "betacellular" },
            new String[] { "Anacell provides the best services in the city", 
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell" }, 2, nlogk) , 
                new String[] {"anacell", "betacellular"} , 
                "Top K Frequent ("+label +")");

            Helper.equals(TopKFrequent(new String[] { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" },
            new String[] {  "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular." }, 2, nlogk) ,
                new String[] {"betacellular", "anacell"} , 
                "Top K Frequent ("+label +")");
        }

    }

    public String toString() { return "Top K Frequently Mentioned Keywords ([E]***):";}
}
