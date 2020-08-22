
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;



public class CriticalRoutersOrConnections implements IInterviewQuestion 
{   // 找出圖上關節點的程式
    class Graph<T>
    {
        private Map<T, List<T>> adjList = new HashMap<>();
        private int time = 0;

        public void addEdges(T[][] edges)
        {
            for(int i=0;i<edges.length;i++)
            {   // 將二維陣列的值，轉成無向圖的雙向節點
                addEdge(edges[i][0], edges[i][1]);
            }
        }

        public void clear()
        {
            adjList.clear();
        }

        public void addEdge(T u, T v)
        {
            addEdge(u, v, true); // 建立無向圖(雙向圖)
        }

        public void addEdge(T u, T v, boolean biDir)
        {
            adjList.put(u, adjList.getOrDefault(u, new ArrayList<T>())); 
            adjList.get(u).add(v);
            if(biDir)
            {   //空值就先建立強型ArrayList，然後存值
                adjList.put(v, adjList.getOrDefault(v, new ArrayList<T>()));
                adjList.get(v).add(u);
            }
        }        

        public void findCutPoints(T node, Map<T, Boolean> visited, Map<T, T> parent,  Map<T, Integer> disc, Map<T, Integer> low, Set<T> ap, Map<T, List<T>> bridges)
        {
            int children = 0;
            visited.put(node, true);
            time++;
            disc.put(node, time);
            low.put(node, time);
                        
            for(T adjNode: adjList.get(node)) //遍歷鄰接節點
            {
                if(visited.get(adjNode)==false) // 若未訪問該鄰接節點
                {
                    children++; //計算當前主節點有多少孩節點
                    parent.put(adjNode,node); //當前鄰接節點的父親是當前主節點
                    findCutPoints(adjNode, visited, parent, disc, low, ap, bridges);
                    low.put(node, Math.min(low.get(node), low.get(adjNode) ) );
                    
                    // this piece of code is to determine cut points
                    if(ap!=null)
                    {
                        if(parent.get(node)==null && children > 1) ap.add(node);
                        if(parent.get(node) != null && low.get(adjNode) >= disc.get(node)) // > for bridges, >= for points
                            ap.add(node);
                    }

                    // this piece of code is to determine. > for bridges, >= for points
                    if(bridges != null)
                    {
                        if(low.get(adjNode) > disc.get(node)) {
                            bridges.put(node, bridges.getOrDefault(node, new ArrayList<T>()) );
                            bridges.get(node).add(adjNode);
                        }
                    }

                }
                else if(visited.get(adjNode)== true && adjNode != parent.get(node) )
                {
                    low.put(node, Math.min(low.get(node), disc.get(adjNode) ) );
                }

            }
        }

        public Set<T> findCutPoints()
        {
            Map<T, Boolean> visited = new HashMap<>();
            Map<T, T> parent= new HashMap<>();  //每個節點的父鄰節節點,就是第一個訪問此點的節點.
            Map<T, Integer> low= new HashMap<>();
            Map<T, Integer> disc= new HashMap<>(); //存每個節點是第幾個被訪問的?
            Set<T> ap = new HashSet<T>();
            time = 0;// 共有多少節點被訪問，0可代表該節點是第一個被訪問的.
            for(T node: adjList.keySet()) //為每節點預設
            {
                visited.put(node, false); // 設成從未訪問過
                parent.put(node, null); // root by deafult，自已是自己父親.
                low.put(node, 0);  
                disc.put(node, 0); // 該節點是第幾個被訪問?這是未知的。
            }
    
            for(T node: adjList.keySet())
            {
                if(visited.get(node)==false)
                findCutPoints(node, visited, parent, disc, low, ap, null);
            }

            return ap;
        }

        public Map<T, List<T>> findBridges()
        {
            Map<T, Boolean> visited = new HashMap<>();
            Map<T, T> parent= new HashMap<>();
            Map<T, Integer> low= new HashMap<>();
            Map<T, Integer> disc= new HashMap<>();
            Map<T, List<T>> bridges = new HashMap<>();

            time = 0;

            for(T node: adjList.keySet())
            {
                visited.put(node, false);
                parent.put(node, null); // root by deafult
                low.put(node, 0);
                disc.put(node, 0);
            }
    
            for(T node: adjList.keySet())
            {
                if(visited.get(node)==false)
                findCutPoints(node, visited, parent, disc, low, null, bridges);
            }

            return bridges;
        }
    }

    public void performTest()
    {
        Graph<Integer>  g = new Graph<>();

        // https://leetcode.com/discuss/interview-question/436073/
        g.addEdges(new Integer[][] { {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4} });
        System.out.println("Cut Points :" +  g.findCutPoints() );

        // https://leetcode.com/problems/critical-connections-in-a-network/
        g.clear();
        g.addEdges(new Integer[][] { {1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}} );
        System.out.println("Bridges (Cut Edges) :" + g.findBridges() );
        g.clear();
        g.addEdges(new Integer[][] { {1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6} } );
        System.out.println("Bridges (Cut Edges) :" + g.findBridges() );
        g.clear();
        g.addEdges(new Integer[][] { {1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9} } );
        System.out.println("Bridges (Cut Edges) :" + g.findBridges() );
    }

    public String toString() { return "Critical Routers & Connections, Articulation Points/Cut Point, Bridges/Cut Edges ([E]**):";}

}
