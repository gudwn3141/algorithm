package hyeongjun;

import java.util.Scanner;

public class bemin4 {
    static StringBuffer sb;
    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        sb = new StringBuffer(cryptogram);
        while(true){
            if(confirm()){
                break;
            }
        }
        System.out.println(sb);

    }
    static boolean confirm(){
        boolean check = true;
        for(int i = 0;i<sb.length();i++){
            int count = 0;
            char temp = sb.charAt(i);
            for(int j= i+1;j<sb.length();j++){
                char test = sb.charAt(j);
                if(temp==test){
                    count++;
                    if(j==sb.length()-1){
                        for(int k = j;k>=j-count;k--){
                            sb.deleteCharAt(k);
                        }
                    }
                }else{
                    if(count>0){
                        for(int k = j-1;k>=j-1-count;k--){
                            sb.deleteCharAt(k);
                        }
                        i--;
                        check = false;
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return check;
    }
}
