import java.util.Scanner;
public class Task_2 {
    public static String winword (String v){
        String alf = "0abcdefghijklmnopqrstuvwxyz";
        String words [] = v.split(" ");
        int sum = 0;
        int maxsum = 0;
        String word = new String();
        for (int i = 0; i < words.length; i++ ){
            for (int k = 0; k < words[i].length(); k++) {
                sum += alf.indexOf(Character.toString(words[i].charAt(k)));
            }
            if (sum > maxsum){
                maxsum = sum;
                sum = 0;
                word = words[i];
            }
        }
        return word;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        System.out.println("Введите строку слов через пробел:");
        String v = scan.nextLine();
        System.out.println("Слово вашей строки с наибольшим количеством баллов:");
        System.out.println(winword(v));
    }
}
