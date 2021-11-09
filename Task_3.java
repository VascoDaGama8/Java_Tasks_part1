import java.util.Scanner;
public class Task_3 {
    public static int bitschet(int ch){
        int bit [] = new int[32];
        int nom = 0;
        while (ch > 0){
            bit[nom] = ch % 2;
            nom += 1;
            ch /= 2;
        }
        int sum = 0;
        for(int num : bit) sum += num;
        return sum;
    }
    public static void main(String[] args){
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        int ch = scan.nextInt();
        System.out.println("Сумма битов в двоичной записи вашего числа:");
        System.out.println(bitschet(ch));

    }
}
