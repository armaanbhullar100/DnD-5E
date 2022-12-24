package character;
 
public class CharacterSpecs {
    private AbilityScore strength;
    private AbilityScore dexerity;
    private AbilityScore constitution;
    private AbilityScore intelligence;
    private AbilityScore wisdom;
    private AbilityScore charisma;

    private Skill strengthSavingThrow;
    private Skill dexeritySavingThrow;
    private Skill constitutionSavingThrow;
    private Skill intelligenceSavingThrow;
    private Skill wisdomSavingThrow;
    private Skill charismaSavingThrow;
 
    private Skill acrobatics;
    private Skill animalHandling;
    private Skill arcana;
    private Skill athletics;
    private Skill deception;
    private Skill history;
    private Skill insight;
    private Skill intimidation;
    private Skill investigation;
    private Skill medicine;
    private Skill nature;
    private Skill perception;
    private Skill performance;
    private Skill persuasion;
    private Skill religion;
    private Skill sleightOfHand;
    private Skill stealth;
    private Skill survival;

    private int passivePerception;

    public CharacterSpecs() {

    }

    public AbilityScore getStrength() {
        return this.strength;
    }

    public AbilityScore getDexerity() {
        return this.dexerity;
    }

    public AbilityScore getConstitution() {
        return this.constitution;
    }

    public AbilityScore getIntelligence() {
        return this.intelligence;
    }

    public AbilityScore getWisdom() {
        return this.wisdom;
    }

    public AbilityScore getCharisma() {
        return this.charisma;
    }

    public Skill getStrengthSavingThrow() {
        return this.strengthSavingThrow;
    }

    public Skill getDexeritySavingThrow() {
        return this.dexeritySavingThrow;
    }

    public Skill getConstitutionSavingThrow() {
        return this.constitutionSavingThrow;
    }

    public Skill getIntelligenceSavingThrow() {
        return this.intelligenceSavingThrow;
    }

    public Skill getWisdomSavingThrow() {
        return this.wisdomSavingThrow;
    }

    public Skill getCharismaSavingThrow() {
        return this.charismaSavingThrow;
    }

    public Skill getAcrobatics() {
        return this.acrobatics;
    }

    public Skill getAnimalHandling() {
        return this.animalHandling;
    }

    public Skill getArcana() {
        return this.arcana;
    }

    public Skill getAthletics() {
        return this.athletics;
    }

    public Skill getDeception() {
        return this.deception;
    }

    public Skill getHistory() {
        return this.history;
    }

    public Skill getInsight() {
        return this.insight;
    }

    public Skill getIntimidation() {
        return this.intimidation;
    }

    public Skill getInvestigation() {
        return this.investigation;
    }

    public Skill getMedicine() {
        return this.medicine;
    }

    public Skill getNature() {
        return this.nature;
    }

    public Skill getPerception() {
        return this.perception;
    }

    public Skill getPerformance() {
        return this.performance;
    }

    public Skill getPersuasion() {
        return this.persuasion;
    }

    public Skill getReligion() {
        return this.religion;
    }

    public Skill getSleightOfHand() {
        return this.sleightOfHand;
    }

    public Skill getStealth() {
        return this.stealth;
    }

    public Skill getSurvival() {
        return this.survival;
    }

    public int getPassivePerception() {
        return this.passivePerception;
    }

    
}