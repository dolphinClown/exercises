package sword;

/**
 * Created by CLAY on 2017/6/21.
 *����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ�� 
 */
public class ConvertToList {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //������������еĽ��
    public static TreeNode lastNodeInList = null;
    public static TreeNode convert(TreeNode pRootOfTree) {
        /*left �൱��˫����� pre ָ�룬 right �൱��˫����� next ָ��
          ʹ�������������Ҷ����������Ϊ left ָ��ָ��Ľ�㣬������Ϊ right ָ��ָ��Ľ��
          ���ĸ����� left ָ��ָ�������������ֵ��right ָ��ָ������������Сֵ
         */
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        convertNode(pRootOfTree);
        //�Ӻ���ǰ���ҵ������ͷ���
        TreeNode headNodeInList = lastNodeInList;
        while (headNodeInList != null && headNodeInList.left != null) {
            headNodeInList = headNodeInList.left;
        }
        return headNodeInList;
    }

    public static void convertNode(TreeNode root ) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            convertNode(root.left);
        }

        //����ǰ���� left ָ�����Ϊ��һ�μ�������Ľ�㣨lastNodeInList����
        //������һ�μ�������Ľ�㣨lastNodeInList���� right ָ��ָ��ǰ���
        root.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = root;
        }
        //�� lastNodeINList ����Ϊ����������Ľ��
        lastNodeInList = root;

        if (root.right != null) {
            convertNode(root.right);
        }
    }
}
