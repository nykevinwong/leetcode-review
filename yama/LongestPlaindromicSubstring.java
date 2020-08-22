class LongestPlaindromicSubstring implements IInterviewQuestion {
    // 動態規畫解
    public String longestPalindrome(String s) {
        if(s==null || s.length() < 2) return s;
        // 存全域最大長度用的左右位置
        int left = 0, right = 0;
        int len = s.length();

        //用來存位置i至位置j的字串是否為迴文的記錄表格. 若索引位置小等於2
        boolean[][] isPalindrome = new boolean[len][len]; // isPalindrome[i][j] 
        // 內走一步範圍的字串是迴文，當前區間才可能是迴文.
        // isPalindrome[i][j] = isPalindrome[i+1][j-1] && s[i]==s[j];              
        
        // 如果 i<j, 不合理.
        // 如果 i==j, 同一個字。 必定是迴文.
        // 如果 i>j, 
        for(int j=1; j < s.length();j++) 
            for(int i=0; i < j ; i++)
            {
                //j-i <=2 means current length doesnt have an inner string to check.
                boolean isInnerPalindrome = isPalindrome[i+1][j-1] || j-i <=2;
                
                if(isInnerPalindrome && s.charAt(i)==s.charAt(j) )
                {
                     isPalindrome[i][j] = true;
                    if(j-i > right-left) // update current max length
                    {
                        right = j;
                        left = i;
                    }
                }
            }
        return s.substring(left,right+1);
    }
    // 最大長度迴文中點擴散搜尋法
    public String longestPalindrome_ExpandFromCenter(String s) {
        String max = "";
        // 針對字串上的每個字為起始點，找出可能的最大迴文長度.
        for(int i=0;i< s.length();i++)
        {
            String s1 = expandFromCenter(s, i, i); //針對單數長度迴文搜尋最大長度
            String s2 = expandFromCenter(s, i, i+1); //針對雙數長度迴文搜尋最大長度
            String curMax = (s1.length() > s2.length()) ? s1:s2; //取當前較大長度字串
            max = (curMax.length() > max.length()) ? curMax:max;//取全域最大長度字串            
        }
        
        return max;
    }
    // 以單中點或雙中點，左右雙指標搜尋迴文最大長度
    public String expandFromCenter(String s, int l, int r)
    {   // 找最大迴文長度
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r))
        { // 在整個字串區間範圍內，當前位置字相等，擴大搜尋範圍。直到當前位置字不相等.
            l--; r++; 
        }
        // 計算當前最大長度，當前左右值是排除值，需要各往中點走一步才是正確的值。
        int len = ((r-1)-(l+1)); //單中點原點長度是0，雙中點原點長度是-1.        
        return s.substring(l+1, r); // 傳回當前最大長度字串, 原點位置時，傳回空字串,零長度。
    }

    public void performTest()
    {
        Helper.equals(longestPalindrome("babad"),  "bab", " longest plaindrome ?" );
        Helper.equals(longestPalindrome("cbbd"),  "cbbd", " longest plaindrome ?" );

        Helper.equals(longestPalindrome_ExpandFromCenter("babad"),  "bab", "(EXPAND from Center) longest plaindrome ?" );
        Helper.equals(longestPalindrome_ExpandFromCenter("cbbd"),  "cbbd", "(EXPAND from Center)  longest plaindrome ?" );
    }

    public String toString() { 
        return "Longest Palindromic Substring ([I]**) [https://leetcode.com/problems/longest-palindromic-substring/]";
    }
}