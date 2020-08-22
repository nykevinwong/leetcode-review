
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*  @@DESCRIPTION
Amazon 題:多組的兩數之和.
找出一組陣列中總和為90的兩數. 如果有超過一組兩數，傳回每一組. 同一元素不可從覆使用.
*/
public class FindPairWithGivenSum implements IInterviewQuestion
{
    public List<List<Integer>> findPairWithGivenSum(int[] nums, int target)
    {   //存對應數查照表，陣列上的各數可能是另一數的對應數。一陣列可以多個同一數字元素。
        Map<Integer, List<Integer>> pos = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) 
        { 
            List<Integer> ls = pos.get(target-nums[i]);// 查是否對應的數存在

            if(ls!= null && ls.size() > 0) //在當前數之前，有相對應的數存在
            {
                    int idx1 = ls.get(0); // 在對照表裡的數是在當前數之前存的，索引值肯定較小。                   
                    int idx2 = i; // 當前索引值
                    int curMax = Math.max(nums[idx1],nums[idx2]); // 兩者取較大數值

                    ls.remove(0); // 清除當前符合條件，不需要再使用.
                    
                    if(curMax > max) // 如果該值是全局最大值, 這就是答案.
                    { 
                        max = curMax;
                        res.clear(); // 只要全局最大值答案，清除之前的已經不符合的答案.
                        res.add(Arrays.asList(idx1,idx2)); //答案格式必需照索引值大小排.
                    }

            }
            else
            {  //如果對應的數不存在，記錄當前數，並存下索引位置.
                pos.put(nums[i], pos.getOrDefault(nums[i], new ArrayList<Integer>()) );
                pos.get(nums[i]).add(i); // 由於陣列內的整數可以重覆出現，用ArrayList存每個位置.
            }
        }

        return res;
    }

    public void performTest()
    {
      Helper.equals(findPairWithGivenSum(new int[] {1, 10, 25, 35, 60 } , 90 - 30 ),
      new Integer[][] { {2, 3}}, "Find Pair ");
       
      Helper.equals(findPairWithGivenSum(new int[] {21,1,2,45,46,46} , 46 ),     
      new Integer[][] { {1, 3}}, "Find  Pairs ");

      Helper.equals(findPairWithGivenSum(new int[] {20, 50, 40, 25, 30, 10} , 90-30 ),     
      new Integer[][] { {1, 5}}, "Find  Pairs ");
      
    }

    public String toString() { return "Find Pair With Given Sum ([E,I]**) [https://leetcode.com/discuss/interview-question/356960]: ";}
}
