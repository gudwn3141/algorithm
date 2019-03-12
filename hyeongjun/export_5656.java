package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class export_5656 {
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    static int T,N,W,H, answer;
    static boolean[][] blockconfirm;
    static Queue<Pair> nextsmashblock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int t = 0;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = W*H;
            int[][] map = new int[H][W];
            blockconfirm = new boolean[H][W];
            nextsmashblock = new LinkedList<>();
            for(int i = 0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=0) blockconfirm[i][j] = true;

                }
            }
            int breakcount = 0;
            dfs(breakcount, map);
            System.out.print("#"+t+" ");
            System.out.println((answer==W*H) ? 0 : answer);
        }

    }
    static void dfs(int breakcount, int[][] map){
        int blockcount = 0;
        if(breakcount==N){
            for(int i = 0;i<H;i++){
                for(int j = 0;j<W;j++){
                    if(map[i][j]!=0){
                        blockcount++;
                    }
                }
            }
            answer = (answer>blockcount) ? blockcount : answer;
        }else{
            for(int i=0;i<W;i++){
                for(int j=0;j<H;j++){
                    if (map[j][i]!=0){
                        int[][] premap = new int[H][W];
                        for(int n=0;n<H;n++){
                            for(int m=0;m<W;m++){
                                premap[n][m] = map[n][m];
                            }
                        }
                        nextsmashblock.add(new Pair(i,j,premap[j][i]));
                        smashblock(premap);
                        breakcount++;
                        dfs(breakcount,premap);

                        breakcount--;
                        break;
                    }
                }
            }
        }
    }
    static void smashblock(int[][] map){
        while(!nextsmashblock.isEmpty()){
            Pair p = nextsmashblock.remove();
            int xx = p.x;
            int yy = p.y;
            int range = p.range;
            map[yy][xx] = 0;
            for(int k = 0;k<4;k++){
                for(int i = 1;i<range;i++){
                    int nx = xx+dx[k]*i;
                    int ny = yy+dy[k]*i;
                    if(nx>=0 && nx<W && ny>=0 && ny<H && map[ny][nx]!=0){
                        int zz = map[ny][nx];
                        map[ny][nx] = 0;
                        nextsmashblock.add(new Pair(nx,ny,zz));
                    }
                }
            }
        }
        for (int i = H-2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 0) continue;

                int range = map[i][j];
                int temp = i;
                map[i][j] = 0;

                while(true) {
                    if(temp+1 >= H || map[temp+1][j] != 0) break;
                    temp++;
                }
                map[temp][j] = range;
            }
        }
    }
    static class Pair{
        int x,y,range;
        Pair(int x, int y,int range){
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }

}
