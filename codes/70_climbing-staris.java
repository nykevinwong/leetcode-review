Map<Integer,Integer> m = new HashMap<>();
    
public int climbStairs(int n) {
    return climb(n);
}

public int climb(int remainStep)
{
    if(remainStep < 0) return 0; // this move doesn't make sense since it must be zero after last step.
    if(remainStep==0) return 1;
    
    if(m.containsKey(remainStep))
    {
        return m.get(remainStep);
    }
    
    int count = climb(remainStep-1) + climb(remainStep-2);
    m.put(remainStep, count);
    return m.get(remainStep);
}