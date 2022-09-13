package treeNodeTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了55.66%的用户
 * @author: LGD
 * @date:2022/9/13 17:23
 */
public class IncresingBST {
    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5};
        int[] in = {2,1,4,3,5};
        TreeNode treeNode = BuildTree.buildTree(pre, in);
        TreeNode treeNode1 = increasingBST(treeNode);
        TreeNode.show(treeNode1);
    }

    public static TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> lists = new ArrayList<>();
        inOrder(root,lists);
        if (lists.isEmpty())
            return null;
        TreeNode treeNode = new TreeNode(-1);
        TreeNode curren = treeNode;
        //类似链表,指定其右子树后让其变为其右子树继续
        for (TreeNode num:lists) {
            curren.right = new TreeNode(num.val);
            curren = curren.right;
        }
        return treeNode.right;
    }

    public static void inOrder(TreeNode node, ArrayList<TreeNode> nodes){
        if (node == null)
            return;
        inOrder(node.left,nodes);
        nodes.add(node);
        inOrder(node.right,nodes);
    }
}
