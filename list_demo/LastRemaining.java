/**
  * 0,1,...,n - 1 �� n �������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��
  * ɾ���� m �����֡�������ԲȦ��ʣ�µ����һ�����֡�
  */
public class LastRemaining {
	//Լɪ�����⣺1.�û�������ģ��ԲȦ�Ľⷨ   2.����ÿ��ɾ�������ֹ��ɲ�ֱ�Ӽ�������һ����
    public int lastRemaining1(int n, int m) {
         
        if(m <= 0 || n <= 0){
            return -1;
        }
        //�ȹ���ѭ������
        ListNode head = new ListNode(0); //ͷ���, ֵΪ0
        ListNode pre = head;
        ListNode temp = null;
        for(int i = 1; i < n; i++){
            temp = new ListNode(i);
            pre.next = temp;
            pre = temp;
        }
        temp.next = head;//����n-1�����(Ҳ����β���)ָ��ͷ���
         
        ListNode temp2 = null;
        while(n != 1){
            temp2 = head;
            //���ҵ���m������ǰ��
            for(int i = 1; i < m - 1; i++){
                temp2 = temp2.next;
            }
            //ɾ����m����㣺����m������ǰ��ָ���m���������Ǹ����,temp2��ʾ��m������ǰ��
            temp2.next = temp2.next.next;
            head = temp2.next; //����ͷ���
            n--;
        }
     
        return head.value;
         
    }

	public int lastRemaining2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
 
/**
 * ���
 */
class ListNode {
    int value;
    ListNode next = null;
     
    public ListNode(int val) {
        this.value = val;
    }
}