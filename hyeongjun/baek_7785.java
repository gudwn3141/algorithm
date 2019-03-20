package hyeongjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baek_7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] name = new String[n];
        for(int i =0;i<n;i++){
            name[i] = br.readLine();
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String person = name[i].split(" ")[0];
            String state = name[i].split(" ")[1];
            if(state.equals("enter")){
                list.add(person);
            }else{
                int k=0;
                for(int j=0;j<list.size();j++){

                    if(person.equals(list.get(j))){
                        k=j;
                        break;
                    }
                }
                list.remove(k);
            }
        }
        Collections.sort(list);
        for(int i = list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
}
