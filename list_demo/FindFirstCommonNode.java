/*��������ĵ�һ���������
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindFirstCommonNode {
    //�ȷֱ������������ĳ��ȣ�������������ĳ��Ȳ�ֵ n��Ȼ���ýϳ����������� n ����
    //���ͬʱ���������������������н���������Ľ��ֵ��Ƚϣ�ֱ���ҵ���һ����Ƚڵ㣬����
    public ListNode fFindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1 == null || pHead2 == null){
            return null;
        }
        //1.��������������
        int length1 = 0;
        int length2 = 0;
        ListNode position1 = pHead1;
        ListNode position2 = pHead2;
        while(position1 != null){
            length1++;
            position1 = position1.next;
        }
        while(position2 != null){
            length2++;
            position2 = position2.next;
        }
        //2.�����ֵ
        int diff = 0;
        //3.�ϳ����������� diff ��
        if(length1 >= length2){
            diff = length1 - length2;
            for(int i = 1; i <= diff; i++){
                pHead1 = pHead1.next;
            }
        }else{
            diff = length2 - length1;
            for(int i = 1; i <= diff; i++){
                pHead2 = pHead2.next;
            }
        }
        //4.ͬʱ�������������ҵ���һ���������
        while(pHead1 != null && pHead2 != null){
            if(pHead1.val == pHead2.val){
                return pHead1;
            }else{
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}