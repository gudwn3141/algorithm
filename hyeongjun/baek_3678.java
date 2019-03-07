package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_3678 {
    static int index, first, mid,div;
    static int[] numbercount, gamenumber;
    static boolean ver = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int[] value = new int[c];
        for(int i = 0;i<c;i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for(int i = 0;i<c;i++){
            max = (max>value[i]) ? max : value[i];
        }
        gamenumber = new int[10001];
        numbercount = new int[6]; //각 숫자가 쓰여진 누적 개수
//        if(max<=8){
        for(int i = 1;i<6;i++){
            gamenumber[i] = i;
            numbercount[i]++;
        }
        gamenumber[6] = 2;
        gamenumber[7] = 3;
        numbercount[2]++;
        numbercount[3]++;
        if(max>7){
            div = 6; // 인접한 칸과의 인덱스 차이
            index = 8; //대입할 인덱스
            first = 0; // 규칙을 위한 변수
            do{
                twopush(gamenumber[index-1],gamenumber[index-div]);
                for(int i = 0;i<first;i++){
                    threepush(gamenumber[index-1],gamenumber[index-div],gamenumber[index-div-1]);
                }
                first++;
                for(int i = 0;i<5;i++){
                    div++;
                    twopush(gamenumber[index-1] , gamenumber[index-div]);
                    for(int j = 0;j<first;j++){
                        threepush(gamenumber[index-1],gamenumber[index-div],gamenumber[index-div-1]);
                    }
                }

                threepush(gamenumber[index-1],gamenumber[index-div],gamenumber[index-div-1]);
                div++;
                if(ver){
                    break;
                }
            } while(index-1<max);
        }
//        for(int i = 0;i<index;i++){
//            System.out.print(gamenumber[i]+" ");
//        }
//        System.out.println();
        for(int i = 0;i<c;i++){
            System.out.println(gamenumber[value[i]]);
        }

    }
    static void twopush(int pre, int x){ //두 개가 인접할 때
        if(!ver){
            int min = 5000; // 초기값
            int val = 0;
            for(int i = 1;i<=5;i++){
                if(i != pre && i!=x){
                    if(min>numbercount[i]){
                        val = i;
                        min = numbercount[i];
                    }
                }
            }
            gamenumber[index] = val;
            numbercount[val]++;
            index++;
            if(index>10000){
                ver = true;
            }

        }
    }

    static void threepush(int pre, int x, int y){ //세개가 인접할 때
        if(!ver){
            int min = 5000; // 초기값
            int val = 0;
            for(int i = 1;i<=5;i++){
                if(i!=pre && i!=x && i!=y){
                    if(min>numbercount[i]){
                        val = i;
                        min = numbercount[i];
                    }
                }
            }
            gamenumber[index] = val;
            numbercount[val]++;
            index++;
            if(index>10000){
                ver = true;
            }

        }
    }
}