package inheritancemethods;

import java.math.BigDecimal;

public class PackedProduct extends Product{

    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces){
        return super.totalWeight(pieces).add(weightOfBox.multiply(new BigDecimal(Math.ceil(pieces/packingUnit))));
    }
}
