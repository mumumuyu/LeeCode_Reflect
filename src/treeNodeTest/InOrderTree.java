package treeNodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树前中后序都顺带了
 *
 * @author: LGD
 * @date:2022/8/2 9:25
 */
public class InOrderTree {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = BuildTree.buildTree(pre, in);
        TreeNode.show(treeNode);
        System.out.println("****************");
        List<Integer> integers = endorderTraversal(treeNode);
        for(Integer i : integers){
            System.out.println(i);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        inOrder(root,arrayList);
        return arrayList;
    }

    //中序
    public static void inOrder(TreeNode node , List<Integer> list){
        if(node == null)
            return;
        //先找到最左底
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preOrder(root,arrayList);
        return arrayList;
    }

    //先序
    public static void preOrder(TreeNode node , List<Integer> list){
        if(node == null)
            return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    public static List<Integer> endorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        endOrder(root,arrayList);
        return arrayList;
    }

    //后序
    public static void endOrder(TreeNode node , List<Integer> list){
        if(node == null)
            return;
        endOrder(node.left,list);
        endOrder(node.right,list);
        list.add(node.val);
    }
}
