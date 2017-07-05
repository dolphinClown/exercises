/***
 * ͳ��һ�����������������г��ֵĴ���
 */
public class GetNumberOfK {
    //ʹ�ö��ֲ���˼�룬���ҳ��м����� mid�����Ҫ���ҵ����� k С�� mid ����� mid ��ߵ������ж��ֲ��ң�
    //������� mid����� mid �ұߵ������ж��ֲ��ҡ��ֱ��ҳ���һ�� k �� ���һ�� k ���±꣬������� k �ĸ���
    public int getNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
		int count = 0;
        int first = getFirstK(array, k);
        int last = getLastK(array, k);
        if(first > -1 && last > -1){
            count = last - first + 1;
        }
        return count;
    }
    public int getFirstK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                if(mid > 0 && array[mid - 1] != k || mid == 0){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public int getLastK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                if(mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}