package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class export_5658 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String[] number = new String[N];

            String numbers = br.readLine();
            for(int i = 0;i<N;i++){
                number[i] = String.valueOf(numbers.charAt(i));
            }

            //중복없애기위해
            Set set = new HashSet();

            for(int i = 0;i<N/4;i++){
                number = rotate(number);
                for(int j=0;j<4;j++){
                    StringBuffer pw = new StringBuffer();
                    for(int k=j*N/4;k<j*N/4+N/4;k++){
                        pw.append(number[k]);
                    }
                    int decimal = Integer.parseInt(pw.toString(),16);
                    set.add(decimal);
                }
            }

            //정렬을 위해
            List password = new ArrayList(set);
            Collections.sort(password);
            System.out.println("#"+t+" "+password.get(password.size()-K));
        }
    }
    //회전
    static String[] rotate(String[] number){
        String temp = number[0];
        for(int i = 0;i<N-1;i++){
            number[i] = number[i+1];
        }
        number[N-1] = temp;
        return number;
    }

}
