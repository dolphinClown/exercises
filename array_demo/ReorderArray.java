public class Solution {
	//��һ��˼·������ð���㷨��ǰż�������ͽ�����
    public void reOrderArray(int [] array) {
       for(int i= 0; i < array.length - 1; i++){
            for(int j=0; j < array.length - 1 - i; j++){
                if(array[j] % 2 == 0 && array[j+1] % 2 == 1){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }
 
	//�ڶ���˼·���ٴ���һ������
	//ʱ�临�Ӷ�ΪO��n�����ռ临�Ӷ�ΪO��n�����㷨
	//����ͳ�������ĸ���
	//Ȼ���½�һ���ȳ����飬��������ָ�룬����ָ���0��ʼ��ż��ָ�������������ĩβ��ʼ ����������
    public void reOrderArray(int [] array) {
        if(array.length == 0|| array.length == 1) return;
        int oddCount=0;
		int oddBegin=0;
        int[] newArray = new int[array.length];
        for(int i=0; i < array.length; i++){
            if((array[i]&1)==1)
				oddCount++;
        }
        for(int i=0; i < array.length; i++){
            if((array[i]&1)==1)
				newArray[oddBegin++] = array[i];
            else
				newArray[oddCount++] = array[i];
        }
        for(int i=0; i < array.length; i++){
            array[i] = newArray[i];
        }
    }
}