# Bubble sort
``` 
in-place algoirthm
O(N^2) quadratic time
O(1) constant space
stable sort when euqality operator is NOT used for comparision & never swap when two elments values are considered the same.
```

## partition array into two parts.
we define unsorted interval on the left and sorted interval on the right.

sorted partition interval starts from the right-most:
```
index = last index of the arrray.
```
unsorted partition interval starts from the left-most: 0 </br>
lastUnsortedIndex = arr.length-1.
the sorted parition grow from the right to left.

|unsorted interval   | sorted interval |
|    :----:   |          :---: |

## iteration of bubble sort

```java
  for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex>=0; lastUnsortedIndex--)
    for(int j=0; j < lastUnsortedIndex;j++)
      if(arr[j] > arr[j+1]) // >: ascending, <: descending, >= or <=: unstable sort
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

<hr>

# Selection Sort
``` 
in-place algoirthm
O(N^2) quadratic time
O(1) constant space
stable sort when euqality operator is NOT used for comparision & never swap when two elments values are considered the same.
```
## partition array into two parts.
the same as bubble sort with lastUnsortedIndex = arr.length-1.
the sorted parition grow from the right to left.
|unsorted interval   | sorted interval |
|    :----:   |          :---: |

## iteration of shell sort
outter loop is the same as bubble sort.

```java
  for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex>=0; lastUnsortedIndex--) { ... }
```

inner loop scan, find and keep the largest elment index within the current unsorted interval.
swap the largest element with the element in lastUnsortedIndex if they're not the same values. swap the same values will turn the sort unstable.
```java
  for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex>=0; lastUnsortedIndex--) 
  { 
     int largest = 0; // use largest elment index for acesnding sort. use smallest elment index for descending sort. 
      for(int i=0; i <= lastUnsortedIndex; i++) 
      { 
         if(arr[largest] < arr[i]) largest=i; // condition varies based on whether largest/smallest element index is used.
      }
      swap(largest, lastUnsortedIndex);// only swap if two elment values are not the same to keep the sort stable.
  }
  
```

<hr>

# Stable vs UnStable
stable sort means never swap when two element values are considered the same.
unstable sort means swap happens when two elemnets values are considered the same and this behavior changes the original ordering or relative ordering of duplicate items.

unstable sort algorithm doesn't reserve the original/relative ordering of duplicate items.
stable sort algorithm reserves the original/relative ordering of duplicate items.
this makes a big difference if we store objects by duplicate keys such as names, ages and etc.

a stable sort is perferable.

bubble sort is a stable sort since we only swap items when one is greather or smaller than the other. 
Never swap two duplicate items when they're equal. We can accidently turn a stable sort into unstable swap if we swap two duplicate items when they're equal.
