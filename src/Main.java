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

        String newDate10 = increaseDat10(correctDate);
        System.out.println("Дата после увеличения на 10 рабочих дней: " + newDate10);

        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String secondDate = sc.nextLine();
        Date correctSecondDate = correctedSecondDate(secondDate);

        int workdaysCount = countingDays(correctDate, correctSecondDate);
        System.out.println("Количество рабочих дней между введенными датами: " + workdaysCount);
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

    public static String increaseDat10(Date correctDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(correctDate);

        int addedDays = 0;

        while (addedDays < 10) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                addedDays++;
            }
        }

        Date newDate = calendar.getTime();
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return outputFormat.format(newDate);
    }

    public static Date correctedSecondDate(String secondDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        return inputFormat.parse(secondDate);
    }

    public static int countingDays(Date correctDate, Date correctSecondDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(correctDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(correctSecondDate);

        if (startCalendar.after(endCalendar)) {
            Calendar temp = startCalendar;
            startCalendar = endCalendar;
            endCalendar = temp;
        }

        int workdaysCount = 0;

        endCalendar.add(Calendar.DAY_OF_MONTH, -1);

        while (!startCalendar.after(endCalendar)) {
            if (startCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    startCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workdaysCount++;
            }
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return workdaysCount;
    }
}