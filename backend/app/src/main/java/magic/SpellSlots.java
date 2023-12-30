package magic;

import java.util.ArrayList;

public class SpellSlots {
    private ArrayList<Integer> cantrips;
    private ArrayList<Integer> firstLevel;
    private ArrayList<Integer> secondLevel;
    private ArrayList<Integer> thirdLevel;
    private ArrayList<Integer> fourthLevel;
    private ArrayList<Integer> fifthLevel;
    private ArrayList<Integer> sixthLevel;
    private ArrayList<Integer> seventhLevel;
    private ArrayList<Integer> eighthLevel;
    private ArrayList<Integer> ninthLevel;

    public SpellSlots(ArrayList<Integer> cantrips, ArrayList<Integer> firstLevel, ArrayList<Integer> secondLevel, ArrayList<Integer> thirdLevel, ArrayList<Integer> fourthLevel, ArrayList<Integer> fifthLevel, ArrayList<Integer> sixthLevel, ArrayList<Integer> seventhLevel, ArrayList<Integer> eighthLevel, ArrayList<Integer> ninthLevel) {
        this.cantrips = cantrips;
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
        this.thirdLevel = thirdLevel;
        this.fourthLevel = fourthLevel;
        this.fifthLevel = fifthLevel;
        this.sixthLevel = sixthLevel;
        this.seventhLevel = seventhLevel;
        this.eighthLevel = eighthLevel;
        this.ninthLevel = ninthLevel;
    }

    public int getNumCantrips(int level) {
        return cantrips.get(level);
    }

    public int getFirstLevelSpellSlots(int level) {
        return firstLevel.get(level);
    }

    public int getSecondLevelSpellSlots(int level) {
        return secondLevel.get(level);
    }

    public int getThirdLevelSpellSlots(int level) {
        return thirdLevel.get(level);
    }

    public int getFourthLevelSpellSlots(int level) {
        return fourthLevel.get(level);
    }

    public int getFifthLevelSpellSlots(int level) {
        return fifthLevel.get(level);
    }

    public int getSixthLevelSpellSlots(int level) {
        return sixthLevel.get(level);
    }

    public int getSeventhLevelSpellSlots(int level) {
        return seventhLevel.get(level);
    }

    public int getEighthLevelSpellSlots(int level) {
        return eighthLevel.get(level);
    }

    public int getNinthLevelSpellSlots(int level) {
        return ninthLevel.get(level);
    }
    
}
