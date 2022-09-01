package classes;

public class ClassMagic {
    private int spellSaveDC;
    private int spellAttackModifier;
    private SpellSlots spellSlots;
    private String magicType;
    private int numSpellsKnown;

    public ClassMagic() {

    }

    public int getSpellSaveDC() {
        return this.spellSaveDC;
    }

    public int getSpellAttackModifier() {
        return this.spellAttackModifier;
    }

    public SpellSlots getSpellSlots() {
        return this.spellSlots;
    }

    public String getMagicType() {
        return this.magicType;
    }

    public int getNumSpellsKnown() {
        return this.numSpellsKnown;
    }

    
}
