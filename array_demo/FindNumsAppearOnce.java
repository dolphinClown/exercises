//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */
public class FindNumsAppearOnce {
    // ������ͬ���֣�������ý���϶������Ϊ 1 ��λ���� 0 ^ 1�����ԣ��������ִ�λΪ 0 �� 1��
    // �������Ϊ����
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        //1. ����������Ԫ������������õ���ֵΪ������Ҫ�����ֵ��������
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        //2. �ҵ� result �����Ʊ�ʾ�д������󣬵�һ�� 1 ���ֵ�λ�ã���Ϊ n
        int n = 0;
        while (((result & 1) == 0) && n < 32) {
            result = result >> 1;
            n++;
        }
        //3. ��ԭ�����Ϊ���������飬ÿ�����������һ��Ҫ�ҵ����֣������������ֱַ�������������ͬ����
        for (int i = 0; i < array.length; i++) {
            if (isBit1AtNth(array[i], n)) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
    
    public boolean isBit1AtNth(int number, int n) {
        number = number >> n;
        return (number & 1) == 1;
    }
}