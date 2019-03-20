package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class export_2382 {
    static int N,M,K;
    static int[][] countmap,directionmap;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        int x,y;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            directionmap = new int[N][N];
            countmap = new int[N][N];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                countmap[x][y] = Integer.parseInt(st.nextToken());
                directionmap[x][y] = Integer.parseInt(st.nextToken());
            }
            while(M--!=0){
                int[][] copymap = new int[N][N];
                int[][] copydirectionmap = new int[N][N];
                for(int i = 0;i<N;i++){
                    for(int j = 0;j<N;j++){
                        if(i==0) {
                            if(countmap[i+1][j]!=0 && directionmap[i+1][j]==1){
                                copymap[i][j] = countmap[i+1][j]/2;
                                copydirectionmap[i][j] = 2;
                                countmap[i+1][j]= 0;
                            }
                        }else if(i==N-1) {
                            if (countmap[i - 1][j] != 0 && directionmap[i - 1][j] == 2) {
                                copymap[i][j] = countmap[i - 1][j]/2;
                                copydirectionmap[i][j] = 1;
                                countmap[i - 1][j] = 0;
                            }
                        }else if(j==0){
                            if(countmap[i][j+1]!=0 && directionmap[i][j+1]==3){
                                copymap[i][j] = countmap[i][j+1]/2;
                                copydirectionmap[i][j] = 4;
                                countmap[i][j+1] = 0;
                            }
                        }else if(j==N-1){
                            if(countmap[i][j-1]!=0 && directionmap[i][j-1]==4){
                                copymap[i][j] = countmap[i][j-1]/2;
                                copydirectionmap[i][j] = 3;
                                countmap[i][j-1]= 0;
                            }
                        }else{
                            Queue<Pair> q = new LinkedList<>();
                            for(int k = 0;k<4;k++){
                                int nx = j+dx[k];
                                int ny = i+dy[k];
                                if(countmap[ny][nx]!=0 && directionmap[ny][nx]==k+1){
                                    q.add(new Pair(countmap[ny][nx],directionmap[ny][nx]));
                                    countmap[ny][nx] = 0;
                                }
                            }
                            int sum = 0;
                            int max = 0;
                            int direction = 0;
                            while(!q.isEmpty()){
                                Pair p = q.remove();
                                sum+=p.count;
                                if(max<p.count){
                                    max=p.count;
                                    direction = p.direction;
                                }
                            }
                            copymap[i][j] = sum;
                            copydirectionmap[i][j] = direction;
                        }
                    }
                }
                for(int n = 0;n<N;n++){
                    for(int l = 0;l<N;l++){
                        countmap[n][l] = copymap[n][l];
                        directionmap[n][l] = copydirectionmap[n][l];
                    }
                }
            }
            int answer = 0;
            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    if(countmap[i][j]!=0) answer+=countmap[i][j];
                }
            }
            System.out.println("#"+t+" "+answer);

        }
    }
    static class Pair{
        int count,direction;
        Pair(int count, int direction){
            this.count = count;
            this.direction = direction;
        }
    }
}
