package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();  // 1~ N 까지 정수
        ArrayList<Integer> result = new ArrayList<>(); // 조세퍼스 결과값
        for(int i = 0;i<N;i++){
            arr.add(i+1);
        }
        // 인덱스는 0부터 시작하므로 -1해준다.
        int a = M-1;

        while(arr.size()!=0){
            if(a>=arr.size()){
                a%=arr.size();
            }
            result.add(arr.get(a));
            arr.remove(a); // 배열을 하나씩 줄이면서 검색

            a += (M-1);
        }

        //결과값 출력
        System.out.print("<");
        for(int i =0;i<result.size();i++){
            if(i==result.size()-1){
                System.out.print(result.get(i));
            }else{
                System.out.print(result.get(i)+", ");
            }
        }
        System.out.print(">");
    }
}