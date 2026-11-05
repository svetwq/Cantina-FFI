import java.util.Locale;
import java.util.Scanner;

public class Cantina {
    private static final Meniu m = new Meniu();
    static final double TVA = 0.20;
    private static int numarBonuri = 0;

    public static void afiseazaMeniu() {
        m.afiseaza();
    }

    public static double pretProdus(int optiune) {
        Produs p = m.getDupaPozitie(optiune);
        return (p == null) ? 0 : p.getPret();
    }

    public static double aplicaReducere(double total) {
        return (total > 100) ? total * 0.85 : total;
    }

    public static double costTotal(int optiune, int portii) {
        return pretProdus(optiune) * portii;
    }

    public static void afiseazaTabelCosturi(double pret) {
        for (int portii = 1; portii <= 5; portii++) {
            System.out.printf(Locale.US, "%d porții: %.2f lei%n", portii, pret * portii);
        }
    }

    public static boolean esteDeschis(int ziua, int ora) {
        return (ziua >= 1 && ziua <= 5 && ora >= 8 && ora < 16)
                || (ziua == 6 && ora >= 9 && ora < 13);
    }

    public static double calculeazaCost(double pret, int portii) {
        return pret * portii * (1 + TVA);
    }

    public static double calculeazaCost(double pret, int portii, boolean bursier) {
        double baza = pret * portii;
        if (bursier) baza = baza * 0.85;
        return baza * (1 + TVA);
    }

    public static double calculeazaCost(Produs p, int portii) {
        return calculeazaCost(p.getPret(), portii);
    }

    public static void meniuCuFor(Scanner sc) {
        double total = 0;
        for (int i = 0; i < 5; i++) {
            afiseazaMeniu();
            System.out.print("Poziția (0 = finalizare): ");
            int op = sc.nextInt();

            if (op == 0) break;

            if (pretProdus(op) == 0) {
                System.out.println("Opțiune inexistentă");
                continue;
            }
            total += pretProdus(op);
        }
        System.out.printf(Locale.US, "Total: %.2f lei%n", total);
    }

    // bonuri
    public static void afiseazaBon() {
        numarBonuri++;
        System.out.println("Bon nr. " + numarBonuri);
    }

    public static void comanda(int optiune, int portii) {
        if (pretProdus(optiune) == 0) {
            System.out.println("Poziție invalidă");
            return;
        }
        System.out.printf(Locale.US, "Cost: %.2f lei%n",
                calculeazaCost(pretProdus(optiune), portii));
        afiseazaBon();
    }

    // C2 - Ziua norocoasă
    public static int genereazaNumar(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static double finalizeazaComanda(double total) {
        int numar = genereazaNumar(1, 10);
        if (numar == 7) {
            System.out.println("Ziua norocoasă! Compotul este gratuit.");
            total = Math.max(0, total - 12.00);
        }
        return Math.round(total * 100) / 100.0;
    }

    // C3 - Transmiterea parametrilor
    public static void majoreazaPret(double pret) {
        pret = pret * 1.10;                 // modifică doar copia locală
    }

    public static void majoreazaPret(Produs p) {
        p.setPret(p.getPret() * 1.10);      // modifică obiectul indicat
    }
}
