package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class export_2112 {
    static int D,W,K,min;
    static int[][] film;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            for(int i =0;i<D;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<W;j++){
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = D;
            int row = 0;
            int count = 0;

            if(!confirm()) dfs(row,count);
            else min=0;

            System.out.println("#"+t+" "+min);
        }
    }
    static void dfs(int row, int count){
        if (confirm()) min = (min>count) ? count:min;
        if(row==D) return;

        dfs(row+1,count);

        int[] rowcopy = copy(film[row]);
        for(int i = 0;i<W;i++) film[row][i] = 0;
        dfs(row+1,count+1);

        for(int i = 0;i<W;i++) film[row][i] = 1;
        dfs(row+1,count+1);

        film[row] = copy(rowcopy);

    }
    static boolean confirm(){
        for(int i = 0;i<W;i++){
            int count = 0;
            int state = film[0][i];
            for(int j = 0;j<D;j++){
                if(state==film[j][i]){
                    count++;
                    if(count==K) break;
                }else{
                    state = film[j][i];
                    count = 1;
                }
            }
            if(count<K) return false;
        }
        return true;
    }


    static int[] copy(int arr[]){
        int[] copyarr = new int[W];
        for(int j=0;j<W;j++){
            copyarr[j] = arr[j];
        }
        return copyarr;
    }

}
