package questao8;

public class StringAnalyzer {
    public static boolean verificarFinalString(String s1, String s2) {
        if (s1.length() < 2 || s2.length() < 2) {
            System.out.println("As Strings tem comprimento menor que 2, não é possível fazer a analise");
            return false;
        }
        String end = s1.substring(s1.length()-2);
        System.out.println(end);
        String begin = s2.substring(0,2);
        System.out.println(begin);
        if (end.equalsIgnoreCase(begin)) {
            return true;
        }
        return false;
    }
}
