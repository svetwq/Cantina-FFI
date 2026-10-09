import java.util.Scanner;

public class Cantina {
    public static void main(String[] args) {
        Meniu m = new Meniu();
        m.afiseaza();

        Scanner sc = new Scanner(System.in);
        System.out.print("Poziția: ");
        int poz = sc.nextInt();
        System.out.print("Porții: ");
        int portii = sc.nextInt();

        Produs p = m.getDupaPozitie(poz);
        if (p == null) System.out.println("Poziție invalidă");
        else System.out.println("Cost total: " + p.costPentru(portii));
    }
}