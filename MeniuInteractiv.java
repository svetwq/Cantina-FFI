import java.util.Locale;
import java.util.Scanner;

public class MeniuInteractiv {
    public static void main(String[] args) {
        final double PRAG = 100;
        final double PROCENT = 0.15;

        Meniu m = new Meniu();
        Scanner sc = new Scanner(System.in);
        double total = 0;
        int op;

        do {
            m.afiseaza();
            System.out.print("Poziția (0 = finalizare): ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                case 2:
                case 3:
                case 4:
                    total += m.getDupaPozitie(op).getPret();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opțiune inexistentă");
            }
        } while (op != 0);

        double reducere = (total > PRAG) ? total * PROCENT : 0;

        System.out.printf(Locale.US, "Total acumulat: %.2f lei%n", total);
        System.out.printf(Locale.US, "Reducere: %.2f lei%n", reducere);
        System.out.printf(Locale.US, "De plată: %.2f lei%n", total - reducere);
    }
}
