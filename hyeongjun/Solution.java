package hyeongjun;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = N;
        if(N==1){
            System.out.println(0);
        }else{
            for(int i = 1;i<=N/2;i++){
                if(N%i==0){
                    int a = N/i;
                    min = (min>Math.abs(a-i)) ? Math.abs(a-i) : min;
                }
            }
            System.out.println(min);
        }
    }
}
