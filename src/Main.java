import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String dateString = sc.nextLine();
        Date correctDate = correctedDate(dateString);

        String newDate45 = dateOn45(correctDate);
        System.out.println("Дата после увеличения на 45 дней: " + newDate45);

        String dateNewYear = dateNewYear(correctDate);
        System.out.println("Дата после сдвига на начало года: " + dateNewYear);
    }

    public static Date correctedDate(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return inputFormat.parse(dateString);
    }

    public static String dateOn45(Date correctDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(correctDate);
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        Date newDate = calendar.getTime();

        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return outputFormat.format(newDate);
    }

    public static String dateNewYear(Date correctDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(correctDate);

        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date newDate = calendar.getTime();
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return outputFormat.format(newDate);
    }
}