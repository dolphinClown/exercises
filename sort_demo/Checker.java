import java.util.*;
/**
  *�����һ����Ч�㷨���ж��������Ƿ����ظ�ֵ�����뱣֤����ռ临�Ӷ�Ϊ O(1)������һ�� int ���� A �����Ĵ�С n���뷵�����Ƿ����ظ�ֵ��
  */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // ˼·��ʹ�ö�������ɾ���������С����ͬʱ������һ��ɾ����Ԫ�ؽ��бȶԣ������ȣ�
        //      �����ȵ�Ԫ�أ���˵���ظ���
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("��������");
        }
        boolean flag = false;
        for (int i = n / 2; i >= 0; i--) {
            buildHeap(a, i, n);
        }
        int lastOne;
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            lastOne = a[i];
            buildHeap(a, 0, i);
            if (lastOne == a[0]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    public void buildHeap(int[] a, int index, int length){
        int child;
        int temp = a[index];
        for( ; index * 2 + 1 < length; index = child){
            child = index * 2 + 1;
            if(child != length - 1 && a[child] < a[child + 1]){
                 child++;
            }
            if(temp > a[child]){
                break;
            } else {
                a[index] = a[child];
                index = child;
            }
        }
         a[index] = temp;
    }
     
    public void swap(int[] a,int m,int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}