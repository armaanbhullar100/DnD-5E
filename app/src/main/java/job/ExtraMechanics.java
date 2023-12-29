package job;

import java.util.ArrayList;

public class ExtraMechanics {
    private ArrayList<Integer> maxRages;
    private ArrayList<Integer> rageDamage;
    private int currRages;
    private ArrayList<Integer> martialArtsDice;
    private ArrayList<Integer> maxKiPoints;
    private int currKiPoints;
    private ArrayList<Integer> unarmoredMovement;

    public ExtraMechanics() {}

    public int getMaxRages(int level) {
        return maxRages.get(level);
    }

    public int getRageDamage(int level) {
        return rageDamage.get(level);
    }

    public int getCurrRages() {
        return currRages;
    }

    public int getMartialArtsDice(int level) {
        return martialArtsDice.get(level);
    }

    public int getMaxKiPoints(int level) {
        return maxKiPoints.get(level);
    }

    public int getCurrKiPoints() {
        return currKiPoints;
    }

    public int getUnarmoredMovement(int level) {
        return unarmoredMovement.get(level);
    }

    public void setMaxRages(ArrayList<Integer> maxRages) {
        this.maxRages = maxRages;
    }

    public void setRageDamage(ArrayList<Integer> rageDamage) {
        this.rageDamage = rageDamage;
    }

    public void setCurrRages(int currRages) {
        this.currRages = currRages;
    }

    public void setMartialArtsDice(ArrayList<Integer> martialArtsDice) {
        this.martialArtsDice = martialArtsDice;
    }

    public void setMaxKiPoints(ArrayList<Integer> maxKiPoints) {
        this.maxKiPoints = maxKiPoints;
    }

    public void setCurrKiPoints(int currKiPoints) {
        this.currKiPoints = currKiPoints;
    }

    public void setUnarmoredMovement(ArrayList<Integer> unarmoredMovement) {
        this.unarmoredMovement = unarmoredMovement;
    }
}
