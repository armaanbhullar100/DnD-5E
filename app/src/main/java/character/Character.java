package character;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Class;
import item.Currency;
import item.Weapon;

public class Character {
    private String characterName;
    private String playerName;
    private Class characterClass;
    private int level;
    private Race race;
    private Background background;
    private String alignment;
    private int expPoints;
    
    private HashMap<String, AbilityScore> abilityScores = new HashMap<>();
    private HashMap<String, SavingThrow> savingThrows = new HashMap<>();
    private HashMap<String, Skill> skills = new HashMap<>();

    private int proficiencyBonus;
    private int passivePerception;

    private int currHitPoints;
    private int maxHitPoints;
    private int tempHitPoints;
    private HitDice hitDice;
    private int armorClass;
    private int initiative;
    private boolean inspiration;

    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<String> proficiencies = new ArrayList<>(); 
    private ArrayList<String> equipment = new ArrayList<>();
    private Currency wealth;
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private SpellBook spells;
    private CharacterDescription description;

    public Character(String characterName, String playerName, Class characterClass, Race race, Background background, String alignment, ArrayList<Integer> abilityScoresArray) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.characterClass = characterClass;
        this.race = race;
        this.background = background;
        this.alignment = alignment;
        this.level = 1;
        this.expPoints = 0;

        abilityScores.put("strength", new AbilityScore(abilityScoresArray.get(0)));
        abilityScores.put("dexerity", new AbilityScore(abilityScoresArray.get(1)));
        abilityScores.put("constitution", new AbilityScore(abilityScoresArray.get(2)));
        abilityScores.put("intelligence", new AbilityScore(abilityScoresArray.get(3)));
        abilityScores.put("wisdom", new AbilityScore(abilityScoresArray.get(4)));
        abilityScores.put("charisma", new AbilityScore(abilityScoresArray.get(5)));

        savingThrows.put("strength", new SavingThrow(false, abilityScores.get("strength").getModifier()));
        savingThrows.put("dexerity", new SavingThrow(false, abilityScores.get("dexerity").getModifier()));
        savingThrows.put("constitution", new SavingThrow(false, abilityScores.get("constitution").getModifier()));
        savingThrows.put("intelligence", new SavingThrow(false, abilityScores.get("intelligence").getModifier()));
        savingThrows.put("wisdom", new SavingThrow(false, abilityScores.get("wisdom").getModifier()));
        savingThrows.put("charisma", new SavingThrow(false, abilityScores.get("charisma").getModifier()));

        ArrayList<String> stp = characterClass.getSavingThrowProficiencies();
        for (int i = 0; i < stp.size(); i++) {
            savingThrows.get(stp.get(i)).setProficient(true);
        }

        skills.put("Acrobatics", new Skill(false, abilityScores.get("dexerity").getModifier()));
        skills.put("Animal Handling", new Skill(false, abilityScores.get("wisdom").getModifier()));
        skills.put("Arcana", new Skill(false, abilityScores.get("intelligence").getModifier()));
        skills.put("Athletics", new Skill(false, abilityScores.get("strength").getModifier()));
        skills.put("Deception", new Skill(false, abilityScores.get("charisma").getModifier()));
        skills.put("History", new Skill(false, abilityScores.get("intelligence").getModifier()));
        skills.put("Insight", new Skill(false, abilityScores.get("wisdom").getModifier()));
        skills.put("Intimidation", new Skill(false, abilityScores.get("charisma").getModifier()));
        skills.put("Investigation", new Skill(false, abilityScores.get("intelligence").getModifier()));
        skills.put("Medicine", new Skill(false, abilityScores.get("wisdom").getModifier()));
        skills.put("Nature", new Skill(false, abilityScores.get("intelligence").getModifier()));
        skills.put("Perception", new Skill(false, abilityScores.get("wisdom").getModifier()));
        skills.put("Performance", new Skill(false, abilityScores.get("charisma").getModifier()));
        skills.put("Persuasion", new Skill(false, abilityScores.get("charisma").getModifier()));
        skills.put("Religion", new Skill(false, abilityScores.get("intelligence").getModifier()));
        skills.put("Sleight of Hand", new Skill(false, abilityScores.get("dexerity").getModifier()));
        skills.put("Stealth", new Skill(false, abilityScores.get("dexerity").getModifier()));
        skills.put("Survival", new Skill(false, abilityScores.get("wisdom").getModifier()));

        ArrayList<String> spb = background.getSkillProficiencies();
        ArrayList<String> spc = characterClass.getSkillProficiencies();
        for (int i = 0; i < spb.size(); i++) {
            skills.get(spb.get(i)).setProficient(true);
        }
        for (int i = 0; i < spc.size(); i++) {
            skills.get(spc.get(i)).setProficient(true);
        }

        this.proficiencyBonus = 2;
        this.maxHitPoints = characterClass.getHitDice() + abilityScores.get("constitution").getModifier();
        this.currHitPoints = maxHitPoints;
        this.tempHitPoints = 0;
        this.hitDice = new HitDice(characterClass.getHitDice());
        this.armorClass = 0;
        this.initiative = abilityScores.get("dexerity").getModifier();
        this.inspiration = false;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Class getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public Race getRace() {
        return race;
    }

    public Background getBackground() {
        return background;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getExpPoints() {
        return expPoints;
    }

    public HashMap<String, AbilityScore> getAbilityScores() {
        return abilityScores;
    }

    public HashMap<String, SavingThrow> getSavingThrows() {
        return savingThrows;
    }

    public HashMap<String, Skill> getSkills() {
        return skills;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public int getPassivePerception() {
        return passivePerception;
    }

    public int getCurrHitPoints() {
        return currHitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getTempHitPoints() {
        return tempHitPoints;
    }

    public HitDice getHitDice() {
        return hitDice;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public boolean isInspiration() {
        return inspiration;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public ArrayList<String> getProficiencies() {
        return proficiencies;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public Currency getWealth() {
        return wealth;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public SpellBook getSpells() {
        return spells;
    }

    public CharacterDescription getDescription() {
        return description;
    }

    
}
