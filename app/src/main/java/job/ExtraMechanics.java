package job;

import java.util.ArrayList;

public class ExtraMechanics {
    private ArrayList<Integer> maxRages;
    private ArrayList<Integer> rageDamage;
    private int currRages;

    public ExtraMechanics() {}

    public ExtraMechanics(ArrayList<Integer> maxRages, ArrayList<Integer> rageDamage) {
        this.maxRages = maxRages;
        this.rageDamage = rageDamage;
        this.currRages = 2;
    }

    public int getMaxRages(int level) {
        return maxRages.get(level);
    }

    public int getRageDamage(int level) {
        return rageDamage.get(level);
    }

    public int getCurrRages() {
        return currRages;
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
}
