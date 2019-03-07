package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class baek_3055 {
    static class Pair6{
        int x,y;
        Pair6(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int R,C;
    static char[][] map;
    static int[][] watercount, pointcount;
    static Queue<Pair6> point, waters;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
//        Scanner sc = new Scanner(System.in);
//        R = sc.nextInt();
//        C = sc.nextInt();
        boolean watervisited[][] = new boolean[R][C];
        boolean pointvisited[][] = new boolean[R][C];
        watercount = new int[R][C];
        pointcount = new int[R][C];
//        sc.nextLine();
        map = new char[R][C];
        point = new LinkedList<>();
        waters = new LinkedList<>();
        int val_x = 0;
        int val_y = 0;
        for(int i = 0;i<R;i++) {
            String b = br.readLine();
//            String b = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = b.charAt(j);
                if(map[i][j]=='*'){ // 물의 위치
                    watervisited[i][j] = true;
                    waters.add(new Pair6(j,i));
                }else if(map[i][j] == 'S'){ // 고슴도치 위치
                    pointvisited[i][j] = true;
                    point.add(new Pair6(j,i));
                }else if(map[i][j] == 'D'){ // 비버 굴
                    val_x = j;
                    val_y = i;
                }
            }
        }
        br.close();
        water(watervisited);
        point(pointvisited);


        System.out.println((pointcount[val_y][val_x]==0) ? "KAKTUS" : pointcount[val_y][val_x]);

    }
    static void water(boolean[][] watervisited){ // 물 확장 bfs
        while(!waters.isEmpty()){
            Pair6 p = waters.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k =0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(ny>=0 && ny<R && nx>= 0 && nx<C){
                    if(!watervisited[ny][nx] && map[ny][nx]=='.'){
                        watervisited[ny][nx]=true;
                        watercount[ny][nx] = watercount[yy][xx]+1; // 물 확장 속도
                        waters.add(new Pair6(nx,ny));
                    }
                }
            }
        }
    }
    static void point(boolean[][] pointvisited){
        while(!point.isEmpty()){
            Pair6 p = point.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k =0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(ny>=0 && ny<R && nx>= 0 && nx<C){
                    if(!pointvisited[ny][nx] && (map[ny][nx]=='.'|| map[ny][nx]=='D')){
                        pointvisited[ny][nx] = true;
                        pointcount[ny][nx] = pointcount[yy][xx]+1; // 고슴도치 이동 속도

                        if(watercount[ny][nx]>pointcount[ny][nx] || watercount[ny][nx]==0){
                            point.add(new Pair6(nx,ny));
                        }
                    }
                }
            }
        }
    }
}