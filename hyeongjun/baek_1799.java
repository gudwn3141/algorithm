package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1799 {
    static int N , answer = 0;
    static int[] dx = {1,1,-1,-1}, dy = {1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<Pair> list = new ArrayList<Pair>();
        N = Integer.parseInt(br.readLine());
        Queue<Pair> q = new LinkedList<>();
        int[][] board = new int[N][N];
        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;i++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k=0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(nx>-0 && nx<N && ny>=N && ny<N){
                    q.add(new Pair(nx,ny));
//                    if(board[ny][nx]==1);
                }
            }
        }

    }
    static void confirm(){

    }
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
