import java.util.ArrayList;
import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] numbers = { 44, 1, 2, 38, 5, 33, 14, 9, 3, 20 };
        int[] otherNumbers = { 1, 2, 3, 4, 6, 5, 7, 8, 9, 0 };
        int[] recurrents = { 1, 2, 2, 8, 6, 4, 6, 9, 2 };
        String[] strings = { "Carlo", "Gilberto" };
        maxAndMinWithIndexes(numbers);
        System.out.println("Contiene il numero scelto? " + contains(3, numbers));
        System.out.println("Array ordinato? " + isCrescente(otherNumbers));
        mostRecurrent(recurrents);
        mediaMultipliDiTre(numbers);
        stampaZigZag(otherNumbers);
        media(numbers);
        for (String string : addString(args[0], strings)) {
            System.out.print(string + " ");
        }
    }

    public static void maxAndMinWithIndexes(int[] numbers) {
        System.out.println("Esercizio 1");
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            copy.add(numbers[i]);
        }
        Arrays.sort(numbers);
        System.out.println("Min: " + numbers[0] + "; Max: " + numbers[numbers.length - 1]);
        System.out.println("Esercizio 2");
        System.out.println("Min Index: " + copy.indexOf(numbers[0]) + "; Max Index: "
                + copy.indexOf(numbers[numbers.length - 1]));
    }

    public static boolean contains(int e, int[] array) {
        System.out.println("Esercizio 3");
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            copy.add(array[i]);
        }
        if (copy.indexOf(e) < 0)
            return false;
        else
            return true;
    }

    public static boolean isCrescente(int[] array) {
        System.out.println("Esercizio 4");
        boolean isCrescente = true;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                if (array[i] > array[i + 1])
                    isCrescente = false;
            }
        }
        return isCrescente;
    }

    public static void mostRecurrent(int[] a) {
        System.out.println("Esercizio 5");
        int counter = 1, popular = a[0], temp = 0, tempCount;
        for (int i = 0; i < (a.length - 1); i++) {
            temp = a[i];
            tempCount = 0;
            for (int j = 1; j < a.length; j++) {
                if (temp == a[j])
                    tempCount++;
            }
            if (tempCount > counter) {
                popular = temp;
                counter = tempCount;
            }
        }
        System.out.println(popular);
    }

    public static void mediaMultipliDiTre(int[] array) {
        System.out.println("Esercizio 6");
        int somma = 0;
        double media = 0;
        ArrayList<Integer> multipliDiTre = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0 && array[i] >= 3)
                multipliDiTre.add(array[i]);
        }
        for (Integer integer : multipliDiTre) {
            if (multipliDiTre.size() == 0)
                System.out.println("Non ci sono multipli di tre");
            else
                somma += integer;
        }
        media = somma / multipliDiTre.size();
        System.out.println("Media " + media);
    }

    public static void stampaZigZag(int[] array) {
        System.out.println("Esercizio 7");
        for (int i = 0, j = 9; i < 5 && j > 4; i++, j--) {
            System.out.print(array[i] + " " + array[j] + " ");
        }
        System.out.println("\t");
    }

    public static void media(int[] array) {
        System.out.println("Esercizio 8");
        int somma = 0;
        float media = 0;
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            copy.add(array[i]);
        }
        for (Integer integer : copy) {
            somma += integer;
        }
        media = somma / array.length;
        System.out.println("Media " + media);
    }

    public static String[] addString(String s, String[] a) {
        System.out.println("Esercizio 9");
        ArrayList<String> arrList = new ArrayList<String>();
        for (String string : a) {
            arrList.add(string);
        }
        arrList.add(s);
        String[] arr = arrList.toArray(new String[a.length + 1]);
        return arr;
    }
}
