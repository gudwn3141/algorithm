package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class export_1952 {
    static int answer = 30000,daycost,monthcost, threemonthcost;
    static int[] plan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++!=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            daycost = Integer.parseInt(st.nextToken());
            monthcost = Integer.parseInt(st.nextToken());
            threemonthcost = Integer.parseInt(st.nextToken());
            int yearcost = Integer.parseInt(st.nextToken());

            plan = new int[12];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<12;i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            int monthcount = 0;
            calcost(sum,monthcount);

            answer = (answer>yearcost) ? yearcost:answer;
            System.out.println("#"+t+" "+answer);

            //answer 초기값
            answer = 30000;
        }
    }

    static void calcost(int sum, int monthcount){
        if(monthcount>=12){
            answer = (answer>sum) ? sum : answer;
        }else{
            if(plan[monthcount]!=0){
                for(int i = 0; i<3;i++){
                    int previous = sum;
                    //비용 선택 후 sum에 더하기
                    sum = choiceplan(i,sum,monthcount);

                    if(i==2) monthcount+=3;
                    else monthcount++;

                    calcost(sum,monthcount);

                    if(i==2) monthcount-=3;
                    else monthcount--;

                    sum = previous;
                }
            }else{
                monthcount++;
                calcost(sum,monthcount);
                monthcount--;
            }
        }
    }

    static int choiceplan(int i, int sum, int monthcount){
        if(i==0) sum+=plan[monthcount]*daycost;
        else if(i==1) sum+=monthcost;
        else if(i==2) sum+=threemonthcost;
        return sum;
    }
}
