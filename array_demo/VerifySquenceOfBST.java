/**����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 *����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){
            return false;
        }
		return isBST(sequence, 0, sequence.length - 1);
    }
    
    public boolean isBST(int[] sequence, int start, int end){
        if(end <= start){
            return true;
        }
        //���е����һ��Ԫ��Ϊ��
        int root = sequence[end];
        //���������ҵ���������������������
        int i = start;
        for(; i < end; i++){
            if(sequence[i] > root){
                break;
            }
        }
        
        int j = i;
        for(; j < end; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        
        //�ݹ���жϸ��������������������Ƿ�Ϊ���������������������
        return isBST(sequence, start, i - 1) && isBST(sequence, i, j - 1);
    }
}