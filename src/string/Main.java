package string;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "OnePlusFiveMinusTwoPlusSeven";
        System.out.println(arithmaticOpsByString(s));
    }

    public static int arithmaticOpsByString(String s){
        Map<String,Integer> map = new HashMap<>();
        map.put("One",1);map.put("Two",2);map.put("Three",3);map.put("Four",4);map.put("Five",5);
        map.put("Six",6);map.put("Seven",7);map.put("Eight",8);map.put("Nine",9);map.put("Zero",0);

        String[] str = s.split("(?=[A-Z])");
        int res=map.get(str[0]);
        for(int i=1;i<str.length-1;i++){
            if(str[i].equals("Plus")){
                res+=map.get(str[i+1]);
            }
            if(str[i].equals("Minus")){
                res-=map.get(str[i+1]);
            }
        }
        return res;
    }
}
