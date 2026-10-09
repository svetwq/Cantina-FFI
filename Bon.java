import java.util.Scanner;

public class Bon {
    public static void main(String[] args) {
        double tva = 0.20;
        double reducereBursier = 0.15;

        Meniu m = new Meniu();
        m.afiseaza();
        Scanner sc = new Scanner(System.in);
        System.out.print("Poziția: ");
        int poz = sc.nextInt();
        System.out.print("Porții: ");
        int portii = sc.nextInt();
        System.out.print("Student bursier (1/0): ");
        int bursier = sc.nextInt();

        Produs p = m.getDupaPozitie(poz);
        if (p == null) {
            System.out.println("Poziție invalidă");
        } else {
            double subtotal = p.costPentru(portii);
            double reducere = 0;
            if (bursier == 1) reducere = subtotal * reducereBursier;
            double valoareTva = (subtotal - reducere) * tva;
            double total = subtotal - reducere + valoareTva;

            System.out.printf("Subtotal: %.2f%n", subtotal);
            System.out.printf("Reducere: %.2f%n", reducere);
            System.out.printf("TVA: %.2f%n", valoareTva);
            System.out.printf("Total: %.2f lei%n", total);
        }
    }
}