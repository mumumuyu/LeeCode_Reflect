package treeNodeTest;
/**
* @Description: 二叉树反转   对称二叉树
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 对称:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了36.01%的用户
* @author: LGD
* @date:2022/8/3 14:15
*/
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode init = TreeNode.init();
        TreeNode.show(init);

        TreeNode treeNode = mirrorTree(init);
        TreeNode.show(treeNode);
        System.out.println(isSymmetric(treeNode));
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);

        root.left = left;
        root.right = right;

        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root,root);
    }

    public static boolean isMirror(TreeNode left , TreeNode right) {
        if(left == null && right== null)
            return true;
        if(left == null || right== null)
            return false;

        return left.val == right.val && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

}
