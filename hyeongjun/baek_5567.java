package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_5567 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int[][] relation = new int[n+1][n+1];
        StringTokenizer st;
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        boolean[] friends = new boolean[n+1];
        for(int i=2;i<n+1;i++){
            if(relation[1][i]==1){
                friends[i] = true;
                for(int j=2;j<n+1;j++){
                    if(relation[i][j]==1 && !friends[j]){
                        friends[j] = true;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=2;i<n+1;i++){
            if(friends[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
