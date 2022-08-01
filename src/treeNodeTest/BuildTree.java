package treeNodeTest;

import java.util.Arrays;

/**
 * @Description:    前中序构建树
 * @author: LGD
 * @date:2022/8/1 10:02
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = buildTree(pre, in);
        TreeNode.show(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));

        return root;
    }

    public static String print(int[] n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i :n){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
