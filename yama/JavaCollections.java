import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.Iterator;


public class JavaCollections implements IInterviewQuestion, IImportTechnique  {
    public void performTest()
    {
        System.out.println("Priorty Queue:");
        PriorityQueue<Integer> pq=new PriorityQueue<>(); // 預設的PQ是最小值堆積(Min Heap)，小排到大，意味著小值先出.
        int[] points = new int[] { 1,10,3,6,5,8,7,4,9,2}; int K = 3;

        for(int pValue: points) { pq.offer(pValue); } //存入最小值堆積，讓堆積自已排.

        // 印出堆積的內容，這方法只印出內部陣列的順序，不是最堆積的順序.
        for(Integer p: pq) { System.out.print(p+ " "); } System.out.println();        

        Iterator itr = pq.iterator();          // 用代器，同上.
        while (itr.hasNext()) { System.out.print(itr.next()+ " ");  } System.out.println();
        // 印出照堆積順序排列的值.
        while(pq.size() > 0) { System.out.print(pq.poll()+ " "); } System.out.println();

        // 最大堆積，revereOrder只適用 primitive type.
        Queue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int pValue: points) { pq2.offer(pValue); } //存入最大值堆積，讓堆積自已排.
        // 照堆積順序列印結果.
        while(pq2.size() > 0) { System.out.print(pq2.poll()+ " "); } System.out.println();
   
        // 使用最大堆積取得最小K個數的 N*log(K) time complexity 技巧.
        // 最大堆積，由小排到大. 邊加入值， 堆積大於K個，就提出最大值.。最後最小的K個
        for(int pValue: points) 
        {
            pq2.offer(pValue); //邊加入值
            if(pq2.size() > K)  pq2.poll(); // 堆積大於K個，就提出最大值.
        }

        // 照堆積順序列印結果.        
        while(!pq2.isEmpty()) { System.out.print(pq2.poll() + " "); } System.out.println();
    
        // add() vs offer(), remove() vs poll(), element() vs peek().
        // add() from Collection can't return false and throw an exception if an element cannot be added.
        // offer() from Queue returns false if an element cannot be added.
        // when the queue is empty, element() and remove() from Collection throws NoSuchElementException, while poll() & peek() return null.
        /*
           add Throws:
            IllegalStateException - if the element cannot be added at this time due to capacity restrictions
            ClassCastException - if the class of the specified element prevents it from being added to this queue.
                for example, adding another type of object into a non-generic ArrayList.
            NullPointerException - if the specified element is null and this queue does not permit null elements
            IllegalArgumentException - if some property of this element prevents it from being added to this queue
        */

        System.out.println("HashMap:");

        HashMap<Integer, String> m = new HashMap<>();
        m.put(11, "AB");
        m.put(2, "CD");
        m.put(33, "EF");
        m.put(9, "GH");
        m.put(3, "IJ");    

        for(Map.Entry e: m.entrySet() ) { System.out.print("{" + e.getKey() + "=>" + e.getValue() + "},"); }  System.out.println();

        HashMap<Integer,String> m2 = (HashMap)m.clone();
        
        for(Map.Entry<Integer,String> e: m2.entrySet() ) { System.out.print("{" + e.getKey() + "=>" + e.getValue() + "},"); } System.out.println();   
        m2.clear();
        m2.putAll(m);        Iterator mItr = m2.entrySet().iterator();
        while(mItr.hasNext()) { Map.Entry e = (Map.Entry)mItr.next(); System.out.print("{" + e.getKey() + "=>" + e.getValue() + "},"); } System.out.println();

        /*  HashSet & HashMap doesn't maintain any kind of order of its elements.
            LinkedHashSet & LinkedHashMap maintains insertion order.
            TreeSet & TreeMap sort the entries in ascending order of keys and they don't allow null key and throw NullPointerException.
            Set -> contains
            Map -> containsKey, containsValue
        */        

        Set<Integer> set = m2.keySet();
        Iterator<Integer> ite2 = set.iterator();
        while(ite2.hasNext()) { System.out.print(ite2.next() + ","); } System.out.println();

        Collection<String> values = m2.values();
        for(String s: values) { System.out.print(s + ","); } System.out.println();
        Iterator<String> ite3 = values.iterator();
        while(ite3.hasNext()) { System.out.print(ite3.next() + ","); } System.out.println();

        System.out.println("hello");

    }
    
    public String toString() { 
        return "Mastering JavaCollectionsn [https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/]";
    }
}

/*

- Use Comparator when you need more flexibilit
** The compareTo() method will return a positive number if one object is greater than the other, negative if it’s lower, and zero if they are the same.

import java.util.Comparator;

public class MyComparator implements Comparator<String>
{
   @Override // ascending order based on String length
   public int compare(String x, String y) { return x.length() - y.length();}
}

or you can replace everything before Comparator using new keyword as below.

Collections.sort(strArr, new Comparator<String>
{
   @Override // ascending order based on String length
   public int compare(String x, String y) { return x.length() - y.length();}
});

Using Comparator with lambda expressions as below:
Collections.sort(strArr, (x, y) -> x.length() - y.length()  );

You always use compareTo for a String/object.
Collections.sort(strArr, (s1, s2) -> s1.compareTo(s2));

even shorter with
Collections.sort(strArr, Comparator.naturalOrder() );

    // ascending order means to arrange values from smallest to largest.
    // descending order means to arrange values from largest to smallest.

    // ascending order based on value
    public int compare(Integer x, Integer y) { return x - y;}
    // descending order based on value
    public int compare(Integer x, Integer y) { return y - x;}

    // sort by id in ascending order. when ids are the same, sort by their name in alphabetic order.
    public int compare(User x, User y) { return x.id == y.id ? x.name.compareTo(y)  : x.id-y.id  ;}
    (x,y) -> x.id==y.id ? x.name.compareTo(y) : x.id-y.id;

    // sort by map value in ascending order. When map value are the same, sort by the name in alphabetic order.
    public int compare(String s1, String s2) { return count.get(s1) == count.get(s2) ? s1.compareTo(s2)  : count.get(s1)-count.get(s2); }
    (s1,s2) -> count.get(s1)==count.get(s2) ? s1.compareTo(s2) : count.get(s1)-count.get(s2);

    Sorting a Map with TreeMap
    Map<String, Integer> m  = new TreeMap<>();
    m.put("DEF", 10);
    m.put("ABC", 20);
    System.out.println(m);

    Sorting a Set with TreeSet
    Set<String> s  = new TreeSet<>();
    s.put("DEF");
    s.put("ABC");
    System.out.println(m);
*/