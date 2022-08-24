package item;

public class Currency {
    private int copperPieces;
    private int silverPieces;
    private int electrumPieces;
    private int goldPieces;
    private int platinumPieces;

    public Currency(int value) {
        this.copperPieces = 0;
        this.silverPieces = 0;
        this.electrumPieces = 0;
        this.goldPieces = 0;
        this.platinumPieces = 0;

        while (value > 0) {
            if (value >= 100) {
                this.goldPieces += 1;
                value -= 100;
            } else if (value >= 10) {
                this.silverPieces += 1;
                value -= 10;
            } else {
                this.copperPieces += 1;
                value -= 1;
            }
        }
    }

    public int getCopperPieces() {
        return this.copperPieces;
    }

    public int getSilverPieces() {
        return this.silverPieces;
    }

    public int getElectrumPieces() {
        return this.electrumPieces;
    }

    public int getGoldPieces() {
        return this.goldPieces;
    }

    public int getPlatinumPieces() {
        return this.platinumPieces;
    }

    
}
