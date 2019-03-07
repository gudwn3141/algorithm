package hyeongjun;
import java.util.Scanner;

public class baek_6359 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;
        for(int i=0;i<x;i++) {
            int a = sc.nextInt();
            for(int j=1;j<=a;j++) {
                if((j*j)<=a) {
                    count++;
                }else {
                    System.out.println(count);
                    count=0;
                    break;
                }
            }
        }
    }
}