import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitToCN {

    public static void main(String[] args) {
        DigitToCN money = new DigitToCN();
        System.out.println(money.digitMoneyToCn("00100221.10"));
//        String test = "ab.cd.ef.g";
//        String[] tarray = test.split("\\.");
//        for(String s:tarray){
//            System.out.println(s);
//        }
    }


    Double MAXIMUM_NUMBER = 99999999999.99;
    // Predefine the radix characters and currency symbols for output:
    String CN_ZERO = "零";
    String CN_ONE = "壹";
    String CN_TWO = "贰";
    String CN_THREE = "叁";
    String CN_FOUR = "肆";
    String CN_FIVE = "伍";
    String CN_SIX = "陆";
    String CN_SEVEN = "柒";
    String CN_EIGHT = "捌";
    String CN_NINE = "玖";
    String CN_TEN = "拾";
    String CN_HUNDRED = "佰";
    String CN_THOUSAND = "仟";
    String CN_TEN_THOUSAND = "万";
    String CN_HUNDRED_MILLION = "亿";
    String CN_SYMBOL = "人民币";
    String CN_DOLLAR = "元";
    String CN_TEN_CENT = "角";
    String CN_CENT = "分";
    String CN_INTEGER = "整";

    String integral;    // Represent integral part of digit number.
    String decimal;    // Represent decimal part of digit number.
    String outputCharacters;    // The output result.
    String parts;
    String[] digits, radices, bigRadices, decimals;
    int zeroCount;
    int i, p;
    String d;
    int quotient, modulus;


    public String digitMoneyToCn(String currencyDigits) {
        currencyDigits = this.verify(currencyDigits);
        // Separate integral and decimal parts before processing coversion:
        String[] parts = currencyDigits.split("\\.");
        if (parts.length > 1) {
            integral = parts[0];
            decimal = parts[1];
            // Cut down redundant decimal digits that are after the second.
            decimal = decimal.substring(0, 2);
        } else {
            integral = parts[0];
            decimal = "";
        }
        // Prepare the characters corresponding to the digits:
        digits = new String[]{CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE};
        radices = new String[]{"", CN_TEN, CN_HUNDRED, CN_THOUSAND};
        bigRadices = new String[]{"", CN_TEN_THOUSAND, CN_HUNDRED_MILLION};
        decimals = new String[]{CN_TEN_CENT, CN_CENT};

        // Start processing:
        outputCharacters = "";
        // Process integral part if it is larger than 0:
        if (Integer.valueOf(integral) > 0) {
            zeroCount = 0;
            for (int i = 0; i < integral.length(); i++) {
                p = integral.length() - i - 1;
                d = integral.substring(i, i + 1);
                quotient = p / 4;
                modulus = p % 4;
                if (d.equals("0")) {
                    zeroCount++;
                } else {
                    if (zeroCount > 0) {
                        outputCharacters += digits[0];
                    }
                    zeroCount = 0;
                    outputCharacters += digits[Integer.valueOf(d)] + radices[modulus];
                }
                if (modulus == 0 && zeroCount < 4) {
                    outputCharacters += bigRadices[quotient];
                    zeroCount = 0;
                }
            }
            outputCharacters += CN_DOLLAR;
        }
        // Process decimal part if there is:
        if (decimal != "") {
            for (i = 0; i < decimal.length(); i++) {
                d = decimal.substring(i, 1);
                if (d != "0") {
//                    d.equals("")?d
                    outputCharacters += digits[Integer.valueOf(d.equals("") ? "0" : d)] + decimals[i];
                }
            }
        }
        // Confirm and return the final output string:
        if (outputCharacters == "") {
            outputCharacters = CN_ZERO + CN_DOLLAR;
        }
        if (decimal == "") {
            outputCharacters += CN_INTEGER;
        }
        outputCharacters = CN_SYMBOL + outputCharacters;
        return outputCharacters;
    }

    public String verify(String currencyDigits) {
        currencyDigits = currencyDigits.toString();
        if (currencyDigits == "") {
            System.out.println("请输入小写金额！");
            return "";
        }
        String regEx = "/\\[^,\\.\\d]/";//  /[^,.\d]/
        // /^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/)
        // /^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/
        String regEx2 = "/^((\\d{1,3}(,\\d{3})*(.((\\d{3},)*\\d{1,3}))?)|(\\d+(.\\d+)?))$/";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(currencyDigits);
        boolean isfind = matcher.find();
        if (isfind) {
            System.out.println("小写金额含有无效字符！");
            return "";
        }
        Pattern pattern1 = Pattern.compile(regEx2);
        Matcher matcher1 = pattern1.matcher(currencyDigits);
        boolean isHas = matcher1.find();
        if (isHas) {
            System.out.println("小写金额的格式不正确！");
            return "";
        }

// Normalize the format of input digits:
        currencyDigits = currencyDigits.replace(",", "");    // Remove comma delimiters.

        currencyDigits = currencyDigits.replace("/^0+/", "");    // Trim zeros at the beginning.
        // Assert the number is not greater than the maximum number.
        if (Double.valueOf(currencyDigits) > MAXIMUM_NUMBER) {
            System.out.println("金额过大，应小于1000亿元！");
            return "";
        }
    return currencyDigits;
    }

}
