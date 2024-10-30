import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
}