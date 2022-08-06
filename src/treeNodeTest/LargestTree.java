package treeNodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * 执行用时：10 ms, 在所有 Java 提交中击败了6.75%的用户
 * 内存消耗：42.9 MB, 在所有 Java 提交中击败了5.07%的用户
 * @author: LGD
 * @date:2022/8/5 16:46
 */
public class LargestTree {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode init = TreeNode.init();
        startOrder(init,list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //easy 直接遍历 排序 取,摆烂刀法
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        startOrder(root,list);
        int[] ints = list.stream().sorted(Comparator.reverseOrder()).mapToInt(o -> o).toArray();
        return ints[k-1];
    }

    public static void startOrder(TreeNode treeNode, List<Integer> list){
        if(treeNode == null)
            return;
        list.add(treeNode.val);
        startOrder(treeNode.left,list);
        startOrder(treeNode.right,list);
    }

    public int maxDepth(TreeNode root) {
        return root==null? 0:(1 + Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}
