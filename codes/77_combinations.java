public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ls = new ArrayList<>();
    combine(n, k, 1, new boolean[n+1], new ArrayList<Integer>(), ls);
    return ls;        
}

public void combine(int n, int k, int start, boolean[] visited, List<Integer> l, List<List<Integer>> ls)
{

    for(int i=start;i<=n;i++)
    {
        if(!visited[i])
        {
            visited[i] = true;
             l.add(i);
  
            if(l.size()==k) 
            {
                ls.add(new ArrayList<Integer>(l));
            }
            else
            {
                combine(n, k, i+1, visited, l, ls);
            }
            l.remove(l.size()-1);
            
            visited[i] = false;
        }
        
    }
}