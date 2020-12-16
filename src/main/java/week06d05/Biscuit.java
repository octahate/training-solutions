package week06d05;

public class Biscuit {
    private BiscuitType type;
    private int gramAmount;

    public void setType(BiscuitType type) {
        this.type = type;
    }

    public void setGramAmount(int gramAmount) {
        this.gramAmount = gramAmount;
    }

    public static Biscuit of (BiscuitType biszku, int gramAmount){
        Biscuit biszki = new Biscuit();
        biszki.setType(biszku);
        biszki.setGramAmount(gramAmount);
        return biszki;
    }
}
