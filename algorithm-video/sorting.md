# Bubble sort
``` 
in-place algoirthm
O(N^2) quadratic time
O(1) constant space
stable sort when euqality operator is NOT used for comparision.
```

# partition array into two parts.
we define unsorted interval on the left and sorted interval on the right.

sorted partition interval starts from the right-most:
```
index = last index of the arrray.
```
unsorted partition interval starts from the left-most: 0

# iteration of bubble sort

```
  for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex>=0; lastUnsortedIndex--)
    for(int j=0; j < lastUnsortedIndex;j++)
      if(arr[j] > arr[j+1]) 
      {
        int temp = arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
      }
```
starting from index 0. 
compare current index item and next index item. (or compare current index with the previous index item)
we can swap the smaller one to the left for ascending order.
we then increase current index by 1, and continue this process until current/next index hit/equals to last index. 

---
**NOTE**
  with two loops, first loop indciates the current last index, second loop only stop after last second index,
  we don't need to write if statement to check since second for-loop conditional statement is already checking.
---

once a iteration is done, we are sure that the right-most parition interval now contains the sorted data.
we can now see that sorted partition or right interval starts to grow, and the unsorted partition or left interval starts to shrink.
