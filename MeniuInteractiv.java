import java.util.Scanner;

public class MeniuInteractiv {
    public static void main(String[] args) {
        double prag = 100;
        double procent = 0.15;

        Meniu m = new Meniu();
        Scanner sc = new Scanner(System.in);
        double total = 0;
        int op = -1;

        while (op != 0) {
            m.afiseaza();
            System.out.print("Poziția (0 = finalizare): ");
            op = sc.nextInt();
            Produs p = m.getDupaPozitie(op);
            if (p != null) total += p.getPret();
            else if (op != 0) System.out.println("Poziție invalidă");
        }

        double reducere = 0;
        if (total > prag) reducere = total * procent;

        System.out.printf("Total acumulat: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("De plată: %.2f lei%n", total - reducere);
    }
}