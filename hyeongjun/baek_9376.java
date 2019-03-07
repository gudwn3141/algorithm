package hyeongjun;


// 탈옥
// 미완성
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_9376 {
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T, h,w,answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static int[][] doorcount;
    static boolean[][] visited1,visited2;
    static Queue<Pair> prisonerq1, prisonerq2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T!=0){
            Queue<Pair> exit = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            visited1 = new boolean[h][w];
            visited2 = new boolean[h][w];
            doorcount = new int[h][w];
            prisonerq1 = new LinkedList<>();
            prisonerq2 = new LinkedList<>();
            map = new char[h][w];
            answer = h*w;
            int person = 0;
            for(int i=0;i<h;i++){
                String s = br.readLine();
                for(int j = 0;j<w;j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '$') {
                        if (person == 0) {
                            prisonerq1.add(new Pair(j,i));
                            visited1[i][j] = true;
                            person++;
                        } else {
                            prisonerq2.add(new Pair(j,i));
                            visited2[i][j] = true;
                        }
                    }
                }
            }
            prisoner1();
            for(int i = 0;i<h;i++){
                for(int j = 0;j<w;j++){
                    System.out.print(doorcount[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            prisoner2();
            for(int i = 0;i<h;i++){
                for(int j = 0;j<w;j++){
                    System.out.print(doorcount[i][j]+" ");
                }
                System.out.println();
            }
            for(int i = 0;i<w;i++){
                if(map[0][i]=='#'){
                    answer = (answer>doorcount[0][i]) ? doorcount[0][i] : answer;
                }
                if(map[h-1][i]=='#'){
                    answer = (answer>doorcount[h-1][i]) ? doorcount[h-1][i] : answer;

                }
            }
            for(int i = 1;i<h-1;i++){
                if(map[i][0]=='#'){
                    answer = (answer>doorcount[i][0]) ? doorcount[i][0] : answer;
                }
                if(map[i][w-1]=='#'){
                    answer = (answer>doorcount[i][w-1]) ? doorcount[i][w-1] : answer;

                }
            }
            System.out.println(answer);
//            for(int i = 0;i<h;i++){
//                for(int j = 0;j<w;j++){
//                    System.out.print(doorcount[i][j]+" ");
//                }
//                System.out.println();
//            }
            T--;
        }
    }
    static void prisoner1(){
        System.out.println("ok");
        while(!prisonerq1.isEmpty()){
            Pair p = prisonerq1.remove();
            int xx = p.x;
            int yy = p.y;

            for(int k = 0; k<4;k++) {
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if (nx >= 0 && nx < w && ny >= 0 & ny < h) {
                    if(!visited1[ny][nx] && map[ny][nx]!='*'){
//                        System.out.println("nx : "+nx+" ny : "+ny);
                        visited1[ny][nx] = true;
                        prisonerq1.add(new Pair(nx,ny));

                        if(map[ny][nx]=='#'){
                            doorcount[ny][nx] = doorcount[yy][xx]+1;
//                            map[ny][nx] = '.';
                        }else{
                            doorcount[ny][nx] = doorcount[yy][xx];
                        }
                    }
                }
            }
        }

    }
    static void prisoner2(){
        while(!prisonerq2.isEmpty()){
            Pair p = prisonerq2.remove();
            int xx = p.x;
            int yy = p.y;

            for(int k = 0; k<4;k++) {
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if (nx >= 0 && nx < w && ny >= 0 & ny < h) {
                    if(!visited2[ny][nx] && map[ny][nx]!='*'){
                        visited2[ny][nx] = true;
                        prisonerq2.add(new Pair(nx,ny));

                        if(map[ny][nx]=='#'){
                            doorcount[ny][nx] = doorcount[yy][xx]+1;
                            map[ny][nx] = '.';
                        }else{
                            doorcount[ny][nx] = doorcount[yy][xx];
                        }
                    }
                }
            }

        }

    }

}