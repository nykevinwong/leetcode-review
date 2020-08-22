
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/* @@DESCRIPTION
1268. Search Suggestion System 搜索推荐系統. 建議列表. 自動完成表.
在每次打入一個字母時，下拉選單會自動提示最接近當前輸入關鍵字字首的產品名稱.最多提示三個產品，並按照字母順序。
可用對應26個字母的字首樹資料結構來解決這題. 每個字首樹節點還得儲存當前字首對應的產品推荐表以方便快速查尋.
產品清單必須排序後，才存入字首樹中。
*/

public class SearchSuggestionSystem implements IInterviewQuestion {
    // System Design interview for auto suggestions: https://www.youtube.com/watch?v=xrYTjaK5QVM
    // https://leetcode.com/problems/search-suggestions-system
     class Trie { // 26字母的Trie樹結構
     Trie[] sub = new Trie[26];
     List<String> suggestion = new LinkedList<>();//每個節點存至該子字串的產品
     }
 
     // autocomplete/typehead
     // suggest 3 items based on a searchWord currently typed.
     // 根據當前產品搜尋關鍵字，建議至少3個產品。
     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
         Arrays.sort(products); // 產品必須照字母排序先.
         
         List<List<String>> res = new ArrayList<>();
         Trie root = new Trie();
         for(String p: products) //每個產品照字母排序，存入對應的Trie樹節點位置.
         {
             Trie r = root;//取得Tire樹根節點位置
             for(char c : p.toCharArray())
             {
                 if(r.sub[c-'a']==null) r.sub[c-'a'] = new Trie(); // 建立當前Tire樹所需要對應字母的Tire樹
 
                 r = r.sub[c-'a'];// 取得當前字母對應的Tire樹位置。
                 // 如果建議的產品小於三個，繼續加到表中。
                 if(r.suggestion.size() < 3) r.suggestion.add(p);
             }
         }
         
         for(char c: searchWord.toCharArray())//遍歷產品搜尋關鍵字的每個字元
         {
             if(root!=null) root = root.sub[c-'a']; // 取得當前字母對應的Tire樹
             // 沒有就存空表，不然存當前字母對應Tire樹推
             res.add( (root==null) ? Arrays.asList() : root.suggestion);
         }
         //答案有對應同一關鍵字中，每個區間的搜尋結果.
         return res;
     }
 
     public void performTest()
     {
         String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
         String searchWord = "mouse";
         Helper.equals(suggestedProducts(products,searchWord), 
         new String[][] {
             {"mobile","moneypot","monitor"},
             {"mobile","moneypot","monitor"},
             {"mouse","mousepad"},
             {"mouse","mousepad"},
             {"mouse","mousepad"}
         }, "AutoComplete/TypeAhead Suggestion: ");
     }
 
     public String toString() { return "Product Suggestions ([E]**):";}
 }