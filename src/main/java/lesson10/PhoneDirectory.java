package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {
    private String numbers;
    private String name;

    private static HashMap<String, String> pd = new HashMap();

    public PhoneDirectory(String number, String name) {
        this.name = name;
        //numbers.add(number);
        numbers = number;
    }

    public void add() {
        pd.put(numbers, name);
    }


    public static void get(String name){
        for(Map.Entry<String, String> o: pd.entrySet()){
            if(o.getValue().equals(name))
                System.out.println(o.getValue() + ": " + o.getKey());
        }
    }

    public static void print(){
        System.out.println(pd);
    }

}
