
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*  @@DESCRIPTION
Amazon 題: 最大值的兩數之和.
找出一組陣列中總和為90的兩數. 如果有超過一組兩數，傳回有單個最大值的那組.  同一元素不可從覆使用.
*/
public class FindUniquePairsWithGivenSum implements IInterviewQuestion
{
    public List<List<Integer>> findUniquePairsWithGivenSum(int[] nums, int target)
    {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) 
        { 
            List<Integer> ls = pos.get(target-nums[i]);

            if(ls!= null && ls.size() > 0)
            {  // to DO. get rid of duplication.
                    int x = nums[i];
                    int y = nums[ls.get(0)];
                    int left = x > y ? x:y;
                    int right = x > y ? y:x;
                    res.add(Arrays.asList(left, right));
                    ls.remove(0);
            }
            else
            {
                pos.put(nums[i], pos.getOrDefault(nums[i], new ArrayList<Integer>()) );
                pos.get(nums[i]).add(i);
            }
        }

        return res;
    }

    public void performTest()
    {
      Helper.equals(findUniquePairsWithGivenSum(new int[] {1, 1, 2, 45, 46, 46 } , 47),
      new Integer[][] { {45, 2}, {46, 1}, {46 ,1}}, "Find Unique Pairs ");

      Helper.equals(findUniquePairsWithGivenSum(new int[] {1, 5, 1, 5} , 6 ),
      new Integer[][] { {5, 1}, {5, 1}}, "Find Unique Pairs ");

      Helper.equals(findUniquePairsWithGivenSum(new int[] {1, 5, 9, 1, 5, 3, 2, 7} , 6 ),
      new Integer[][] { {5, 1}, {5, 1}}, "Find Unique Pairs ");
    }

    public String toString() { return "Find Unqiue Pair With Given Sum ([E,I]**) [https://leetcode.com/discuss/interview-question/372434]: ";}
}
