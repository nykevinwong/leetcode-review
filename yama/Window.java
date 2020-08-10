import java.util.Map;
import java.util.HashMap;

//記錄某物品(數字，字元，字串或物件，事件等等)出現的次數.也同時計算到底有多少種不同種類的物品(the number of type)
class Window<E>
{
    Map<E,Integer> m = new HashMap<>();
    int kinds = 0; // the total number of types available in the map
    
    public Window() {}
    
    public void add(E x)
    {
        m.put(x, m.getOrDefault(x,0)+1);
        if(m.get(x)==1) kinds++;
    }
    
    public void remove(E x)
    {
        m.put(x, m.get(x)-1);
        if(m.get(x)==0) kinds--;
    }
    
    public int kinds() { return kinds; }
}