package day0422.problem01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) throws NullPointerException {
        int result = data.length();
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");

        try {
            printLength("ThisIsJava");
            printLength(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생 : " + e.getMessage());
        }
        System.out.println("\n[프로그램 종료]");
    }
}
