package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class export_1953 {
    static int[] dx = {0,1,0,-1} , dy={-1,0,1,0};
    static int N,M,cnt, R,C,L;
    static boolean[][] visited;
    static int[][] map,count;
    static Queue<Pair> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++!=T){
            cnt = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for(int i = 0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = new int[N][M]; // L(시간) 카운트
            visited = new boolean[N][M]; // 방문유무
            q = new LinkedList<>();
            q.add(new Pair(C, R));
            visited[R][C] = true;
            count[R][C] = 1;
            while(!q.isEmpty()){
                Pair p = q.remove();
                int xx = p.x;
                int yy = p.y;
                if(count[yy][xx]==L) break; // 시간이 L이 되면 끝

                //상하좌우 비교
                if(map[yy][xx] == 1 || map[yy][xx] == 2 || map[yy][xx] == 4 || map[yy][xx] == 7) bfs(0,xx,yy);
                if(map[yy][xx] == 1 || map[yy][xx] == 3 || map[yy][xx] ==4 || map[yy][xx] ==5) bfs(1,xx,yy);
                if(map[yy][xx] == 1 || map[yy][xx] == 2 || map[yy][xx] == 5 || map[yy][xx] == 6) bfs(2,xx,yy);
                if(map[yy][xx] == 1 || map[yy][xx] == 3 || map[yy][xx] == 6 || map[yy][xx] == 7) bfs(3,xx,yy);
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
    static void bfs(int k, int xx, int yy){
        int nx = xx + dx[k];
        int ny = yy + dy[k];
        boolean t = false;
        if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[ny][nx]){
            if(k==0){
                if(map[ny][nx] == 1 || map[ny][nx] == 2 || map[ny][nx] == 5 || map[ny][nx] == 6) t = true;
            }else if(k==1){
                if(map[ny][nx] == 1 || map[ny][nx] == 3 || map[ny][nx] == 6 || map[ny][nx] == 7) t = true;
            }else if(k==2){
                if(map[ny][nx] == 1 || map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 7) t = true;
            }else if(k==3){
                if(map[ny][nx] == 1 || map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 5) t = true;
            }
            if(t){
                q.add(new Pair(nx,ny));
                count[ny][nx] = count[yy][xx]+1;
                cnt++;
                visited[ny][nx] =true;
            }
        }
    }
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
