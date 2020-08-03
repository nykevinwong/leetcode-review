public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
//        generate(n, 0, 0, res ,"");
    generateItreative(n, 0, 0, res, "");
    return res;
}

public void generate(int n, int left, int right, List<String> res, String cur)
{
    if(left==n && right==n) { res.add(cur); return; }
    if(right > left) return; // prune this execution tree
    if(right > n || left > n) return; // prune this execution tree
    
    generate(n, left+1, right, res, cur+"(");
    generate(n, left, right+1, res, cur+")");
}


public Object[] arguments(Integer n, Integer left, Integer right, List<String> res, String cur)
{
    return new Object[]{ n,left, right, res, cur };
}


public void generateItreative(int n, int left, int right, List<String> res, String cur)
{
    Stack<Object[]> s = new Stack<Object[]>();
    s.push(arguments(n,0,0, res, ""));
    
    while(!s.isEmpty())
    {
        Object[] argu = s.pop();
        
        n = (int)argu[0];
        left = (int)argu[1]; 
        right = (int)argu[2];
        res = (List<String>)argu[3];
        cur = (String)argu[4];
        
        if(left==n && right==n) { res.add(cur); continue; }
        if(right > left) continue;  // prune this execution tree
        if(right > n || left > n) continue; // prune this exection tree
        
        // stack push order is reverse order from the call order from the original recurisve function
        s.push( arguments( n, left, right+1, res, cur+")" ) );
        s.push( arguments( n, left+1, right, res, cur+"(" ) );
        
    }
    
    return;
}
