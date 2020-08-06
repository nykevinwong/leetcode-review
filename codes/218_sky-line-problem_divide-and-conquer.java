// https://leetcode.com/problems/the-skyline-problem/discuss/725244/two-Java-solutions-and-two-Python-solutions-with-explanation-in-codes

class Solution {
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
		if (buildings.length == 0)
			return new LinkedList<List<Integer>>();
		return recurSkyline(buildings, 0, buildings.length - 1);
	}

	private LinkedList<List<Integer>> recurSkyline(int[][] buildings, int l, int r) {
		if (l == r) {
			LinkedList<List<Integer>> rs = new LinkedList<>();
			rs.add( Arrays.asList( buildings[l][0], buildings[l][2]) );
			rs.add( Arrays.asList( buildings[l][1], 0) ) ;
			return rs;
		} else {
			int mid = l + (r - l) / 2;
			return merge(recurSkyline(buildings, l, mid),
					recurSkyline(buildings, mid + 1, r));
		}
	}
    
    private LinkedList<List<Integer>> merge(LinkedList<List<Integer>> l1, LinkedList<List<Integer>> l2)
    {
       LinkedList<List<Integer>> sorted = new  LinkedList<>();
       int h1 =0, h2 = 0;
       int i =0, j =0;
       int prevH = -1;
        
        while(i < l1.size() && j < l2.size())
        {
            int x = 0, maxH = 0;
            if(l1.get(i).get(0) < l2.get(j).get(0))
            {
                x = l1.get(i).get(0);
                h1 = l1.get(i).get(1);
                i++;
            }
            else if(l1.get(i).get(0) > l2.get(j).get(0))
            {
                x = l2.get(j).get(0);
                h2 = l2.get(j).get(1);
                j++;
            }
            else
            { // handle corner case where two intervals with the same height.
                x = l1.get(i).get(0);
                h1 = l1.get(i).get(1);
                h2 = l2.get(j).get(1);
                i++; j++;
            }
                maxH = Math.max(h1,h2);
                // if it's not equal to the previous height.
                if(sorted.size()==0 || maxH != sorted.getLast().get(1)) 
                    sorted.add(Arrays.asList(x, maxH));
        }

        while(i < l1.size()) sorted.add(l1.get(i++)); 
        while(j < l2.size()) sorted.add(l2.get(j++)); 
        
        return sorted;
    }
    
}