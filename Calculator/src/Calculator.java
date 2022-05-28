import java.util.Scanner;

public class Calculator {

    static RomanNumeral Numeral = new RomanNumeral();

    public static void main(String[] arg) {
        Calc myCalc = new Calc();
        Integer result = 0;
        String res = "";

        do {
            Scanner calcScan = new Scanner(System.in);
            System.out.println("Введите пример. Например 2+2 или I+I");

            try {
                if (calcScan.findInLine("(-?\\d+\\.?\\d*)?\\s*(\\S)\\s*(-?\\d+\\.?\\d*)") != null) {
                    Integer nOne = Integer.parseInt(calcScan.match().group(1));
                    Integer nTwo = Integer.parseInt(calcScan.match().group(3));
                    result = myCalc.action(nOne, nTwo, calcScan.match().group(2));
                    if (nOne > 0 && nOne < 11 && nTwo > 0 && nTwo < 11)
                        System.out.println(result);
                    else throw new IntRangeException();

                } else if (calcScan.findInLine("(IX|X|IV|VI|V|I{0,3})\\s*(\\S)\\s*(IX|X|IV|VI|V|I{0,3})") != null) {
                    Integer nOne = RomanNumeral.convertRomanToInt(calcScan.match().group(1));
                    Integer nTwo = RomanNumeral.convertRomanToInt(calcScan.match().group(3));
                    result = myCalc.action(nOne, nTwo, calcScan.match().group(2));
                    res = RomanNumeral.convertIntegerToRoman(result);
                    if (nOne > 0 && nOne < 11 && nTwo > 0 && nTwo < 11)
                        System.out.println(res);
                    else throw new IllegalStateException();
                }
            } catch (IllegalStateException e) {
                System.out.println("Только положительные римские от I до X");
                break;
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль не допустимо");
                break;
            } catch (IntRangeException e) {
                System.out.println("Числа не должны превышать 10 и должны быть положительными");
                e.printStackTrace();
                break;
            }
        } while (true);
    }
}