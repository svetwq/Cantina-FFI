import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // calculeazaCost
        System.out.printf(Locale.US, "%.2f%n", Cantina.calculeazaCost(46.00, 2));        // 110.40
        System.out.printf(Locale.US, "%.2f%n", Cantina.calculeazaCost(46.00, 2, true));  // 93.84
        System.out.printf(Locale.US, "%.2f%n", Cantina.calculeazaCost(46, 2));           // 110.40

        // esteDeschis
        System.out.println(Cantina.esteDeschis(3, 8));    // true
        System.out.println(Cantina.esteDeschis(6, 12));   // true
        System.out.println(Cantina.esteDeschis(3, 16));   // false
        System.out.println(Cantina.esteDeschis(6, 13));   // false
        System.out.println(Cantina.esteDeschis(7, 10));   // false

        // pretProdus
        System.out.println(Cantina.pretProdus(9));        // 0.0

        // tabel costuri
        Cantina.afiseazaTabelCosturi(Cantina.pretProdus(1));

        // câmpuri statice: numărul de produse (înainte de orice new Produs suplimentar)
        System.out.println(Produs.getNumarProduse());     // 4

        // bonuri
        Cantina.comanda(1, 1);   // Bon nr. 1
        Cantina.comanda(2, 2);   // Bon nr. 2
        Cantina.comanda(3, 1);   // Bon nr. 3

        // C2: 1000 de apeluri genereazaNumar(1, 10)
        int min = 10, max = 1, sapte = 0;
        for (int i = 0; i < 1000; i++) {
            int n = Cantina.genereazaNumar(1, 10);
            if (n < min) min = n;
            if (n > max) max = n;
            if (n == 7) sapte++;
        }
        System.out.println("Min: " + min + ", Max: " + max + ", Apariții 7: " + sapte);

        // C3: transmiterea parametrilor
        double pret = 24.50;
        System.out.printf(Locale.US, "Înainte: %.2f%n", pret);
        Cantina.majoreazaPret(pret);
        System.out.printf(Locale.US, "După:   %.2f%n", pret);                 // 24.50

        Produs p = new Produs("Zeamă de casă", 24.50, 10);                    // după testul contorului
        System.out.printf(Locale.US, "Înainte: %.2f%n", p.getPret());
        Cantina.majoreazaPret(p);
        System.out.printf(Locale.US, "După:   %.2f%n", p.getPret());          // 26.95

        // meniul cu for (interactiv)
        Cantina.meniuCuFor(sc);
    }
}
