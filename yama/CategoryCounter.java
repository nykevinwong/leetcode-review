import java.util.Map;
import java.util.HashMap;

// 種類計數器,計算同物件及不同物件種類數
// 如三隻狗，五隻鳥，十隻馬，九隻猴。共有四種動物。
// 如三個4,五個6,七個8。共有三種數字。
// 如三個a,六個d,九個f，十個k。共有四種字母。
// 形狀，面積大小，體積，等等任何可以自已分門別類的都可用類似種類計數器的方式。
class CategoryCounter<E> 
{
    Map<E,Integer> m = new HashMap<>();
    int kinds = 0; 
    
    public CategoryCounter() {}
    
    public void add(E x)
    {
        m.put(x, m.getOrDefault(x,0)+1); //多一個這種類
        if(m.get(x)==1) kinds++;// 如果此種類的物件至少有一個，代表多了一個品種。
    }
    
    public void remove(E x)
    {
        m.put(x, m.get(x)-1); // 少一個這種類
        if(m.get(x)==0) kinds--;// 如果此種類的物件變回零，代表這品種已經沒了。
    }
    
    public int kinds() { return kinds; }
}