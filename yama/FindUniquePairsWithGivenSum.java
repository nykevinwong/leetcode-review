
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*  @@DESCRIPTION
Amazon 題: 最大值的兩數之和. 但陣列中的數字是可以重覆的
找出一組陣列中總和為90的兩數. 如果有超過一組兩數，傳回有單個最大值的那組.  同一元素不可從覆使用.
*/
public class FindUniquePairsWithGivenSum implements IInterviewQuestion
{
    public List<List<Integer>> findUniquePairsWithGivenSum(int[] nums, int target)
    {  //存對應數查照表，陣列上的各數可能是另一數的對應數。一陣列可以多個同一數字元素。
        Map<Integer, List<Integer>> pos = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) 
        { 
            List<Integer> ls = pos.get(target-nums[i]); // 查是否對應的數存在

            if(ls!= null && ls.size() > 0) //在當前數之前，有相對應的數存在
            {  // to DO. get rid of duplication.
                    int x = nums[i];  // 取得當前數
                    int y = nums[ls.get(0)]; // 取得相對應數
                    int left = x > y ? x:y; // 較大值在左
                    int right = x > y ? y:x; // 較小值在右
                    res.add(Arrays.asList(left, right)); //左大右小的答案格式
                    ls.remove(0); // 清除當前符合條件，不需要再使用.
            }
            else
            {   //如果對應的數不存在，記錄當前數，並存下索引位置.
                pos.put(nums[i], pos.getOrDefault(nums[i], new ArrayList<Integer>()) );
                pos.get(nums[i]).add(i); // 由於陣列內的整數可以重覆出現，用ArrayList存每個位置.
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
