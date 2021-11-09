import java.util.Scanner;
public class Task_4 {
    public static int poiskp(String vr0[], String znak){
        int nom = -1 ;
        for (int i = 0; i<vr0.length; i++){
            if (vr0[i].indexOf(znak) != -1) {
                nom = i;
                break;
            }
        }
        return nom;
    }
    public static int poisksk(String vr0[]){
        int nom2 = poiskp(vr0, ")");
        int nom1 = 0;
        for (int i = 0; i<vr0.length; i++){
            if (vr0[i].indexOf("(") != -1 && i < nom2) {
                nom1 = i;
            }
        }
        return nom1;
    }
    public static String proizvedenie (String vr0[],int znak, String v){

        double ch1 = Double.parseDouble(vr0[znak-1]);
        double ch2 = Double.parseDouble(vr0[znak+1]);
        double zn = ch1 * ch2;
        String znach = Double.toString(zn);
        vr0[znak-1] = znach;
        String vr1 [] = new String[vr0.length-2];
        for (int i = 0; i < znak; i ++) vr1[i] = vr0[i];
        if (znak < vr0.length - 2) {
            for (int i = znak; i < vr0.length - 2; i++) vr1[i] = vr0[i + 2];
        }
        v = String.join(" ", vr1);
        return v;
    }

    public static String delenie (String vr0[],int znak, String v){

        double ch1 = Double.parseDouble(vr0[znak-1]);
        double ch2 = Double.parseDouble(vr0[znak+1]);
        double zn = ch1 / ch2;
        String znach = Double.toString(zn);
        vr0[znak-1] = znach;
        String vr1 [] = new String[vr0.length-2];
        for (int i = 0; i < znak; i ++) vr1[i] = vr0[i];
        if (znak < vr0.length - 3) {
            for (int i = znak; i < vr0.length - 2; i++) vr1[i] = vr0[i + 2];
        }
        v = String.join(" ", vr1);
        return v;
    }
    public static String summa (String vr0[],int znak, String v){

        double ch1 = Double.parseDouble(vr0[znak-1]);
        double ch2 = Double.parseDouble(vr0[znak+1]);
        double zn = ch1 + ch2;
        String znach = Double.toString(zn);
        vr0[znak-1] = znach;
        String vr1 [] = new String[vr0.length-2];
        for (int i = 0; i < znak; i ++) vr1[i] = vr0[i];
        if (znak < vr0.length - 2)
        for (int i = znak; i < vr0.length - 2; i++) vr1[i] = vr0[i + 2];
        v = String.join(" ", vr1);
        return v;
    }
    public static String raznost (String vr0[],int znak, String v){

        double ch1 = Double.parseDouble(vr0[znak-1]);
        double ch2 = Double.parseDouble(vr0[znak+1]);
        double zn = ch1 - ch2;
        String znach = Double.toString(zn);
        vr0[znak-1] = znach;
        String vr1 [] = new String[vr0.length-2];
        for (int i = 0; i < znak; i ++) vr1[i] = vr0[i];
        if (znak < vr0.length - 2)
        for (int i = znak; i < vr0.length - 2; i++) vr1[i] = vr0[i + 2];
        v = String.join(" ", vr1);
        return v;
    }



    public static String calc (String v){

        String vr0[] = v.split(" ");
        int znak;
        int sk1;
        int sk2;
        String vsk = "";
        String vsk1 = "";
        String vrsk [];

        while (poiskp(vr0, ")") != -1) {
            vsk = "";
            vsk1= "";
            sk1 = poisksk(vr0);
            sk2 = poiskp(vr0, ")");
            for (int i = sk1 + 1; i < sk2; i++) {
                vsk = vsk + vr0[i];
                if (i != sk2-1) vsk+=" ";
            }
            for (int i = sk1; i <= sk2; i++) {
                vsk1 = vsk1 + vr0[i];
                if (i != sk2) vsk1+=" ";
            }
            vrsk = vsk.split(" ");

            while (poiskp(vrsk, "*") != -1) {
                znak = poiskp(vrsk, "*");
                vsk = proizvedenie(vrsk, znak, vsk);
                vrsk = vsk.split(" ");
            }

            while (poiskp(vrsk, "/") != -1) {
                znak = poiskp(vrsk, "/");
                vsk = delenie(vrsk,znak, vsk);
                vrsk = vsk.split(" ");
            }
            while (poiskp(vrsk, "+") != -1) {
                znak = poiskp(vrsk, "+");
                vsk = summa(vrsk,znak, vsk);
                vrsk = vsk.split(" ");
            }
            while (poiskp(vrsk, "-") != -1) {
                znak = poiskp(vrsk, "-");
                vsk = raznost(vrsk,znak, vsk);
                vrsk = vsk.split(" ");
            }
            v = v.replace(vsk1, vsk);
            vr0 = v.split(" ");
        }

        while (poiskp(vr0, "*") != -1)
        {
            znak = poiskp(vr0, "*");
            v = proizvedenie(vr0, znak, v);
            vr0 = v.split(" ");
        }

        while (poiskp(vr0, "/") != -1)
        {
            znak = poiskp(vr0, "/");
            v = delenie(vr0, znak, v);
            vr0 = v.split(" ");
        }

        while (poiskp(vr0, "-") != -1)
        {
            znak = poiskp(vr0, "-");
            v = raznost(vr0, znak, v);
            vr0 = v.split(" ");
        }

        while (poiskp(vr0, "+") != -1)
        {
            znak = poiskp(vr0, "+");
            v = summa(vr0, znak, v);
            vr0 = v.split(" ");
        }

        return v;
    }

        public static void main(String[] args)
        {
        System.out.println("Введите выражение:");
        Scanner a = new Scanner (System.in);
        String v = a.nextLine();
        System.out.println("Ответ:");
        System.out.println(calc(v));
    }
}

