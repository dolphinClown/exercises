import java.util.*;
/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}
 */
public class MaxInWindows {
    //ʹ��˫�˶��У������д��Ԫ���±꣬�������飬���ֶ���ͷ��Ϊ�������ֵ��
    //��һ��Ԫ�����ʱ�����ж϶����Ƿ�Ϊ�գ����Ҷ�����Ԫ���Ƿ�С�ڴ�Ԫ�ء�
    //����Ϊ�գ�Ԫ��ֱ����ӣ���βԪ��С�ڴ�Ԫ�أ�������������Ԫ�س��ӣ������Ԫ��
    //��Ϊͷ������֮������Ԫ���Ȳ����β�������Ԫ���±��ȥ����ͷ��Ԫ���±���ڻ����
    //����ֵ����ͷ��Ԫ�س��ӡ�
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ret = new ArrayList<>();  
        if(num == null){  
            return ret;  
        }  
        if(num.length < size || size < 1){  
            return ret;  
        }  
          
        LinkedList<Integer> indexDeque = new LinkedList<>();//���ڱ��滬�������е�����
          
        //���������ڲ��������жϴ����е����ֵ
        for (int i = 0; i < size - 1; i++){
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();            //��ǰ���KС��ֱ���Ƴ����У���Ϊ�����ܳ�Ϊ�������ڵ����ֵ 
            }  
            indexDeque.addLast(i);//�����ִ��뻬��������
        }  
           
        //������������ 
        for (int i = size - 1; i < num.length; i++) {  
            while(!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]){
                indexDeque.removeLast();//��ǰ���KС��ֱ���Ƴ����У���Ϊ�����ܳ�Ϊ�������ڵ����ֵ
            }  
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }  
              
            ret.add(num[indexDeque.getFirst()]);
        }  
        return ret;
    }
}