package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1063 {
    static String king,stone,direction;
    static int N;
    static boolean t = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken();
        stone = st.nextToken();
        N = Integer.parseInt(st.nextToken());
        for(int i = 0;i<N;i++){
            direction = br.readLine();
            move(direction);
        }
        System.out.println(king+ " "+stone);
    }
    static char rowconfirm(String direction, char row){
        if(direction.equals("R")) row = (char) (row + 1);
        else if(direction.equals("L")) row = (char)(row-1);
        else if(direction.equals("RT")) row = (char) (row + 1);
        else if(direction.equals("LT")) row = (char) (row - 1);
        else if(direction.equals("RB")) row = (char) (row + 1);
        else if(direction.equals("LB")) row = (char) (row - 1);
        return row;
    }
    static int colconfirm(String direction, int col){
        if(direction.equals("B")) col-=1;
        else if(direction.equals("T")) col+=1;
        else if(direction.equals("RT")) col+=1;
        else if(direction.equals("LT")) col += 1;
        else if(direction.equals("RB")) col -= 1;
        else if(direction.equals("LB"))  col -= 1;
        return col;
    }
    static void move(String direction){
        char kingrow, stonerow;
        int kingcol, stonecol;
        kingrow = king.charAt(0);
        kingcol = king.charAt(1)-'0';
        stonecol = stone.charAt(1)-'0';
        stonerow = stone.charAt(0);
        kingrow = rowconfirm(direction,kingrow);
        kingcol = colconfirm(direction, kingcol);
        if(kingcol == stonecol && kingrow == stonerow){
            stonerow = rowconfirm(direction,stonerow);
            stonecol = colconfirm(direction,stonecol);
        }

        if(kingcol >= 1 && kingcol<=8 && kingrow>='A' && kingrow<='H' && stonecol>=1 && stonecol <=8 && stonerow >= 'A' && stonerow<='H'){
            king  = String.valueOf(kingrow).concat(String.valueOf(kingcol));
            stone = String.valueOf(stonerow).concat(String.valueOf(stonecol));
        }

    }
}
