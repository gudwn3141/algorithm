package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16985 {
    static int answer = 125;
//    static int[][][] map;
    static int[] dx = {0,1,0,-1,0,0} , dy = {0,0,0,0,-1,1}, dz = {1,0,-1,0,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][][] map = new int[5][5][5];
        for(int i = 0;i<5;i++){
            for(int j=0;j<5;j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0;k<5;k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int[] floor = {0,1,2,3,4};

        perm(floor,0,map);
        System.out.println((answer==125) ? -1 : answer);
    }
    static void perm(int[] floor, int index, int[][][] map){
        if(index == floor.length){
            int[][][] copymap = new int[5][5][5];
            for(int z=0;z<5;z++){
                copymap[z] = map[floor[z]];
            }
            confirm(copymap,0);
            return;
        }
        for(int i = index; i<floor.length;i++){
            swap(floor, i, index);
            perm(floor, index+1, map);
            swap(floor, i, index);
        }

    }
    static void swap(int[] floor, int i, int j){
        int temp = floor[i];
        floor[i] = floor[j];
        floor[j] = temp;
    }
    static void bfs(int[][][] copymap){

        Queue<Pair> q = new LinkedList<>();
        int[][][] count = new int[5][5][5];
        boolean[][][] visited = new boolean[5][5][5];
        if(copymap[0][0][0] == 1){
                q.add(new Pair(0,0,0));
                visited[0][0][0] = true;
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            int zz = p.z;
//            visited[zz][yy][xx] = true;
            for(int k=0;k<6;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                int nz = zz+dz[k];
                if(nx>=0 && nx<5 && ny>=0 && ny<5 && nz>=0 && nz<5){
                    if(!visited[nz][ny][nx] && copymap[nz][ny][nx]==1){
                        count[nz][ny][nx] = count[zz][yy][xx]+1;
                        visited[nz][ny][nx]=true;
                        q.add(new Pair(nx,ny,nz));
                        if(nz==4 && ny == 4 && nx==4){
                            q.clear();
                            break;
                        }
                    }
                }
            }
        }
        if(count[4][4][4] !=0){
            answer = (answer > count[4][4][4]) ? count[4][4][4] : answer;
        }
    }
    static int[][] rotate(int[][][] copymap, int z){
        int[][] turn = new int[5][5];
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                turn[j][4-i] = copymap[z][i][j];
            }
        }
        return turn;
    }
    static void confirm(int[][][] copymap , int z){
        if(z==5){
            bfs(copymap);
            return;
        }
        confirm(copymap,z+1);
        for(int i = 0;i<3;i++){
            copymap[z] = rotate(copymap,z);
            confirm(copymap,z+1);
        }
    }
    static class Pair{
        int x,y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
