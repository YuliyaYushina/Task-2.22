import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку");
        String mainString = sc.nextLine();
        System.out.println("Введите подстроку");
        String subString = sc.nextLine();
        int count = countSubString(mainString, subString);
        System.out.println("Подстрока '" + subString + "' встречается " + count + " раза");

        System.out.println("Введите строку");
        String replacementString = sc.nextLine();
        String correctedString = replaceString(replacementString);
        System.out.println(correctedString);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String dateString = sc.nextLine();
        String correctDate = correctedDate(dateString);
        System.out.println(correctDate);

        String simpleDate = correctedSimpleDate(dateString);
        System.out.println(simpleDate);
    }

    public static int countSubString(String mainString, String sudString) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(sudString, index)) != -1) {
            count++;
            index += sudString.length();
        }

        return count;
    }

    public static String replaceString(String replacementString) {
        String swapString1 = "кака";
        String swapString2 = "бяка";
        String censorshipString = "вырезано цензурой";
        replacementString = replacementString.replace(swapString1, censorshipString);
        replacementString = replacementString.replace(swapString2, censorshipString);
        return replacementString;
    }

    public static String correctedDate(String dateString) {
        String correctString = dateString.substring(6, 10) + "-" +
                             dateString.substring(3, 5) + "-" +
                             dateString.substring(0, 2);
        return correctString;
    }

    public static String correctedSimpleDate(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = inputFormat.parse(dateString);
        String outputDate = outputFormat.format(date);
        return outputDate;
    }
}