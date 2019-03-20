package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class export_2115 {
    static int N,M,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t= 0;
        StringBuilder sb = new StringBuilder();
        while(t++!=T){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for(int i = 0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            


            sb.append("#"+t+" "+answer);
        }
        System.out.println(sb);

    }
}
