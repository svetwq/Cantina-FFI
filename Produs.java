public class Produs {
    private static int numarProduse = 0;

    private String denumire;
    private double pret;
    private int stoc;
    private int comandate;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        numarProduse++;
    }

    public static int getNumarProduse() {
        return numarProduse;
    }

    public String getDenumire() { return denumire; }
    public double getPret() { return pret; }
    public int getStoc() { return stoc; }
    public int getComandate() { return comandate; }

    public void setPret(double pret) {
        if (pret > 0) this.pret = pret;
    }

    public void adauga() { comandate++; }

    public double costPentru(int portii) { return pret * portii; }

    public boolean esteDisponibil(int portii) { return stoc >= portii; }

    public String codScurt() {
        return denumire.substring(0, 2).toUpperCase() + (int) pret;
    }
}

