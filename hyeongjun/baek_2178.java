package hyeongjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2178 {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static final int dx[] = {0,0,1,-1};
    public static final int dy[] = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        sc.nextLine();
        for(int i =0;i<N;i++) {
            String t = sc.nextLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = t.charAt(j)-'0';
            }
        }
        boolean[][] check = new boolean[N][M];
        Queue<Pair> q = new LinkedList<Pair>();
        int[][] val = new int[N][M];
        check[0][0] = true;
        val[0][0] = 1;
        q.add(new Pair(0,0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k =0; k<4;k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny <M) {
                    if(check[nx][ny]==false && arr[nx][ny]==1) {
                        q.add(new Pair(nx,ny));
                        val[nx][ny] = val[x][y]+1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(val[N-1][M-1]);
    }
}