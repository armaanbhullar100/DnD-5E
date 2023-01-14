package job;

public class EldritchInvocation {
    private String name;
    private String effect;
    private int prerequisiteLevel;
    private String prerequisitePactBoon;
    private Spell prerequisiteSpell;

    public EldritchInvocation(String name, String effect, int prerequisiteLevel, String prerequisitePactBoon, Spell prerequisiteSpell) {
        this.name = name;
        this.effect = effect;
        this.prerequisiteLevel = prerequisiteLevel;
        this.prerequisitePactBoon = prerequisitePactBoon;
        this.prerequisiteSpell = prerequisiteSpell;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getPrerequisiteLevel() {
        return prerequisiteLevel;
    }

    public String getPrerequisitePactBoon() {
        return prerequisitePactBoon;
    }

    public Spell getPrerequisiteSpell() {
        return prerequisiteSpell;
    }

    
}
