import java.util.Scanner;

public class Comanda {
    public static void main(String[] args) {
        Meniu m = new Meniu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Produs: ");
        String nume = sc.nextLine();
        System.out.print("Porții: ");
        int portii = sc.nextInt();

        Produs p = m.getDupaNume(nume);
        if (p == null) System.out.println("Produsul nu există în meniu");
        else if (p.esteDisponibil(portii)) System.out.println("Cost: " + p.costPentru(portii) + " lei");
        else System.out.println("Stoc insuficient");
    }
}