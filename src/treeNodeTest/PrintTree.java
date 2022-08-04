package treeNodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:    从上到下打印树
 * 可以参考BFS，广度优先遍历
 * 执行用时：1 ms, 在所有 Java 提交中击败了69.37%的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了82.62%的用户
 *
 * 递归方式
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.6 MB, 在所有 Java 提交中击败了33.05%的用户
 * @author: LGD
 * @date:2022/8/4 9:05
 */
public class PrintTree {

    static List<List<Integer>> Alists = new ArrayList<>();

    //BFS广度优先遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> treeNode = new LinkedList<>();
        if(root != null)
            treeNode.add(root);
        //直到一层没有任何treeNode
        while(!treeNode.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            //随层数增加
            for (int i = treeNode.size(); i > 0; i--) {
                TreeNode poll = treeNode.poll();
                list.add(poll.val);
                if(poll.left != null)
                    treeNode.add(poll.left);
                if(poll.right != null)
                    treeNode.add(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
    //递归    按照层数来
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        level(root,1);
        return Alists;
    }

    public static void level(TreeNode tree,int Asize){
        if(tree == null)
            return;
        ArrayList<Integer> list;
        if(Alists.size() < Asize)
            Alists.add(new ArrayList<>());
        Alists.get(Asize-1).add(tree.val);
        level(tree.left,Asize+1);
        level(tree.right,Asize+1);
    }

    public static void main(String[] args) {
        TreeNode init = TreeNode.init();
        List<List<Integer>> lists = levelOrder2(init);
        System.out.println(lists.toString());
    }
}
