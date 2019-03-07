package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class baek_14502 {
    static class Pair4{
        int x;
        int y;
        Pair4(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, wall, virus, virustoo,pick;
    static int result;
    static Queue<Pair4> q = new LinkedList<Pair4>();
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = 0;
        wall = 3;
        result = 0;
        pick = N*M-3;
        map = new int[N][M];
        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus++;
                    q.add(new Pair4(j, i));
                }
                if (map[i][j] == 1) {
                    pick--;
                }
            }
        }
        virustoo = virus;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(map[i][j] == 0){
//                    System.out.println("map["+i+"]["+j+"] on");
                    map[i][j] = 1;
                    wall--;
                    dfs(i,j);
//                    System.out.println("map["+i+"]["+j+"] off??");
                }
            }
        }
        System.out.println(result);
    }
    private static void bfs(){
        Queue<Pair4> qq = new LinkedList<>(q);
        boolean[][] visited = new boolean[N][M];
        while(!qq.isEmpty()){
            Pair4 p = qq.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k=0;k<4;k++){
                int ax = xx+ dx[k];
                int ay = yy+ dy[k];
                if(ax>=0 && ax<M && ay>=0 && ay<N){
                    if(visited[ay][ax]==false && map[ay][ax]==0){
//                        System.out.println("x = "+ax+" y = "+ay);
                        qq.add(new Pair4(ax,ay));
                        visited[ay][ax] = true;
//                        System.out.println(virustoo);
                        virustoo++;
                    }
                }
            }
        }
    }
    static void dfs(int i, int j){
//        int n = i;
//        int m = j;
        if(wall==0){
            bfs();
//            System.out.println("result = "+result +" current safe = "+(pick-virustoo));
            if(result<(pick-virustoo)){
                result = pick-virustoo;
            }
            virustoo = virus;
        }else{
            for(int a = i;a<N;a++){
                for(int b =(a>i) ? 0:j+1;b<M;b++){
                    if(map[a][b] == 0){
//                        System.out.println("map["+a+"]["+b+"] on");
                        map[a][b] = 1;
                        wall--;
                        dfs(a, b);
                    }
                }
            }
        }
//        System.out.println("map["+i+"]["+j+"] off");
        map[i][j] = 0;
        wall++;
    }
}