package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_9237 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for(int i = 0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int max = 0;
        int day = 2;
        for(int i = N-1;i>=0;i--){
            max = (tree[i]+day>max) ? tree[i]+day:max;
            day++;
        }
        System.out.println(max);
    }
}
