package hyeongjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Queue<String> name = new LinkedList<>();
        Queue<String> count = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            char sss = s.charAt(i);
            if(i==s.length()-1){
                count.add(Character.toString(s.charAt(s.length()-1)));
            }else{
                if(sss>64){ // 알파벳
//                    if(sss>=65 && sss<=90){
                    if(s.charAt(i+1)>=97 && s.charAt(i+1)<=122){
                        String input = Character.toString(sss).concat(Character.toString(s.charAt(i+1)));
                        name.add(input);
                        i+=1;
                    }else{
                        name.add(Character.toString(sss));
                    }
//                    }
                }else{
                    if(sss==49){
                        if(s.charAt(i+1)==48){
                            String input = Character.toString(sss).concat(Character.toString(s.charAt(i+1)));
                            count.add(input);
                            i++;
                        }else{
                            count.add(Character.toString(sss));
                        }
                    }else{
                        count.add(Character.toString(sss));
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        if(count.size()!=name.size()){
            System.out.println("error");
        }else{
            int t = count.size();
            for(int i = 0;i<t;i++){
                sb.append(name.remove());
                String a = count.remove();
                if(Integer.parseInt(a)!=1){
                    sb.append(a);
                }
            }
        }
        System.out.println(sb);
    }
}
