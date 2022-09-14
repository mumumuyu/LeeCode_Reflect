package treeNodeTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: LGD
 * @date:2022/9/13 17:44
 */
public class FindTarget {
    public static void main(String[] args) {

    }


    Set<Integer> sets = new HashSet<>();

    /**
     * hash + 深度优先
     * 执行用时：3 ms, 在所有 Java 提交中击败了50.48%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了96.85%的用户
     */
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        if (sets.contains(k-root.val))
            return true;
        sets.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }

    static List<Integer> nodes = new ArrayList<>();
    /**
     * 中序+双指针  更快
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.91%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了31.95%的用户
     */
    public boolean findTarget2(TreeNode root, int k ){
        inOrder(root);
        int left = 0,right = nodes.size() - 1;
        while(left < right){
            if (nodes.get(left) + nodes.get(right) == k)
                return true;
            if (nodes.get(left) + nodes.get(right) < k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.left);
        nodes.add(root.val);
        inOrder(root.right);
    }

    /**
     * 广度优先 +
     */
}
