package treeNodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:    前中序构建树
 * 执行用时：8 ms, 在所有 Java 提交中击败了13.59%的用户
 * 内存消耗：86.3 MB, 在所有 Java 提交中击败了5.00%的用户
 *
 * 利用Map哈希扫描，存储中序结点位置 buildTree3
 * 执行耗时:1 ms,击败了99.92% 的Java用户
 * 内存消耗:40.9 MB,击败了88.22% 的Java用户
 * @author: LGD
 * @date:2022/8/1 10:02
 */
public class BuildTree {

    private static Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = buildTree(pre, in);
//        TreeNode treeNode = buildTreeTest(pre, in);
        TreeNode.show(treeNode);
    }

    public static TreeNode buildTreeTest(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(preorder,inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        //找出根节点所在中序位置
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
//        rootIndex = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));

        return root;
    }

    public static TreeNode buildTree2(int[] preorder, int[] endorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (endorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(endorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(endorder, rootIndex + 1, n));

        return root;
    }

    public static String print(int[] n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i :n){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len==0) return null;
        indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree2(preorder,inorder,0,len-1,0,len-1);
    }

    public TreeNode myBuildTree2(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight) {
        if (preLeft>preRight || inLeft>inRight) return null;

        int rootVal = preorder[preLeft];
        int rootIndex = indexMap.get(rootVal);
        int leftSize = rootIndex - inLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = myBuildTree2(preorder,inorder,preLeft + 1, preLeft + leftSize,inLeft,rootIndex-1);
        root.right = myBuildTree2(preorder,inorder,preLeft + leftSize + 1, preRight,1+rootIndex, inRight);
        return root;
    }
}
