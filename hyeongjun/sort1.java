package hyeongjun;

import java.util.ArrayList;
import java.util.Collections;
public class sort1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0;

        while(a<commands.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = commands[a][0]-1;i<commands[a][1];i++){
                list.add(array[i]);
            }
            System.out.println();
            Collections.sort(list);
            answer[a] = list.get(commands[a][2]-1);
            a++;
        }

        return answer;
    }
}