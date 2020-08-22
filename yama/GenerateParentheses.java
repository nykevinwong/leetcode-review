import java.util.List;
import java.util.ArrayList;

/*  @@DESCRIPTION
generate parenthesis. 產生有效的雙括號.
*/

class GenerateParentheses implements IInterviewQuestion {
    
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