package it.beije.ragazzi.esercizi;
// import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        System.out.println("Primo esercizio");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("Secondo esercizio");
        for (int i = 20; i >= 0; i--) {
            if (i % 2 == 0)
                System.out.println(i);
        }
        System.out.println("Terzo esercizio");
        multiplier(Integer.parseInt(args[0]));
        System.out.println("Quarto Esercizio");
        StringBuilder str = new StringBuilder("******");
        for (int i = str.length(); i > 0; i--) {
            System.out.println(str);
            str.deleteCharAt(str.length() - 1);
        }
        System.out.println("Quinto Esercizio");
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            str2.append("#");
            System.out.println(str2);
        }
        System.out.println("Sesto Esercizio");
        printNumbersImage();
        System.out.println("Settimo Esercizio");
        fibonacci();
        System.out.println("Ottavo Esercizio");
        fibonacci2();
    }

    public static void multiplier(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num * i);
        }
    }

    public static void printNumbersImage() {
        StringBuilder a = new StringBuilder("1");
        StringBuilder b = new StringBuilder("654321");
        for (int i = 2, j = 0; i < 8 && j < 6; i++, j++) {
            System.out.println(a + "      " + b);
            a.append(Integer.toString(i));
            b.deleteCharAt(0);
        }
    }

    public static void fibonacci() {
        long first = 0;
        long second = 1;
        for (int i = 0; i <= 10; i++) {
            System.out.println(first);
            long x = first;
            first = second;
            second += x;
        }
    }

    public static void fibonacci2() {
        StringBuilder sb = new StringBuilder();
        long first = 0;
        long second = 1;
        for (int i = 0; i <= 10; i++) {
            long x = first;
            first = second;
            second += x;
            System.out.println(sb.append(Long.toString(first)).append(", "));
        }
    }

}
