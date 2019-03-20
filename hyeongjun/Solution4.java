package hyeongjun;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] floor = new int[N];
        for(int i = 0;i<N;i++){
            floor[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0;i<N-1;i++){
            if(N-1-i>max){
                int start = floor[i];
                int currentlen = 0;
                for(int j =i+1;j<N;j++){
                    if(floor[j]>=start){
                        break;
                    }else{
                        currentlen++;
                    }
                }
                max = (max<currentlen+1) ? currentlen+1 : max;
            }
        }

        System.out.println(max);
    }
}
