package hyeongjun;

import java.util.Scanner;

public class bemin5 {
    public static void main(String[] args) {
        int[] pobi = {131,132};
        int[] crong = {211,212};
        int answer = 0;
        int pobicount = 0;
        int crongcount=0;
        if(Math.abs(pobi[0]-pobi[1])!=1 || Math.abs(crong[0]-crong[1])!=1){
            answer = -1;
        }else{
            pobicount = number(pobi);
            crongcount = number(crong);
            if(pobicount>crongcount) answer =  1;
            else if(pobicount<crongcount) answer = 2;
            else if(pobicount==crongcount) answer = 0;
        }


    }

    static int number(int[] pobi){
        int max = 0;
        String s = Integer.toString(pobi[0]);
        int sum = 0;
        int mux = 1;
        for(int i = 0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
            mux*=s.charAt(i)-'0';
        }
        max = (sum>mux) ? sum : mux;
        sum = 0;
        mux = 1;
        s = Integer.toString(pobi[1]);
        for(int i = 0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
            mux*=s.charAt(i)-'0';
        }
        max = (max<Math.max(sum,mux)) ? Math.max(sum,mux):max;
        return max;
    }
}
