package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_15683 {
    static int N,M, answer = 0;
    static int[][] map;
    static Queue<Pair> cameraplace;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cameraplace = new LinkedList<>();

        map = new int[N][M];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0 && map[i][j]<6) cameraplace.add(new Pair(j,i,map[i][j]));
            }
        }

        for(int i = 0;i<4;i++){
            int[][] copymap = new int[N][M];
            find(copymap,i);

        }
    }
    static void find(int[][] copymap, int direction){
        while(!cameraplace.isEmpty()){
            Pair p = cameraplace.remove();
            int xx = p.x;
            int yy = p.y;
            int camera = p.camera;
//            direction(camera, direction);
            if(camera==1){
                if(direction==0) confirm_right(xx,yy);
                else if(direction==1) confirm_down(xx,yy);
                else if(direction==2) confirm_left(xx,yy);
                else if(direction==3) confirm_up(xx,yy);
            }else if(camera == 2){
                if(direction==0 || direction==2){
                    confirm_right(xx,yy);
                    confirm_left(xx,yy);
                }else if(direction==1 || direction==3){
                    confirm_down(xx,yy);
                    confirm_up(xx,yy);
                }
            }else if(camera==3){
                if(direction==0){
                    confirm_up(xx,yy);
                    confirm_right(xx,yy);
                }else if(direction==1){
                    confirm_down(xx,yy);
                    confirm_right(xx,yy);
                }else if(direction==2){
                    confirm_left(xx,yy);
                    confirm_down(xx,yy);
                }else if(direction==3){
                    confirm_left(xx,yy);
                    confirm_up(xx,yy);
                }
            }else if(camera==4){
                if(direction==0){
                    confirm_left(xx,yy);
                    confirm_up(xx,yy);
                    confirm_right(xx,yy);
                }else if(direction==1){
                    confirm_up(xx,yy);
                    confirm_down(xx,yy);
                    confirm_right(xx,yy);
                }else if(direction==2){
                    confirm_right(xx,yy);
                    confirm_left(xx,yy);
                    confirm_down(xx,yy);
                }else if(direction==3){
                    confirm_down(xx,yy);
                    confirm_left(xx,yy);
                    confirm_up(xx,yy);
                }
            }else if(camera==5){
                confirm_down(xx,yy);
                confirm_right(xx,yy);
                confirm_up(xx,yy);
                confirm_left(xx,yy);
            }

        }
    }
    static void confirm_right(int xx, int yy){
        while(xx+1<M && map[yy][xx+1]!=6){
            xx++;
            if(map[yy][xx]==0) map[yy][xx] = -1;
        }
    }
    static void confirm_down(int xx, int yy){
        while(yy+1<N && map[yy+1][xx]!=6){
            yy++;
            if(map[yy][xx]==0) map[yy][xx] = -1;
        }
    }
    static void confirm_left(int xx, int yy){
        while(xx-1>0 && map[yy][xx-1]!=6){
            xx--;
            if(map[yy][xx]==0) map[yy][xx] = -1;
        }
    }
    static void confirm_up(int xx, int yy){
        while(yy-1>0 && map[yy-1][xx]!=6){
            yy--;
            if(map[yy][xx]==0) map[yy][xx] = -1;
        }
    }

    static class Pair{
        int x,y,camera;
        Pair(int x,int y,int camera){
            this.x = x;
            this.y = y;
            this.camera = camera;
        }
    }
    static void copy(){

    }
}
