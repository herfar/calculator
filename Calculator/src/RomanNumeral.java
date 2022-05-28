public class RomanNumeral {
    static int numbers[]  = {1, 4, 5, 9, 10, 50, 100};
    static String letters[]  = { "I", "IV", "V", "IX", "X", "L", "C"};

    public static int convertRomanToInt(String romanNumeral) {
        int value = 0, num = 0;
        for (int i = romanNumeral.length()-1; i >= 0; i--) {
            switch(romanNumeral.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
            }
            if (4 * num < value) value -= num;
            else value += num;
        }
        return value;
    }
    public static String convertIntegerToRoman(int number) {
        String romanValue = "";
        int N = number;
        while ( N > 0 ) {
            for (int i = 0; i < numbers.length; i++) {
                if ( N < numbers[i] ) {
                    N -= numbers[i-1];
                    romanValue += letters[i-1];
                    break;
                }
            }
        }
        return romanValue;
    }
}