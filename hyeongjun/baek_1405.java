package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_1405 {
    static Stack<Pair> robot;
    static int N;
    static double answer;
    static boolean[][] visited;
    static double[] pro;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[30][30];
        answer = 1;
        N = Integer.parseInt(st.nextToken());
        pro = new double[4];
        for(int i = 0;i<4;i++){
            pro[i] = (double) Integer.parseInt(st.nextToken())/100;
        }
        robot = new Stack<Pair>();
        robot.push(new Pair(15,15,1));
        visited[15][15] = true;
        dfs(1);
        System.out.println(answer);
    }
    static void dfs(int count){
        if(count<=N){
            int c = count;
            while(!robot.isEmpty()){
                Pair p = robot.pop();
                int xx = p.x;
                int yy = p.y;
//                System.out.println(xx+" "+yy);
                for(int k=0;k<4;k++){
                    int nx = xx+dx[k];
                    int ny = yy+dy[k];
                    if(!visited[ny][nx]){
                        if(count!=N) {
                            robot.push(new Pair(nx, ny, p.prob * pro[k]));
                            visited[ny][nx] = true;
                            dfs(c + 1);
                            visited[ny][nx] = false;
                        }
                    }else{
                        answer-= p.prob*pro[k];
//                        System.out.println(answer);
                    }
                }
            }

        }
    }
    static class Pair{
        int x,y;
        double prob;
        Pair(int x, int y, double prob){
            this.x = x;
            this.y = y;
            this.prob = prob;
        }
    }
}
