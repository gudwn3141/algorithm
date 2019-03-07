package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2206 {
    static class Pair8{
        int x,y,z;
        Pair8(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int M,N, answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visitedbefore, visitedafter;
    static int[][] aftercount, beforecount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        visitedafter = new boolean[N][M];
        visitedbefore = new boolean[N][M];
        aftercount = new int[N][M];
        beforecount = new int[N][M];

        Queue<Pair8> wall = new LinkedList<>();
        for(int i = 0;i<N;i++){
            String s = br.readLine();
            for(int j = 0;j<M;j++){
                map[i][j] = s.charAt(j);
            }
        }
        if(N==1 && M==1){
            System.out.println(1);
        }else{
            bfs(map, wall);
            System.out.println(answer+1);
        }
    }
    static void bfs(char[][] map, Queue<Pair8> q){
        q.add(new Pair8(0,0,0));
        visitedafter[0][0] = true;
        visitedbefore[0][0] = true;
        while(!q.isEmpty()){
            Pair8 p = q.remove();
            int xx = p.x;
            int yy = p.y;
            int zz = p.z;
            for(int k=0;k<4;k++){
                int nx = xx+ dx[k];
                int ny = yy+ dy[k];
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    if(zz==1){
                        if(map[ny][nx]=='0' && !visitedafter[ny][nx]){
                            q.add(new Pair8(nx,ny,zz));
                            visitedafter[ny][nx] = true;
                            aftercount[ny][nx] = aftercount[yy][xx] + 1;

                        }
                    }else {
                        if (map[ny][nx] == '1' && !visitedbefore[ny][nx]) {
                            q.add(new Pair8(nx, ny, zz + 1));
//                            visitedafter[ny][nx] = true;
                            visitedbefore[ny][nx] = true;
                            aftercount[ny][nx] = beforecount[yy][xx] + 1;
                        } else if (map[ny][nx] == '0' && !visitedbefore[ny][nx]) {
                            q.add(new Pair8(nx, ny, zz));
                            visitedbefore[ny][nx] = true;

                            beforecount[ny][nx] = beforecount[yy][xx] + 1;

                        }
                    }
                }
            }
        }
//        System.out.println("aftercount");
//        for(int i = 0;i<N;i++){
//            for(int j = 0;j<M;j++){
//                System.out.print(aftercount[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("beforecount");
//        for(int i = 0;i<N;i++){
//            for(int j = 0;j<M;j++){
//                System.out.print(beforecount[i][j]+" ");
//            }
//            System.out.println();
//        }
        if(beforecount[N-1][M-1] !=0 && aftercount[N-1][M-1]!=0){
            answer = (beforecount[N-1][M-1]<aftercount[N-1][M-1]) ? beforecount[N-1][M-1] : aftercount[N-1][M-1];
        }else if(beforecount[N-1][M-1] ==0 && aftercount[N-1][M-1]==0){
            answer = -2;
        }else {
            answer = (beforecount[N - 1][M - 1] == 0) ? aftercount[N-1][M-1] : beforecount[N-1][M-1];
        }
    }
}