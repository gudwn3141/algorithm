package hyeongjun;

import java.util.Scanner;

public class bemin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuffer result = new StringBuffer();
        for(int i = 0;i<word.length();i++){
            char index = word.charAt(i);
            if(index==' '){
                result.append(index);
            }else{
                if(index>=65 &&index<78){
                    int temp = 2*(78-index)-1;
                    result.append((char) (index+temp));
                }else if(index>=78 && index<=90){
                    int temp = 2*(index-78)+1;
                    result.append((char) (index-temp));
                }else if(index<110 && index>96){
                    int temp = 2*(110-index)-1;
                    result.append((char) (index+temp));
                }else if(index<=122 && index>=110){
                    int temp = 2*(index-110)+1;
                    result.append((char) (index-temp));
                }

            }
        }
        String answer = result.toString();

        System.out.println(answer);
    }
}
