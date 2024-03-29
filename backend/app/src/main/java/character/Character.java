package character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import item.Currency;
import item.Item;
import item.Weapon;
import job.Job;
import magic.SpellBook;

public class Character {
    private String characterName;
    private String playerName;
    private Job characterClass;
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
    private ArrayList<String> itemProficiencies = new ArrayList<>(); 
    private HashMap<String,Item> equipment = new HashMap<>();
    private Currency wealth = new Currency(0);
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private SpellBook spells;
    private CharacterDescription description;

    public Character(String characterName, String playerName, Job characterClass, Race race, Background background, String alignment, ArrayList<Integer> abilityScoresArray) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.characterClass = characterClass;
        this.race = race;
        this.background = background;
        this.alignment = alignment;
        this.level = 1;
        this.expPoints = 0;

        // Assign ability score values
        abilityScores.put("Strength", new AbilityScore(abilityScoresArray.get(0)));
        abilityScores.put("Dexerity", new AbilityScore(abilityScoresArray.get(1)));
        abilityScores.put("Constitution", new AbilityScore(abilityScoresArray.get(2)));
        abilityScores.put("Intelligence", new AbilityScore(abilityScoresArray.get(3)));
        abilityScores.put("Wisdom", new AbilityScore(abilityScoresArray.get(4)));
        abilityScores.put("Charisma", new AbilityScore(abilityScoresArray.get(5)));

        // Assign saving throw values
        savingThrows.put("Strength", new SavingThrow(false, getAbilityScoreModifier("Strength")));
        savingThrows.put("Dexerity", new SavingThrow(false, getAbilityScoreModifier("Dexerity")));
        savingThrows.put("Constitution", new SavingThrow(false, getAbilityScoreModifier("Constitution")));
        savingThrows.put("Intelligence", new SavingThrow(false, getAbilityScoreModifier("Intelligence")));
        savingThrows.put("Wisdom", new SavingThrow(false, getAbilityScoreModifier("Wisdom")));
        savingThrows.put("Charisma", new SavingThrow(false, getAbilityScoreModifier("Charisma")));

        // Set proficiencies of saving throws from character class to true
        ArrayList<String> stp = characterClass.getSavingThrowProficiencies();
        for (int i = 0; i < stp.size(); i++) {
            savingThrows.get(stp.get(i)).setProficient(true);
        }

        // Assign skills from ability scores
        skills.put("Acrobatics", new Skill(false, getAbilityScoreModifier("Dexerity")));
        skills.put("Animal Handling", new Skill(false, getAbilityScoreModifier("Wisdom")));
        skills.put("Arcana", new Skill(false, getAbilityScoreModifier("Intelligence")));
        skills.put("Athletics", new Skill(false, getAbilityScoreModifier("Strength")));
        skills.put("Deception", new Skill(false, getAbilityScoreModifier("Charisma")));
        skills.put("History", new Skill(false, getAbilityScoreModifier("Intelligence")));
        skills.put("Insight", new Skill(false, getAbilityScoreModifier("Wisdom")));
        skills.put("Intimidation", new Skill(false, getAbilityScoreModifier("Charisma")));
        skills.put("Investigation", new Skill(false, getAbilityScoreModifier("Intelligence")));
        skills.put("Medicine", new Skill(false, getAbilityScoreModifier("Wisdom")));
        skills.put("Nature", new Skill(false, getAbilityScoreModifier("Intelligence")));
        skills.put("Perception", new Skill(false, getAbilityScoreModifier("Wisdom")));
        skills.put("Performance", new Skill(false, getAbilityScoreModifier("Charisma")));
        skills.put("Persuasion", new Skill(false, getAbilityScoreModifier("Charisma")));
        skills.put("Religion", new Skill(false, getAbilityScoreModifier("Intelligence")));
        skills.put("Sleight of Hand", new Skill(false, getAbilityScoreModifier("Dexerity")));
        skills.put("Stealth", new Skill(false, getAbilityScoreModifier("Dexerity")));
        skills.put("Survival", new Skill(false, getAbilityScoreModifier("Wisdom")));

        // Set proficiencies of skills from background and character class
        ArrayList<String> spb = background.getSkillProficiencies();
        ArrayList<String> spc = characterClass.getSkillProficiencies();
        for (int i = 0; i < spb.size(); i++) {
            skills.get(spb.get(i)).setProficient(true);
        }
        for (int i = 0; i < spc.size(); i++) {
            skills.get(spc.get(i)).setProficient(true);
        }

        this.proficiencyBonus = 2;
        this.maxHitPoints = characterClass.getHitDice() + getAbilityScoreModifier("Constitution");
        this.currHitPoints = maxHitPoints;
        this.tempHitPoints = 0;
        this.hitDice = new HitDice(characterClass.getHitDice());
        this.armorClass = 0;
        this.initiative = abilityScores.get("Dexerity").getModifier();
        this.inspiration = false;

        // Get languages from background and race
        ArrayList<String> lb = background.getLanguages();
        ArrayList<String> lr = race.getLanguages();
        for (int i = 0; i < lb.size(); i++) {
            if (!languages.contains(lb.get(i))) {
                languages.add(lb.get(i));
            }
        }
        for (int i = 0; i < lr.size(); i++) {
            if (!languages.contains(lr.get(i))) {
                languages.add(lr.get(i));
            }
        }

        // Get item proficiencies from background and character class
        ArrayList<String> ipb = background.getToolProficiencies();
        ArrayList<String> ipc = characterClass.getItemProficiencies();
        for (int i = 0; i < ipb.size(); i++) {
            if (!itemProficiencies.contains(ipb.get(i))) {
                itemProficiencies.add(ipb.get(i));
            }
        }
        for (int i = 0; i < ipc.size(); i++) {
            if (!itemProficiencies.contains(ipc.get(i))) {
                itemProficiencies.add(ipc.get(i));
            }
        }

        // Get equipment from background and character class
        ArrayList<Item> eb = background.getEquipment();
        for (int i = 0; i < eb.size(); i++) {
            Item currItem = eb.get(i);
            if (!equipment.keySet().contains(currItem.getName())) {
                equipment.put(currItem.getName(), currItem);
            }
        }
        HashMap<String,Item> ec = characterClass.getEquipment();
        Iterator<String> objectKeys = ec.keySet().iterator();
        while (objectKeys.hasNext()) {
            String currKey = objectKeys.next();
            if (!equipment.keySet().contains(currKey)) {
                equipment.put(currKey, ec.get(currKey));
            }
        }

        // Get current wealth from background
        for (int i = 0; i < eb.size(); i++) {
            Item currItem = eb.get(i);
            if (currItem.getName().equals("Currency Pouch")) {
                wealth.increaseCurrency(currItem.getAmount()*100);
            }
        }

        // Get features from background, race and character class
        ArrayList<Feature> fb = background.getFeatures();
        ArrayList<Feature> fr = race.getFeatures();
        ArrayList<Feature> fc = characterClass.getFeatures();
        for (int i = 0; i < fb.size(); i++) {
            features.add(fb.get(i));
        }
        for (int i = 0; i < fr.size(); i++) {
            features.add(fr.get(i));
        }
        for (int i = 0; i < fc.size(); i++) {
            features.add(fc.get(i));
        }

        // Get weapons from character class
        Iterator<Item> classEquipmentIterator = ec.values().iterator();
        while (classEquipmentIterator.hasNext()) {
            Item currItem = classEquipmentIterator.next();
            if (currItem.getItemType().equals("Weapon")) {
                weapons.add((Weapon)currItem);
            }
        }

        // Get magic from character class 
        // Assign Spell Save DC, Spell Attack Bonus, Spellcasting Ability, Ritual Casting, Cantrips, and Spells
        this.spells = characterClass.getSpellBook();
        if (spells != null) {
            spells.setSpellSaveDC(8 + proficiencyBonus + getAbilityScoreModifier(spells.getSpellcastingAbility()));
            spells.setSpellAttackBonus(proficiencyBonus + getAbilityScoreModifier(spells.getSpellcastingAbility()));
        }

    }

    public String getCharacterName() {
        return characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Job getCharacterClass() {
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

    public boolean getInspiration() {
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

    public ArrayList<String> getItemProficiencies() {
        return itemProficiencies;
    }

    public HashMap<String, Item> getEquipment() {
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

    public int getAbilityScoreModifier(String abilityScore) {
        return abilityScores.get(abilityScore).getModifier();
    }

    
}
