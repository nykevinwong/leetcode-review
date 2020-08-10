
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Map.Entry;
import java.util.Iterator;










// https://github.com/nykevinwong/TreeAlgorithm/blob/master/TreeTraversal.cs
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {  }
         TreeNode(int x) { val = x; }

         public static TreeNode createBinaryTreeFromArray(Integer[] arr)
         {
             return createBinaryTreeFromArray(arr, 0);
         }

         protected static TreeNode createBinaryTreeFromArray(Integer [] arr, int index)
         {
             if(arr.length > index)
             {
                 if(arr[index]==null) return null;

                 TreeNode node = new TreeNode(arr[index]);
                 node.left = createBinaryTreeFromArray(arr, 2*index+1);
                 node.right = createBinaryTreeFromArray(arr, 2*index+2);
                 return node;
             }
             return null;
         }
}


class NaryTreeNode {
    int val;
    List<NaryTreeNode> nodes = new ArrayList<NaryTreeNode>();
    
    public NaryTreeNode(int val) { this.val = val; }
    public void addNode(NaryTreeNode node)
    {
        if(!nodes.contains(node)) nodes.add(node);
    }

    public void addNodes(int[] arr)
    {
        for(int val: arr) { nodes.add(new NaryTreeNode(val)); }
    }
}




public class YamaInterview
{
    public static void main(String[] args)
    {
        IInterviewQuestion[] questions = new IInterviewQuestion[] {
            new JavaCollections(),
            new BinarySearch(),
            new TopKFrequentlyMentionedKeywords(),
            new RottinOranges(), // Zombin in Matrix
            new CriticalRoutersOrConnections(),
            new SearchSuggestionSystem(), // Product Suggestions
            new NumberOfClusters() , 
            new ReorderDataInLogFile(),
            new PartitionLabel(),
            new OptimalUtilization(), 
            new MinimumCostToConnectRope(),
            new TreasureIsland(),
            new TreasureIsland2(),
            new FindPairWithGivenSum(),
            new CopyRandomLinkedList(),
            new MergeTwoSortedList(),
            new SubtreeOfAnotherTree(),
            new SearchMatrix(), // CORRECT 
            new FavoriteGenres(),
            new FindUniquePairsWithGivenSum(),
            new SubstringsOfExactlyKDistinctChars(), // MAYBE INCORRECT
            new SubarraysWithKDifferentIntegers(),
            new LongestStringWithThreeConsecutiveCharacters(), // longest numbers with K consecutive numbers. (MAYBE INCORRECT?)
            // Max of Min Altitudes
            new LongestPlaindromicSubstring(),
            new SubstringsOfSizeKwithKDistinctChars(),
            new MostCommonWord(),
            new KClosetPointstoOrigin(),
            new GenerateParentheses(),
            // below class can resolve two problems :(1) Min Cost to connect all nodes  (2) Min Cost to Repait Edges
            new MinCostToConnectAllNodesOrRepairEdges(),            
            new PrisonCellsAfterNDays(),
            new SubTreeWithMaximumAverage(),
            // Other
            new MergeIntervals(),

            new FindNUniqueIntegersSumUpToZero(),
            new NthGeometricProgression()
        }; 

        int count = 1;
        int technique = 1;
        for(IInterviewQuestion q: questions) { 

            if(args.length==1 && !q.getClass().getName().equalsIgnoreCase(args[0]) ) continue;

            if(q instanceof IImportTechnique)
            {
                System.out.println("*** TECHNIQUE " + technique + " *** " + q);
                q.performTest(); technique++;
                System.out.println("\n---------------------------\n");
            }
            else if(q instanceof IInterviewQuestion)
            {
                System.out.println("(" + count + ") " + q);
                q.performTest(); count++;
                System.out.println("\n---------------------------\n");
            }
        }


    }
}
