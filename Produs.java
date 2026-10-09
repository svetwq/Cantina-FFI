public class Produs {
    private String denumire;
    private double pret;
    private int stoc;
    private int comandate;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getDenumire() { return denumire; }
    public double getPret() { return pret; }
    public int getStoc() { return stoc; }
    public int getComandate() { return comandate; }

    public void adauga() { comandate++; }

    public double costPentru(int portii) { return pret * portii; }
    public boolean esteDisponibil(int portii) { return stoc >= portii; }

    public String codScurt() {
        return denumire.substring(0, 3).toUpperCase() + (int) pret;
    }

    @Override
    public String toString() {
        return denumire + ", preț: " + pret + " lei, stoc: " + stoc;
    }
}

