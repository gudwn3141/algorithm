package hyeongjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_7576 {
    static class Pair3{
        int x;
        int y;
        Pair3(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int val = 0;
        boolean real = true;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean visited[][] = new boolean[N][M];
        Queue<Pair3> q = new LinkedList<Pair3>();
        int[][] arr = new int[N][M];
        int[][] result = new int[N][M];
        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                if(a==1) {
                    q.add(new Pair3(i,j));
                    result[i][j] = 1;
                }else if(a==-1) {
                    result[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            Pair3 p = q.remove();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            for(int k = 0;k<4;k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    if(visited[nx][ny] == false && arr[nx][ny]== 0) {
                        q.add(new Pair3(nx,ny));
                        visited[nx][ny] = true;
                        result[nx][ny] = result[x][y]+1;
                    }
                }
            }
        }
        val= result[0][0];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
        for(int i = 0;i<N;i++) {
            for(int j = 0;j<M;j++) {

                if(result[i][j] == 0) {
                    i = N-1;
                    real = false;
                    break;
                }else {
                    if(val<result[i][j]) {
                        val = result[i][j];
                    }
                }
            }
        }
        if(real==false) {
            System.out.println(-1);
        }else {
            System.out.println(val-1);
        }


    }

}