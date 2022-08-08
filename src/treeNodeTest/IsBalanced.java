package treeNodeTest;

/**
 * @Description:
 * 执行用时：1 ms, 在所有 Java 提交中击败了55.77%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了87.76%的用户
 * @author: LGD
 * @date:2022/8/8 16:58
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode init = TreeNode.init();
        System.out.println(isBalanced(init));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
