package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class export_5656 {
    static int T,N,W,H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            for(int i = 0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            System.out.println("#"+t+" ");
        }

    }
    static void dfs(){
        for(int i = 0;i<N;i++){
            for(int j=0;j<W;j++){

            }
        }
    }

}
