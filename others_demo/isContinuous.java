/**
  * ���˿���������� 5 ���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ� 2-10λ���ֱ���
  * A Ϊ 1��J Ϊ 11�� Q Ϊ 12��K Ϊ 13������С�����Կ�����������
  */
public class IsContinuous {
    //˼·�����Ȱ���������ͳ�������� 0 �ĸ�����Ȼ���ҳ��������Ƿ��п�ȱλ��
    //����п�ȱλ���ж� 0 �ĸ����Ƿ�����ֲ������ԵĻ�����˵���������ġ�
    //����Ҫע��һ�㣺�������õ��������������ͬ�����֣����˿��ƽǶȿ����Ǵ��ڶ��ӣ�
    //			   ��ôҲ�ǲ������ġ�
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        //1. ����������
        sort(numbers);
        //2. ͳ�������� 0 �ĸ���
        int timesOfZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                timesOfZero++;
            }
        }
        //3. ͳ�ƿ�λ�ĸ���
        int numbersOfGap = 0;
        int small = timesOfZero; //��һ���� 0 ����
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numbersOfGap +=  numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return timesOfZero >= numbersOfGap ? true : false;
    }
    public void sort(int[] numbers) {
        int i;
        for (int p = 1; p < numbers.length; p++) {
            int temp = numbers[p];
            for (i = p; i > 0 && temp < numbers[i - 1]; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[i] = temp;
        }
    }
}