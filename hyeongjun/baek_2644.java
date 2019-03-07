package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class baek_2644 {
    static class relations{
        int x,y;
        relations(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] relation = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean result = false;
        int count = 0;
        Stack<relations> stack = new Stack<>();
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a-1][b-1] = relation[b-1][a-1] = 1;
        }
        stack.push(new relations(x,0));
        done:
        while(!stack.isEmpty()){
            relations r = stack.pop();
            int number = r.x;
            int cnt = r.y;
            for(int i = 0;i<n;i++){
                if(relation[number-1][i]==1){
                    if(i==y-1){
                        result = true;
                        count = cnt+1;
                        break done;
                    }else{
                        if(visited[number-1][i]==false){
                            stack.push(new relations(i+1,cnt+1));
                            visited[number-1][i] = true;
                        }
                    }
                }
            }
        }
        System.out.println((result)?count:-1);
    }
}