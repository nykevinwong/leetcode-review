    // bottom-up approach, postorder approach (array)
    public int[] sortArray(int[] nums) {
        if(nums.length<=1) return nums;

        int[] m1 =sortArray(Arrays.copyOfRange(nums,0, nums.length/2) );
        int[] m2 =sortArray(Arrays.copyOfRange(nums,nums.length/2, nums.length) );
        return mergeSort(m1, m2);
    }
    
    public int[] mergeSort(int[] left, int[] right)
    {
        int[] merged = new int[left.length+right.length];
        int i = 0;
        int j = 0;
        int c = 0;
        
        while(i < left.length && j < right.length)
            merged[c++] = left[i] < right[j] ? left[i++]: right[j++];
        
        while(i < left.length)
            merged[c++] = left[i++];
        
        while(j < right.length)
            merged[c++] = right[j++];
        return merged;
    }