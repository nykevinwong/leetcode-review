#bubble sort

parition array into two parts.
one is unsorted array on the left.

sorted parition interval starts from the right-most: index = last index of the arrray.
unsorted parition interval starts from the left-most: 0

sort algorithm during interation of ascending buble sort:
starting from index 0. 
compare current index item and next index item. (or compare current index with the previous index item)
we can swap the smaller one to the left for ascending order.
we then increase current index by 1, and continue this process until current/next index hit/equals to last index. 

[ with two loops, first loop indciates the current last index, second loop only stop after last second index,
  we don't need to write if statement to check since second for-loop conditional statement is already checking.
]

once a iteration is done, we are sure that the right-most parition interval now contains the sorted data.
we can now see that sorted partition or right interval starts to grow, and the unsorted partition or left interval starts to shrink.

 
inplace algoirthm
O(N^2) quadratic time
O(1) constant space
