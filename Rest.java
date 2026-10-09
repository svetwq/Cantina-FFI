import java.util.Scanner;

public class Rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Suma de plată: ");
        int plata = sc.nextInt();
        System.out.print("Suma achitată: ");
        int achitat = sc.nextInt();

        int rest = achitat - plata;
        System.out.println("Rest: " + rest + " lei");

        int b500 = rest / 500; rest = rest % 500;
        int b200 = rest / 200; rest = rest % 200;
        int b100 = rest / 100; rest = rest % 100;
        int b50 = rest / 50;   rest = rest % 50;
        int b20 = rest / 20;   rest = rest % 20;
        int b10 = rest / 10;   rest = rest % 10;
        int b5 = rest / 5;     rest = rest % 5;
        int b1 = rest;

        System.out.println(b500 + " bancnote de 500");
        System.out.println(b200 + " de 200");
        System.out.println(b100 + " de 100");
        System.out.println(b50 + " de 50");
        System.out.println(b20 + " de 20");
        System.out.println(b10 + " de 10");
        System.out.println(b5 + " de 5");
        System.out.println(b1 + " de 1");
    }
}