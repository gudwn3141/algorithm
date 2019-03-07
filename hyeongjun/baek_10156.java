package hyeongjun;

import java.util.Scanner;

public class baek_10156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long N = sc.nextLong();
        long M = sc.nextLong();
        if(K*N<=M) {
            System.out.println("0");
        }else {
            System.out.println(K*N-M);
        }
    }

}