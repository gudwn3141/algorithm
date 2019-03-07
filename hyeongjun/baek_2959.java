package hyeongjun;

/*

거북이

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] len = new int[4];

        for(int i = 0;i<4;i++){
            len[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(len);

        //규칙 : 가장 큰 두 수 중 작은수 * 가장 작은 두 수 중 작은수
        System.out.println(len[0]*len[2]);


    }
}
