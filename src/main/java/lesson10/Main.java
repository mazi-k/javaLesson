package lesson10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //searchForUniqueWords();
        PhoneDirectory contact1 = new PhoneDirectory("81001", "Andy");
        PhoneDirectory contact2 = new PhoneDirectory("57865", "Andy");
        PhoneDirectory contact3 = new PhoneDirectory("88335", "Kerny");
        contact1.add();
        contact2.add();
        contact3.add();
        PhoneDirectory.print();
        PhoneDirectory.get("Andy");

        System.out.println();

        PhoneDirectory2 cont1 = new PhoneDirectory2();
        PhoneDirectory2 cont2 = new PhoneDirectory2();
        PhoneDirectory2 cont3 = new PhoneDirectory2();
        cont1.add("Fler", "1212");
        cont2.add("Grey", "3421");
        cont3.add("Fler", "1717");
        PhoneDirectory2.print();
        PhoneDirectory2.get("Fler");



    }

    public static void searchForUniqueWords(){
        String[] array = new String[] {"There","were","forty","mice","and","six","found","pennies",
                "and","the","smaller","mice","found","two","pennies","each"};
        Set <String> set = new LinkedHashSet<>();

        for (String arr:array) {
            set.add(arr);
        }

        System.out.println(set);

        Iterator<String> i = set.iterator();
            while (i.hasNext()){
                String word = i.next();
                System.out.println(word + ": " + numberOfRepetition(word, array));
            }
    }

    public static int numberOfRepetition(String word, String[] array){
        int number = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(word))
                number++;
        }
        return number;
    }


}
