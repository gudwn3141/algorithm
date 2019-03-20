package hyeongjun;

import java.util.ArrayList;
import java.util.Collections;

public class bemin7 {
    public static void main(String[] args){
        int totalTicket = 2000;
        String[] logs = {"woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:35:02"
        };
        if(totalTicket==0) {
            String[] answer = new String[0];
        }else{
            String[][] state = new String[logs.length][2];
            int[] time = new int[logs.length];
            for(int i = 0;i<logs.length;i++){
                int sec = 0;
                String a = logs[i].split(" ")[2];
                String temp = a.split(":")[0];
                if(temp.charAt(0)=='0'){
                    sec+=(temp.charAt(1)-'0')*60*60;
                }else{
                    sec+=Integer.parseInt(temp)*60*60;
                }
                temp = a.split(":")[1];
                if(temp.charAt(0)=='0'){
                    sec+=(temp.charAt(1)-'0')*60;
                }else{
                    sec+=Integer.parseInt(temp)*60;
                }
                temp = a.split(":")[2];
                if(temp.charAt(0)=='0'){
                    sec+=(temp.charAt(1)-'0');
                }else{
                    sec+=Integer.parseInt(temp);
                }
                time[i] = sec;
            }
            for(int i = 0;i<state.length;i++){
                for(int j=0;j<2;j++){
                    state[i][j] = logs[i].split(" ")[j];
                }
            }
            boolean visited = true;
            String name = "";
            int logtime = 0;
            ArrayList<String> answer = new ArrayList<>();
            boolean checkbreak = true;
            for(int i = 0;i<state.length;i++){
                if(answer.size()==totalTicket) {
                    checkbreak = false;
                    break;
                }
                if(time[i]<32400 || time[i]>=35940) {
                    checkbreak = false;
                    continue;
                }
                if(state[i][1].equals("request")){
                    if(visited){
                        visited = false;
                        name = state[i][0];
                        logtime =time[i];
//                        checkbreak = false;
                    }else{
                        if(time[i]-logtime>60){
                            answer.add(name);
                            name = state[i][0];
//                            checkbreak = true;
                        }
                    }
                }else{
                    visited = true;
                }
            }
            System.out.println(name);
            if(!answer.get(answer.size()-1).equals(name) && checkbreak){
                answer.add(name);
            }

            Collections.sort(answer);
            System.out.println(answer.size());
            String[] result = new String[answer.size()];
            for(int i = 0;i<answer.size();i++){
//                result[i] = answer.get(i);
                System.out.print(answer.get(i)+" ");
            }
        }




    }
}
