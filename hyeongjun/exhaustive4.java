package hyeongjun;

public class exhaustive4 {
    public static void main(String[] args){
        int brown = 8;
        int red = 1;
        int[] answer = new int[2];
        for(int i = 1; i<=red;i++){
            if(red%i==0){
                int a = red/i;
                if((a+i+2)*2==brown){
                    if(a>=i){
                        answer[0] = a+2;
                        answer[1] = i+2;
                    }else{
                        answer[0] = i+2;
                        answer[1] = a+2;
                    }
                    break;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
