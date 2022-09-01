package classes;

public class EldritchInvocation {
    private String name;
    private String effect;
    private int prerequisiteLevel;
    private String prerequisitePactBoon;
    private Spell prerequisiteSpell;

    public EldritchInvocation() {

    }

    public String getName() {
        return this.name;
    }

    public String getEffect() {
        return this.effect;
    }

    public int getPrerequisiteLevel() {
        return this.prerequisiteLevel;
    }

    public String getPrerequisitePactBoon() {
        return this.prerequisitePactBoon;
    }

    public Spell getPrerequisiteSpell() {
        return this.prerequisiteSpell;
    }

    
}
