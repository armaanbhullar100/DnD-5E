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
    private ArrayList<Integer> sneakAttackDice;
    private ArrayList<Integer> maxSorceryPoints;
    private int currSorceryPoints;
    private ArrayList<Integer> warlockSpellSlotLevel;
    private ArrayList<Integer> warlockSpellSlotNum;
    private ArrayList<Integer> wizardSpellsKnown;

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

    public int getSneakAttackDice(int level) {
        return sneakAttackDice.get(level);
    }

    public int getMaxSorceryPoints(int level) {
        return maxSorceryPoints.get(level);
    }

    public int getCurrSorceryPoints() {
        return currSorceryPoints;
    }

    public int getWarlockSpellSlotNum(int level) {
        return warlockSpellSlotNum.get(level);
    }

    public int getWarlockSpellSlotLevel(int level) {
        return warlockSpellSlotLevel.get(level);
    }

    public int getWizardSpellsKnown(int level) {
        return wizardSpellsKnown.get(level);
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

    public void setSneakAttackDice(ArrayList<Integer> sneakAttackDice) {
        this.sneakAttackDice = sneakAttackDice;
    }

    public void setMaxSorceryPoints(ArrayList<Integer> maxSorceryPoints) {
        this.maxSorceryPoints = maxSorceryPoints;
    }

    public void setCurrSorceryPoints(int currSorceryPoints) {
        this.currSorceryPoints = currSorceryPoints;
    }

    public void setWarlockSpellSlotNum(ArrayList<Integer> warlockSpellSlotNum) {
        this.warlockSpellSlotNum = warlockSpellSlotNum;
    }

    public void setWarlockSpellSlotLevel(ArrayList<Integer> warlockSpellSlotLevel) {
        this.warlockSpellSlotLevel = warlockSpellSlotLevel;
    }

    public void setWizardSpellsKnown(ArrayList<Integer> wizardSpellsKnown) {
        this.wizardSpellsKnown = wizardSpellsKnown;
    }
}
