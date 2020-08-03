public TreeNode sortedArrayToBST(int[] nums) {
    return createBSTFromArray(nums, 0, nums.length-1);
}

public TreeNode  createBSTFromArray(int[] nums, int start, int end)
{
    if(start > end) return null; // stop condition
    
    int mid = (start+end)/2;        
    int value = nums[mid];        
    TreeNode node = new TreeNode(value);
    node.left = createBSTFromArray(nums, start, mid-1);
    node.right = createBSTFromArray(nums, mid+1, end);
    return node;
}