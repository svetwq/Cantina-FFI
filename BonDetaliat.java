import java.util.Scanner;

public class BonDetaliat {
    public static void main(String[] args) {
        double prag = 100;
        double procent = 0.15;

        Meniu m = new Meniu();
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            m.afiseaza();
            System.out.print("Poziția (0 = finalizare): ");
            op = sc.nextInt();
            Produs p = m.getDupaPozitie(op);
            if (p != null) p.adauga();
            else if (op != 0) System.out.println("Poziție invalidă");
        }

        double total = 0;
        System.out.println("----- BON -----");
        int i = 1;
        while (i <= m.getNr()) {
            Produs p = m.getDupaPozitie(i);
            if (p.getComandate() > 0) {
                double sub = p.costPentru(p.getComandate());
                System.out.printf("%s × %d = %.2f%n", p.getDenumire(), p.getComandate(), sub);
                total += sub;
            }
            i++;
        }

        double reducere = 0;
        if (total > prag) reducere = total * procent;
        System.out.printf("Reducere %.2f%n", reducere);
        System.out.printf("Total %.2f lei%n", total - reducere);
    }
}