package hyeongjun;

public class sort2 {
    static boolean ver;
    static int test[];
    public String solution(int[] numbers) {
        ver = false;
        String answer = "";
        int N = numbers.length;
        test = new int[N];


        merge(numbers,0,N-1);
        if(ver == false){
            answer = "0";
        }else{
            for(int i = N-1;i>=0;i--){
                answer = answer+Integer.toString(numbers[i]);
            }
        }
        return answer;
    }
    private static void merge(int[] number, int left, int right) {
        if(number[left]!=0){
            ver = true;
        }
        if(left<right){
            int i;
            int p = 0;
            int j = 0;
            int center = (left+right)/2;
            merge(number, left, center);
            merge(number,center+1, right);
            for(i = left; i<=center;i++){
                test[p++] = number[i];
            }
            while(i<=right && j<p){
                if(Integer.parseInt(Integer.toString(test[j])+Integer.toString(number[i])) <= Integer.parseInt(Integer.toString(number[i])+Integer.toString(test[j]))){
                    number[left++] = test[j++];
                }else{
                    number[left++] = number[i++];
                }
            }
            while(j<p){
                number[left++] = test[j++];
            }
        }
    }
}
