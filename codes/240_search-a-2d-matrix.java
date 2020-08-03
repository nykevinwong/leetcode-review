// divide-and-conquer approach

public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix==null || matrix.length==0) return false;
    
    return searchMatrix(matrix, target, 0,0, matrix[0].length-1, matrix.length-1);
}


public boolean searchMatrix(int[][] m, int target, int left, int top, int right, int bottom)
{
    // such boundary doesn't exist. no element to check.
    if(left > right || top > bottom) return false;
    
    // only one element. check this element.
    if(left==right && top==bottom) return m[top][left]==target;
    
    // caluclate pivot point & get value.
    int py = (top+bottom)/2; // or we use top + (bottom-top)/2 to avoid integer overflow.
    int px = (left+right)/2;   // or we use left + (right-left)/2 to avoid integer overflow.      
    int pValue = m[py][px];
    
    if(pValue < target)
    {
        boolean m2Found = searchMatrix(m, target, px+1, top, right, py);
        boolean m3Found = searchMatrix(m, target, left, py+1, px, bottom);
        boolean m4Found = searchMatrix(m, target, px+1, py+1, right, bottom);
        return m2Found || m3Found || m4Found;
    }
    else if(pValue > target)
    {
        boolean m1Found = searchMatrix(m, target, left, top, px, py);
        boolean m2Found = searchMatrix(m, target, px+1, top, right, py);
        boolean m3Found = searchMatrix(m, target, left, py+1, px, bottom);
        return m1Found || m2Found || m3Found;
        
    }
    
    return true; // pivotValue = target. found it.
    
}
