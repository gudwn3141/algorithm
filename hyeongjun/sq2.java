package hyeongjun;

import java.util.*;

public class sq2 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<priorities.length;i++){
            set.add(priorities[i]);
        }
        boolean ver = false;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int a = 0;
        int k = 0;
        int answer = 0;
        while(!list.isEmpty()){
            int l = list.size()-1;
            for(int i = 0;i<priorities.length;i++){
                if(priorities[a]==list.get(l)){

                    k = a+1;
                    if(k>=priorities.length){
                        k=0;
                    }
                    answer++;
                    if(a == location){
                        ver = true;
                        break;
                    }
                }
                a++;
                if(a==priorities.length){
                    a=0;
                }
            }
            if(ver){
                System.out.println(answer);
                break;
            }
            list.remove(l);
            a = k;
        }
    }
}