public class Meniu {
    private Produs p1 = new Produs("Zeamă de casă", 24.5, 10);
    private Produs p2 = new Produs("Piure cu pârjoală", 46.0, 10);
    private Produs p3 = new Produs("Salată de varză", 18.0, 10);
    private Produs p4 = new Produs("Compot", 12.0, 10);
    private int nr = 4;

    public int getNr() { return nr; }

    public Produs getDupaPozitie(int poz) {
        if (poz == 1) return p1;
        else if (poz == 2) return p2;
        else if (poz == 3) return p3;
        else if (poz == 4) return p4;
        return null;
    }

    public Produs getDupaNume(String nume) {
        int i = 1;
        while (i <= nr) {
            if (getDupaPozitie(i).getDenumire().equals(nume)) return getDupaPozitie(i);
            i++;
        }
        return null;
    }

    public void afiseaza() {
        System.out.println("Meniul zilei:");
        int i = 1;
        while (i <= nr) {
            Produs p = getDupaPozitie(i);
            System.out.printf("%d. %-20s %6.2f lei%n", i, p.getDenumire(), p.getPret());
            i++;
        }
    }
}