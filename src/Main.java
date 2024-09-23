import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Как тебя зовут?");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Привет, " + name + "!");
        }
    }