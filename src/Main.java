import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 3 числа");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String res = null;

        if (a % 5 == 0) {
            res = "a=" + a;
        }
        if (b % 5 == 0) {
            if (res == null) {
                res = "b=" + b;
            } else {
                res = res.join(", ", res, "b=" + b);
            }
        }
        if (c % 5 == 0) {
            if (res == null) {
                res = "c=" + c;
            } else {
                res = res.join(", ", res, "c=" + c);
            }
        }

        if ((a%5 != 0) && (b%5 != 0) && (c%5 != 0)){
            res = "нет значений, кратных 5";
        }

        System.out.println(res);

        int quotient = a/b;
        System.out.println("Результат целочисленного деления a на b: " + quotient);

        double quo = (double)a / b;
        System.out.println("Результат деления a на b: " + quo);

        double cell = Math.ceil((double)a/b);
        System.out.println("Результат деления a на b с округлением в большую сторону: " + (int)cell);

        double floor = Math.floor((double)a/b);
        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + (int)floor);

        int floorDiv = Math.floorDiv(a, b);
        System.out.println("Результат деления a на b с математическим округлением: " + floorDiv);

        int remainder = b%c;
        System.out.println("Остаток от деления b на c: " + remainder);

        int min = Math.min(a, b);
        System.out.println("Наименьшее значение из a и b: " + min);

        int max = Math.max(b, c);
        System.out.println("Наибольшее значение из b и c: " + max);
    }
}