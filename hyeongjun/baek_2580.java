package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class baek_2580 {
    static class Pair2 {
        int x;
        int y;
        Pair2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int count = 0;
    static boolean ver = false;
    static int[][] sdocu = new int[9][9];
    static ArrayList<Pair2> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<9;j++){
                sdocu[i][j] = Integer.parseInt(st.nextToken());
                if (sdocu[i][j] == 0) {
                    list.add(new Pair2(j,i));
                }
            }
        }
        dfs();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                System.out.print(sdocu[i][j]+ " ");
            }
            System.out.println();
        }

    }
    static boolean dfs(){
        if(count==list.size()){
            return true;
        }
        Pair2 p = list.get(count);
        for (int i = 1; i <= 9; i++) {
            if (confirm(p.x, p.y, i)) {
                sdocu[p.y][p.x] = i;
                count++;
                if(dfs()){
                    return true;
                }
                sdocu[p.y][p.x] = 0;
                count--;
            }
        }
        return false;
    }
    static boolean confirm(int c, int r, int a){
        if(row(c,a) && colunm(r,a) && last(r,c,a)){
            return true;
        }
        return false;

    }
    static boolean row(int c, int a){
        for(int i = 0;i<9;i++){
            if(sdocu[i][c] == a){
                return false;
            }
        }
        return true;
    }
    static boolean colunm(int r, int a){

        for(int i=0;i<9;i++){
            if(sdocu[r][i] == a){
                return false;
            }
        }
        return true;
    }
    static boolean last(int r, int c, int a){
        for(int i = (r/3)*3;i<(r/3)*3+3;i++){
            for(int j=(c/3)*3;j<(c/3)*3+3;j++){
                if(sdocu[i][j]==a){
                    return false;
                }
            }
        }
        return true;
    }
}