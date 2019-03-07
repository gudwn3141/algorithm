package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class baek_1018 {
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M,answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] change, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        change = new boolean[N][M];
        visited = new boolean[N][M];
        answer = N*M;

        for(int i = 0;i<N;i++){
            String s = br.readLine();
            for(int j = 0;j<M;j++){
                board[i][j] = s.charAt(j);
            }
        }
        bfs(board);
        for(int i=0;i<=N-8 ;i++){
            for(int j = 0;j<=M-8;j++){
                min(i,j);
            }
        }
        System.out.println(answer);
    }
    static void min(int i, int j){
        int count = 0;
        for(int a = i;a<i+8;a++){
            for(int b = j; b<j+8;b++){
                if(change[a][b]){
                    count++;
                }
            }
        }
        answer = Math.min(Math.min(count,64-count),answer);
    }
    static void bfs(char[][] board){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        if(board[yy][xx]==board[ny][nx]){
                            change[ny][nx] = true;
                            if(board[yy][xx] == 'W'){
                                board[ny][nx] = 'B';
                            }else{
                                board[ny][nx] = 'W';
                            }
                        }
                        q.add(new Pair(nx,ny));
                    }
                }
            }
        }
    }
}