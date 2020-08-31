//多元樹的最大平均值
//每個節點下的子樹節點值全部相加除總節點個數就是該子樹平均值
//求那一個節點下的子樹平均值是全域最大平均值
class SubTreeWithMaximumAverage implements IInterviewQuestion
{
    class RefValue
    {
        public NaryTreeNode maxNode;
    }

    public NaryTreeNode getMaxAverageSubTree(NaryTreeNode root)
    {
        RefValue maxSubTree = new RefValue();
        float[] res = getSumAndAverage(root, maxSubTree);
        return maxSubTree.maxNode;
    }
    // postorder traveral, bottom-up approach
    public float[] getSumAndAverage(NaryTreeNode root, RefValue maxSubTree)
    {
        if(root==null) return new float[]{0,0, 0};
       //當前節點總和，當前最大平均及節點個數
        float sum = root.val; // 當前節點的值
        float maxAverage = 0; // 最大平均數未知
        float childCount = 1; //當前節點也算一個節點

        if(root.nodes.size() > 0)
        {
            for(NaryTreeNode child: root.nodes)
            {   //取得每節點的節點子樹總和值，最大平均值及子樹節點個數
                float[] res = getSumAndAverage(child, maxSubTree);     
                sum+= res[0]; //計算當前節點的總和值    
                childCount+=res[2];// 計算當前節點的                      
                if(maxAverage < res[1]) //比較所有個個子樹的最大平均值
                {                 
                    System.out.print(maxAverage +  " < " + res[1]); 
                    maxAverage = res[1]; // 更新當前節點的最大平均值
                    maxSubTree.maxNode = child; //更新全域最大平均值節點
                    System.out.println(" [" + maxSubTree.maxNode.val +"]");
                }
            }
            //計算當前節點平均值
            float average = sum / (childCount);
            if(maxAverage < average)
            {                 
                System.out.print(maxAverage +  " < " + average); 
                maxAverage = average;
                maxSubTree.maxNode = root;
                System.out.println(" [" + maxSubTree.maxNode.val +"]");
            }
        }
        //傳回當前節點子樹總和值，當前最大平均值及子樹節點個數
        return new float[]{sum, maxAverage, childCount };
    }

    public void performTest()
    {
        NaryTreeNode root = new NaryTreeNode(20);
        NaryTreeNode left = new NaryTreeNode(12);
        NaryTreeNode right = new NaryTreeNode(18);
        left.addNodes(new int[]{11,2,3});
        right.addNodes(new int[]{15,8});
        root.addNode(left);
        root.addNode(right);

        NaryTreeNode maxSubTree = getMaxAverageSubTree(root);
        System.out.println("18 = " + maxSubTree.val  );
    }

    public String toString() { 
        return "SubTree With Maximum Average [https://leetcode.com/discuss/interview-question/349617]";
    }

}
