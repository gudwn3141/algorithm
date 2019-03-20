package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[][] table1 = new String[N][3];
        String[][] jointable = new String[N][5];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                table1[i][j] = st.nextToken();
                if(i==0){
                    jointable[i][j] = table1[i][j];
                }
            }
        }
        jointable[0][3] = "city";
        jointable[0][4] = "zip";
        N = Integer.parseInt(br.readLine());
        String[][] table2 = new String[N][3];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                table2[i][j] = st.nextToken();

            }
        }

        for(int i = 1;i<table1.length;i++){
            int index1 = 0;
            for(int j=1;j<table1.length;j++){
                if(i==Integer.parseInt(table1[j][0])){
                    index1 = j;
                    break;
                }
            }

            for(int j = 0;j<3;j++){
                jointable[i][j] = table1[index1][j];
            }
            int index2 = 0;
            boolean check = false;
            for(int j=1;j<table2.length;j++){
                if(i==Integer.parseInt(table2[j][0])){
                    index2 = j;
                    check = true;
                    break;
                }
            }
            if(!check){
                for(int j=3;j<5;j++){
                    jointable[i][j] = "NULL";
                }
            }else{
                for(int j =3;j<5;j++){
                    jointable[i][j] = table2[index2][j-2];
                }
            }
        }
        for(int i = 0;i<jointable.length;i++){
            for(int j = 0;j<jointable[i].length;j++){
                System.out.print(jointable[i][j]+" ");
            }
            System.out.println();
        }
    }
}
