package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2146 {
    static int N;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int[][] map;
    static Queue<Pair> island, ver;
    static boolean[][] islandvisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        //지도 입력
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = N*N; // 답
        island = new LinkedList<>(); // 섬 위치
        ver = new LinkedList<>(); // 찾은 섬(1) 위치
        islandvisited = new boolean[N][N]; //섬 방문 여부

        for(int i = 0;i<N;i++){
            for(int j =0;j<N;j++){
                if(map[i][j] == 1 && !islandvisited[i][j]){
                    island.add(new Pair(j,i)); //1이면 큐에 넣는다.
                    ver.add(new Pair(j,i));
                    islandvisited[i][j] = true;
                    islandfind(); // 한 개의 섬을 찾는다.
                    int a = bridge(); // 다른섬까지의 최소 다리개수 계산
                    answer = (answer>a) ? a : answer; //최소값 구하기
                }
            }
        }
        System.out.println(answer);
    }
    // 한개의 섬 좌표를 q에 넣는 함수
    static void islandfind(){
        while(!island.isEmpty()){
            Pair p = island.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0;k<4;k++){
                int nx = xx+ dx[k];
                int ny = yy + dy[k];
                if(nx>=0 && ny<N && ny>=0 && nx<N){
                    if(map[ny][nx]==1 && !islandvisited[ny][nx]){
                        island.add(new Pair(nx,ny));
                        ver.add(new Pair(nx,ny)); //bridge 함수를 실행하기 위한 큐
                        islandvisited[ny][nx] = true;
                    }
                }
            }
        }
    }
    //islandfind에서 찾은 섬부터 주변 섬까지 최단 거리 반환
    static int bridge() {
        int bridge = 0; // 다른 섬이 나올 때 까지 만든 다리 개수
        int[][] bridgecount = new int[N][N]; // 만든 다리 개수
        boolean[][] visited = new boolean[N][N];
        while(!ver.isEmpty()){
            Pair p = ver.remove();
            int xx = p.x;
            int yy = p.y;
            visited[yy][xx] = true;
            for(int k = 0;k<4;k++) {
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if (nx >= 0 && ny < N && ny >= 0 && nx < N) {
                    if(map[ny][nx]==0 && !visited[ny][nx]){ // 물이면
                        bridgecount[ny][nx] = bridgecount[yy][xx]+1;
                        ver.add(new Pair(nx,ny));
                        visited[ny][nx]= true;
                    }else if(map[ny][nx] == 1 && bridgecount[yy][xx]>0 && !visited[ny][nx]){ // 섬이면
                        bridge = bridgecount[yy][xx]; //섬을 만나면 이전에 다리개수 저장
                        ver.clear();
                        return bridge;
                    }
                }
            }
        }
        return bridge;
    }
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
