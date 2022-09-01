package character;

import java.util.ArrayList;

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
    private CharacterSpecs characterSpecs;

    private int currHitPoints;
    private int maxHitPoints;
    private int tempHitPoints;
    private HitDice hitDice;
    private int armorClass;
    private boolean initiative;

    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<String> proficiencies = new ArrayList<>(); 
    private ArrayList<String> equipment = new ArrayList<>();
    private Currency wealth;
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<Weapon> attacks = new ArrayList<>();
    private SpellBook spells;
    private CharacterDescription description;

    public Character() {

    }

    public String getCharacterName() {
        return this.characterName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Class getCharacterClass() {
        return this.characterClass;
    }

    public int getLevel() {
        return this.level;
    }

    public Race getRace() {
        return this.race;
    }

    public Background getBackground() {
        return this.background;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getExpPoints() {
        return this.expPoints;
    }

    public CharacterSpecs getCharacterSpecs() {
        return this.characterSpecs;
    }

    public int getCurrHitPoints() {
        return this.currHitPoints;
    }

    public int getMaxHitPoints() {
        return this.maxHitPoints;
    }

    public int getTempHitPoints() {
        return this.tempHitPoints;
    }

    public HitDice getHitDice() {
        return this.hitDice;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public boolean isInitiative() {
        return this.initiative;
    }

    public String getPersonalityTraits() {
        return this.personalityTraits;
    }

    public String getIdeals() {
        return this.ideals;
    }

    public String getBonds() {
        return this.bonds;
    }

    public String getFlaws() {
        return this.flaws;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getProficiencies() {
        return this.proficiencies;
    }

    public ArrayList<String> getEquipment() {
        return this.equipment;
    }

    public Currency getWealth() {
        return this.wealth;
    }

    public ArrayList<Feature> getFeatures() {
        return this.features;
    }

    public ArrayList<Weapon> getAttacks() {
        return this.attacks;
    }

    public SpellBook getSpells() {
        return this.spells;
    }

    public CharacterDescription getDescription() {
        return this.description;
    }

    
}
