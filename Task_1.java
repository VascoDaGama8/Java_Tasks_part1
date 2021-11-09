import java.util.Scanner;
public class Task_1 {
    public static int Maxraz(String a1[], String a2[]){
        if (a1.length == 0 || a2.length == 0) return -1;
        int maxl = 0;
        for (int i = 0; i < a1.length; i++){
            for (int k=0; k<a2.length; k++){
                if (Math.abs(a1[i].length() - a2[k].length()) > maxl) {maxl = Math.abs(a1[i].length() - a2[k].length());}
            }
        }
        return maxl;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первую строку слов через пробел:");
        String a = scan.nextLine();
        String a1[] = a.split(" ");
        System.out.println("Введите вторую строку слов через пробел:");
        String b = scan.nextLine();
        String a2[] = b.split(" ");
        int otv = Maxraz(a1, a2);
        System.out.println("Мax(длина(х) - длина(у)):");
        System.out.println(otv);
    }
}
