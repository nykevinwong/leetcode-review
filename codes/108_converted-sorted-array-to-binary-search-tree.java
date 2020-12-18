public TreeNode sortedArrayToBST(int[] nums) {
    return createBSTFromArray(nums, 0, nums.length-1);        
}

public TreeNode createBSTFromArray(int[] nums, int start, int end)
{
    if(nums==null || nums.length==0) return null;
    if(start  > end) return null;
    
    int mid = start+(end-start)/2;
    int value  = nums[mid];
    TreeNode node = new TreeNode(value);        
    node.left = createBSTFromArray(nums, start, mid-1);
    node.right = createBSTFromArray(nums, mid+1, end);
    return node;
}
