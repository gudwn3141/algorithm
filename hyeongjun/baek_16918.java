package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16918 {
    static int R,C,N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        count = new int[R][C];
        char[][] map = new char[R][C];
        N--; //1초 후
        //폭탄있는 곳 1초 ++
        for(int i = 0;i<R;i++){
            String s = br.readLine();
            for(int j = 0;j<C;j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'O'){
                    count[i][j]++;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        while(N>0){
            N--; //1초 경과
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    // '.' 이면 폭탄 설치
                    if(map[i][j] == '.'){
                        map[i][j] = 'O';
                    }else{
                        //'.'이 아니면 1초 경과
                        count[i][j]++;
                        if(count[i][j]==3){ //시간이 3초가 되면 터트리기위해 q에 저장
                            map[i][j] = '.';
                            count[i][j] = 0;
                            q.add(new Pair(j,i));
                        }
                    }
                }
            }
            //폭탄 터트리기
            bfs(q, map);
        }
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        br.close();
    }
    //폭발
    static void bfs(Queue<Pair> q, char[][] map){
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k=0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(nx>=0 && nx<C && ny>=0 && ny<R && map[ny][nx]=='O'){ // 주변이 'O'이면 '.'으로 바꿔주고 시간도 0으로
                    count[ny][nx] = 0;
                    map[ny][nx] = '.';
                }
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
