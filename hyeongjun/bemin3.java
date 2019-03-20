package hyeongjun;

import java.util.Scanner;

public class bemin3 {

    public static void main(String[] args) {
        int number = 33;

        int count = 0;
        for(int i = 1;i<=number;i++){
            String nb = Integer.toString(i);
            for(int j = 0;j<nb.length();j++){
                if(nb.charAt(j)=='3' || nb.charAt(j) == '6' || nb.charAt(j)=='9'){
                    System.out.println(nb);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
