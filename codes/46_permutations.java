public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if(nums==null || nums.length==0) return res;        
    int n = nums.length;
    permute(nums, new boolean[n], new ArrayList<Integer>(),res);
    
    return res;
}

public List<Integer> toList(int nums[])
{
    List<Integer> l = new ArrayList<>();
    for(int value : nums) l.add(value);
    return l;        
}

public void permute(int[] nums, boolean[] visited, List<Integer> l, List<List<Integer>> res)
{
    if(l.size()==nums.length) { res.add(new ArrayList<Integer>(l)); return; }                

    for(int i=0; i < nums.length;i++)
    {
        if(!visited[i])
        {
            l.add(nums[i]);
            visited[i]= true;
            permute(nums, visited, l, res);
            visited[i]= false;
            l.remove(l.size()-1);
        }
    }
}