package demo;

/**
 * ɾ�������������ظ���Ԫ��
 */
public class DeleteDuplication {

    // ˼·����Ҫ����ָ�룬һ��ָ��ǰһ���ڵ� preNode����һ��ָ��ǰ�ڵ� curNode��
    // ���������ȵĽڵ㣬curNode ����ƶ���preNode ���������� curNode.val�������ıȽϣ�
    // ֱ������ curNode �� curNode.next ����ȣ�preNode �Ϳ���ָ�� curNode.next
    // ע�⣺����ĵ�һ�������ܾͻ��ظ�����ʼ preNode=null���� preNode Ϊ null���ǾͰ� pHead ����Ϊ curNode.next
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = pHead; //���ڱ��������ҵ���һ�����ظ��Ľ��
        while (curNode != null) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                //����ǰ�ڵ�͵�ǰ�ڵ����һ�����ֵ���
                int value = curNode.val;
                while (curNode.next != null && curNode.next.val == value) {
                    curNode = curNode.next;
                }
                if (preNode == null) {
                    pHead = curNode.next;
                } else {
                    preNode.next = curNode.next;
                }
            } else {
                //��ǰ��㲻�����ظ������� preNode Ϊ��ǰ���
                preNode = curNode;
            }
            //���µ�ǰ���ָ�룬ָ����һ�����
            curNode = curNode.next;
        }
        return pHead;

    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
