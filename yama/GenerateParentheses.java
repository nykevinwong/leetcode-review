import java.util.List;
import java.util.ArrayList;

/*  @@DESCRIPTION
generate parenthesis. 產生有效的雙括號.
*/

class GenerateParentheses implements IInterviewQuestion {
    // 給定括號數。產生有效雙括號。
    // backtracking preorder traversal 變型解法，由函式簽章中的參數變數來暫存backtracking的變化值，就
    // 不需要變化值改回之前值.
    // 函式簽章需要當前產生的雙括號字串。當前還可用的左右括號數。有效雙括號的答案存放表。
    // 左右括號。兩種可能性，當前字串加入左括號或加入右括號。減少用掉的括號數。
    // 三種可能的判斷: 
    // 左括號數比右括號數還多，代表如右括號己經不夠用，無法產生有效答案。截枝不用再進行。
    // 左或右括號變成負數，代表當前不是有效答案。截枝不用再進行。。
    // 左右括號剛好都用完，當前字串就是有效的雙括號解答。 
    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);   
        return res;
    }
    
    public void dfs(String s, int left, int right, List<String> res)
    {
        if(left > right) return; // 左括號的數量不能小於右括號，否則不是有效雙括號.
        if(left <0 || right < 0) return; //超過所要求的括號數量
        if(left==0 && right==0) res.add(s); // 剛好是題目要求的雙括號數量
        
        dfs(s+"(", left-1, right, res); //如果下一個是左括號的狀態分支
        dfs(s+")", left, right-1, res); //如果下一個是右括號的狀態分支
    }

    public void performTest()
    {
        Helper.equals( generateParentheses(3), new String[] {"((()))","(()())","(())()","()(())","()()()"} , "Valid parentheses generation? ");
    }

   
    public String toString() { 
        return "Generate Parentheses ([I] *) [https://leetcode.com/problems/generate-parentheses/]";
    }
}