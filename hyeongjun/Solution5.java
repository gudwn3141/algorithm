package hyeongjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5 {
    static int C, B, answer;
    static boolean check = false;
    static Queue<Pair> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>();
        C = sc.nextInt();
        B = sc.nextInt();
        answer = 0;
        if(C==B){
            System.out.println(answer);
        }else{
            q.add(new Pair(C,B,0));
            bfs();
        }
        System.out.println(answer);


    }
    static class Pair{
        int c,b,time;
        Pair(int c, int b, int time){
            this.c = c;
            this.b = b;
            this.time = time;
        }
    }
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.remove();
            int cc = p.c;
            int bb = p.b;
            int time = p.time;
            time++;
            cc= cc+time;
            for(int i = 0;i<3;i++){
                int b_moving = b_move(bb,i);
                int t = confirm(cc,b_moving);
                if(t==0){
                    answer = time;
                    q.clear();
                    break;
                }else if(t==-1){
                    q.add(new Pair(cc,b_moving,time));
                }
            }
        }
    }
    static int confirm(int c, int b) {
        if(c<0 || c>200000 || b<0 || b>200000) {
            return 1;
        }else if(c==b){
            return 0;
        }else{
            return -1;
        }
    }
    static int b_move(int b, int i){
        if(i==0) return b-1;
        else if(i==1) return b+1;
        else return 2*b;
    }
}
