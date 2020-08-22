public class BinarySearch implements IInterviewQuestion, IImportTechnique 
{
    // 傳回所找元素的位置，找不到，則傳回該元素該被插入的位置(insertion position)
    // lowerBound(低值邊界，左邊界): true -> 有重覆元素時，傳回重覆元素的左邊界或靠低值的邊界
    // lowerBound(低值邊界，左邊界): false-> 有重覆元素時，傳回重覆元素的右邊界或靠右值的邊界
    // 將負插入位置轉成正值後減一就是，該元素該被插入的位置.
    public int binarySearch(int[] arr, int key, boolean lowerBound)
    {  // 傳入的陣列必須是要排序好,才能Binar Search.
        int left = 0; int right = arr.length - 1; // 設定雙指標遍歷區間範圍
        int lastKeyPos = -1;//最後一個找到的鍵值位置， -1為沒找到鍵值.

        while(left <= right) //陣列只有一個元素時，left==right時，也得執行.
        {
            int mid = left+(right-left) / 2; //免integer overflow的寫法
            int cur  = arr[mid];

            if(key > cur) left = mid+1; //要找的值大於當前中點值，往右找，縮左邊邊界.
            else if(key < cur) right = mid-1; //要找的值小於當前中點值，往左找，縮右邊邊界.
            else // key == cur // 找到了
            {
                lastKeyPos = mid; // 記錄當前位置

                if(lowerBound) right = mid-1; //如果是要找左邊界位置，縮右邊邊界,往左繼續找同一值。
                else left = mid+1; //如果是要找右邊界位置，縮左邊邊界,往右繼續找同一值。
            }
        
        }
        //鍵值找不到，就轉成該鍵值元素該被插入的位置. 不然，傳回找到鍵置的索引位置.
        return (lastKeyPos==-1) ? -(left+1) : lastKeyPos;
    }

    public void performTest()
    {
        int[] nums = new int[] { 1,2,2,2,2,3,3,3,4,4,6,6,6,7,8,9,10};
        

        System.out.print("Array: ");
        for(int i=0;i < nums.length; i++) System.out.print(String.format("[%2s]", nums[i]));
        System.out.println();

        System.out.print("Pos:   ");
        for(int i=0;i < nums.length; i++) System.out.print(String.format("{%2s}", i));
        System.out.println();

        System.out.println("\nLowerBound BinarySearch");
        for(int i=0;i < 12; i++)
        {
            int insertPosition =  binarySearch(nums, i, true);
            System.out.println("key = " + i + " => " + insertPosition);
        }

        System.out.println("\nUpperBound BinarySearch");
        for(int i=0;i < 12; i++)
        {
            int insertPosition =  binarySearch(nums, i, false);
            System.out.println("key = " + i + " => " + insertPosition);
        }

        System.out.println("Positive insert position = the actual found key position.");
        System.out.println("Negative insert postion (-insertPos -1) = the position of the least integer greater than key ");
    }

    public String toString() { 
        return "Binary Search []";
    }
}
