/*
����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class FindKthNode {
    private static int num;
    public TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null || k <= 0) {
            return null;
        }
        num = k;
        return findKthNode(pRoot);
    }
    public TreeNode findKthNode(TreeNode pRoot){
        TreeNode target = null;
        if (pRoot.left != null) {
            target = findKthNode(pRoot.left);
        }
        if (target == null) {
            if (num == 1) {
                target = pRoot;
            }
            num--;
        }
        if (target == null && pRoot.right != null) {
            target = findKthNode(pRoot.right);
        }
        return target;
    }
}