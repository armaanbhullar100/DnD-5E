package job;

import magic.SpellSlots;

public class JobMagic {
    private int spellSaveDC;
    private int spellAttackModifier;
    private SpellSlots spellSlots;
    private String magicType;
    private int numSpellsKnown;

    public JobMagic(int spellSaveDC, int spellAttackModifier, SpellSlots spellSlots, String magicType, int numSpellsKnown) {
        this.spellSaveDC = spellSaveDC;
        this.spellAttackModifier = spellAttackModifier;
        this.spellSlots = spellSlots;
        this.magicType = magicType;
        this.numSpellsKnown = numSpellsKnown;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public int getSpellAttackModifier() {
        return spellAttackModifier;
    }

    public SpellSlots getSpellSlots() {
        return spellSlots;
    }

    public String getMagicType() {
        return magicType;
    }

    public int getNumSpellsKnown() {
        return numSpellsKnown;
    }

    
}
