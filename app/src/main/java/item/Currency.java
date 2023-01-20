package item;

public class Currency {
    private int copperPieces;
    private int silverPieces;
    private int electrumPieces;
    private int goldPieces;
    private int platinumPieces;

    public Currency(int value) {
        copperPieces = 0;
        silverPieces = 0;
        electrumPieces = 0;
        goldPieces = 0;
        platinumPieces = 0;

        while (value > 0) {
            if (value >= 100) {
                goldPieces += 1;
                value -= 100;
            } else if (value >= 10) {
                silverPieces += 1;
                value -= 10;
            } else {
                copperPieces += 1;
                value -= 1;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Currency c = (Currency) obj;
        if (copperPieces != c.getCopperPieces()) {
            return false;
        } else if (silverPieces != c.getSilverPieces()) {
            return false;
        } else if (electrumPieces != c.getElectrumPieces()) {
            return false;
        } else if (goldPieces != c.getGoldPieces()) {
            return false;
        } else if (platinumPieces != c.getPlatinumPieces()) {
            return false;
        }

        return true;
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

    public int getTotalCurrency() {
        return goldPieces*100 + silverPieces*10 + copperPieces*1;
    }

    public void increaseCurrency(int value) {
        while (value > 0) {
            if (value >= 100) {
                goldPieces += 1;
                value -= 100;
            } else if (value >= 10) {
                silverPieces += 1;
                value -= 10;
            } else {
                copperPieces += 1;
                value -= 1;
            }
        }
    }
}
