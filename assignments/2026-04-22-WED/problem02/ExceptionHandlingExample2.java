package day0422.problem02;

public class ExceptionHandlingExample2 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i < array.length; ++i) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("NumberFormatException 또는 NullPointerException 발생 : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
    }
}
