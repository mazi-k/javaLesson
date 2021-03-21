package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory2 {
    private ArrayList<String> number = new ArrayList<>();
    private String name;

    private static HashMap<String, ArrayList> pd = new HashMap();

    public PhoneDirectory2() {
    }

    public void add(String name, String number) {
        if(pd.containsKey(name)){
            pd.get(name).add(number);

        } else {
            this.number.add(number);
            pd.put(name, this.number);
        }
    }

    public static void get(String name){
        for(Map.Entry<String, ArrayList> o: pd.entrySet()){
            if(o.getKey().equals(name))
                System.out.println(o.getKey() + ": " + o.getValue());
        }
    }

    public static void print(){
        System.out.println(pd);
    }
}
