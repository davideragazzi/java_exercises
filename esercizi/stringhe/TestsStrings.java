public class TestsStrings {
    private String str;

    public TestsStrings() {
        // super();
        str = "uao";
    }

    public static void main(String[] args) {
        String[] words = { "Pollo", "cane", "gAtto", "MucCa" };
        vowels(args[0]);
        capitals(words);
        contaLettera('a', args[1]);
        contrario(args[2]);
        concatena(args[3], args[4], args[5]);
        TestsStrings t = new TestsStrings();
        t.setter("ciao");
        System.out.println(t.getter());
    }

    public void setter(String str) {
        System.out.println("Esercizio 6");
        this.str = this.str.concat(str);
    }

    public String getter() {
        System.out.println("Esercizio 7");
        return this.str;
    }

    public static void vowels(String str) {
        System.out.println("Esercizio 1");
        if (str.length() == 0)
            System.out.println("Inserire una stringa");
        else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                        || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
                        || str.charAt(i) == 'O'
                        || str.charAt(i) == 'U')
                    System.out.print(str.charAt(i) + " ");
            }
        }
        System.out.println("\t");
    }

    public static void capitals(String[] arrStrings) {
        System.out.println("Esercizio 2");
        for (String string : arrStrings) {
            if (Character.isUpperCase(string.charAt(0)))
                System.out.print(string + " ");
        }
        System.out.println("\t");
    }

    public static void contaLettera(char c, String str) {
        System.out.println("Esercizio 3");
        if (str.length() == 0)
            System.out.println("Inserire una stringa");
        else {
            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == c)
                    newSb.append(c);
            }
            System.out.println(newSb.length());
        }
    }

    public static void contrario(String str) {
        System.out.println("Esercizio 4");
        if (str.length() == 0)
            System.out.println("Inserire una stringa");
        else {
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        }
    }

    public static void concatena(String first, String second, String third) {
        System.out.println("Esercizio 5");
        if (first.length() == 0 || second.length() == 0 || third.length() == 0)
            System.out.println("Inserire tre parole");
        else {
            StringBuilder sb = new StringBuilder(first);
            sb.append("*").append(second).append("*").append(third);
            System.out.println(sb);
        }
    }
}
