package hyeongjun;

//미완성
//미완성
//미완성


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class baek_13460 {
    static class Pair5{
        int x,y,z;
        Pair5(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int val_x, val_y; // 구멍 좌표
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Pair5> red = new LinkedList<>(); // 빨간공
    static Queue<Pair5> blue = new LinkedList<>(); // 파란공

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        boolean redver = false;
        int redtime = 0;
        int bluetime = 0;
        visited = new boolean[N][N];
        for(int i = 0;i<N;i++){
            String b = br.readLine();
            System.out.println(b);
            for(int j=0;j<M;j++){
                board[i][j] = b.charAt(j);
//                System.out.println(board[i][j]);
                if(board[i][j]=='R'){
                    red.add(new Pair5(j,i,0));
                    visited[i][j]=true;
                }else if(board[i][j]=='B'){
                    blue.add(new Pair5(j,i,0));
                }
            }
        }
        br.close();
        redrun:
        while(!red.isEmpty()){
            System.out.println("on");
            Pair5 p = red.remove();

            int xx = p.x;
            int yy = p.y;
            System.out.println("xx = "+xx+" yy = "+yy);
            int zz = p.z;
            for(int k = 0;k<4;k++){
                int nx = xx + dx[k];
                int ny = yy + dy[k];

                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    if(!visited[ny][nx]&&board[ny][nx]=='.'){
                        System.out.println("confirm - xx = "+nx+" yy = "+ny);
                        visited[ny][nx] = true;
                        do{
                            nx+=dx[k];
                            ny+=dy[k];
                            if(nx>=0 && nx<M && ny>=0 && ny<N) {
                                if(!visited[ny][nx] && board[ny][nx]=='.'){
                                    visited[ny][nx]=true;
                                }else if(board[ny][nx]=='O') {
                                    redtime = zz + 1;
                                    redver = true;
                                    break redrun;
                                }
                            }else{
                                break;
                            }
                        } while(board[ny+dy[k]][nx+dx[k]]=='.');
                        System.out.println("nx = "+(nx-dx[k])+" ny = "+(ny-dy[k]));
                        red.add(new Pair5(nx-dx[k],ny-dy[k],zz+1));
                    }else if(board[ny][nx]=='O'){
                        redtime = zz+1;
                        redver = true;
                        break redrun;
                    }
                }
            }
        }
        System.out.println((redver) ? redtime:-1);
    }
}