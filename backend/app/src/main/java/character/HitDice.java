package character;

public class HitDice {
    private int diceNumber;
    private int currAmount;
    private int maxAmount;

    public HitDice(int diceNumber) {
        this.diceNumber = diceNumber;
        this.currAmount = 1;
        this.maxAmount = 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        HitDice hd = (HitDice) obj;
        if (diceNumber != hd.getDiceNumber()) {
            return false;
        } else if (currAmount != hd.getCurrAmount()) {
            return false;
        } else if (maxAmount != hd.getMaxAmount()) {
            return false;
        }

        return true;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public int getCurrAmount() {
        return currAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setCurrAmount(int currAmount) {
        this.currAmount = currAmount;
    }
}
