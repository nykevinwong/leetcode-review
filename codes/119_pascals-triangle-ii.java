
public List<Integer> getRow(int rowIndex) {
    // p(i,j) = p(i-1,j-1)+p(i-1,j)
    List<Integer> res = new ArrayList<>();
    res.add(1);
    
    for(int i=1;i<=rowIndex;i++)
    {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int j=1;j<res.size();j++)
        {
           cur.add(res.get(j-1)+ res.get(j));                
        }
        cur.add(1);
        
        res.clear();
        res = cur;            
    }
    
    return res;
    
}