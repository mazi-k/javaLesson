package lesson3;

import java.util.Scanner;

public class MainLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        while(!gameOver){
            System.out.println("Hi! Try to guess the word!");
            game();
            System.out.println("Do you want to play again? ('yes' or 'no') ");
            String userEnd = scanner.next();
            if(userEnd.equals("no"))
                gameOver = true;
            else if (userEnd.equals("yes"))
                continue;
            else{
                System.out.println("something is wrong:( exit...");
                gameOver = true;
            }
        }
    }

    public static void game(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String disguise = "###############";
        char[] disguiseToCharArr = disguise.toCharArray();
        Scanner scanner = new Scanner(System.in);
        String rightAnswer = words[(int)(Math.random()*words.length)];
        boolean userVictory = false;
        System.out.println(rightAnswer);
        do{
            String userAnswer = scanner.next();
            if(userAnswer.equals(rightAnswer)){
                System.out.println("Congratulations! This is the right answer!");
                userVictory = true;
            } else {
                for(int i = 0; i < Math.min(userAnswer.length(), rightAnswer.length()); i++) {
                    if (userAnswer.charAt(i) == rightAnswer.charAt(i)) {
                        disguiseToCharArr[i] = userAnswer.charAt(i);
                        disguise = String.valueOf(disguiseToCharArr);
                    }
                }
                System.out.println("The word has no yet been guessed... " + disguise);
            }
        } while(!userVictory);
    }
}
