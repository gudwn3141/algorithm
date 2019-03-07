package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class baek_3197 {
    static class Pair7{
        int x,y;
        Pair7(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int R,C, val_x, val_y,answer,watermax;
    static boolean result = false;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Pair7> water, swal;
    static char[][] lake;
    static int[][] watertime;
    static boolean[][] watervisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        watertime = new int[R][C];
        watervisited = new boolean[R][C];
        lake = new char[R][C];
        water = new LinkedList<>();
        for(int i = 0 ;i<R;i++){
            String b = br.readLine();
            for(int j = 0;j<C;j++){
                lake[i][j] = b.charAt(j);
                if(lake[i][j]=='.'){
                    water.add(new Pair7(j,i));
                    watervisited[i][j] = true;
                }else if(lake[i][j] =='L'){
                    water.add(new Pair7(j,i));
                    val_x = j;
                    val_y = i;
                }
            }
        }
        swal = new LinkedList<>();
        swal.add(new Pair7(val_x,val_y));

        water();
//        System.out.println(watermax);
        boolean k = true;
        int maxmax = watermax;
        int minmin = 0;
        watermax = (maxmax+minmin)/2;
//        System.out.println(watermax);
        while(k){
//            System.out.println(watermax);
            ver();
            if(result){
//                System.out.println("before watermax : "+ watermax);
                watermax--;
//                System.out.println("after watermax : "+ watermax);

                ver();
                if(!result){
                    watermax++;
//                    answer = watermax;
//                    System.out.println("answer watermax : "+ watermax);

                    break;
                }else{
                    watermax++;
                    maxmax = watermax;
                    watermax = (maxmax+ minmin)/2;
                }
            }else{
//                System.out.println("before watermax : "+ watermax);
                watermax++;
//                System.out.println("after watermax : "+ watermax);

                ver();
                if(!result){
                    watermax--;
                    minmin = watermax;
                    watermax = (maxmax+minmin)/2;
                }else{
//                    answer = watermax;
//                    System.out.println("answer watermax : "+ watermax);

                    break;
                }
            }

        }
        System.out.println(watermax);
    }
    static void ver() {

        result = false;
        Queue<Pair7> q = new LinkedList<>(swal);
        boolean[][] swalvisited = new boolean[R][C];
        swalvisited[val_y][val_x] = true;
        verwhile:
        while(!q.isEmpty()){
            Pair7 p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(nx>=0 && nx<C && ny>=0 && ny<R){
                    if(!swalvisited[ny][nx] && watertime[ny][nx]<=watermax && lake[ny][nx]!='L'){
                        q.add(new Pair7(nx,ny));
                        swalvisited[ny][nx] = true;
                    }else if(lake[ny][nx]=='L' && !swalvisited[ny][nx]){
                        result = true;
                        break verwhile;
                    }
                }
            }
        }
//        if(result){
//            watermax--;
//            result = false;
//        }else{
//            answer = watermax;
//            result = true;
//        }
    }

    static void water(){
        while(!water.isEmpty()){
            Pair7 p = water.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0;k<4;k++){
                int nx = xx+dx[k];
                int ny = yy+dy[k];
                if(nx>=0 && nx<C && ny>=0 && ny<R){
                    if(!watervisited[ny][nx] && lake[ny][nx]=='X'){
                        water.add(new Pair7(nx,ny));
                        watervisited[ny][nx] = true;
                        watertime[ny][nx] = watertime[yy][xx]+1;
                        if(watermax<watertime[ny][nx]){
                            watermax = watertime[ny][nx];
                        }
                    }
                }
            }
        }
    }

//    static void findtime(int min, int max){
//        int limitwater = (min+max)/2;
//        if(ver(limitwater)){
//            System.out.println("before limit = " +limitwater);
//            limitwater-=1;
//            System.out.println("after limit = " +limitwater);
//
//            if(ver(limitwater)){
//                limitwater+=1;
//                findtime(min,limitwater);
//            }else{
//                System.out.println("ok");
//                answer = limitwater+1;
//            }
//        }else{
//            System.out.println("before limit = " +limitwater);
//
//            limitwater+=1;
//            System.out.println("after limit = " +limitwater);
//
//            if(ver(limitwater)){
//                answer = limitwater;
//            }else{
//                limitwater-=1;
//                findtime(limitwater,max);
//            }
//        }
//    }
}
