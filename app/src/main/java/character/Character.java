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

    ArrayList<String> languages = new ArrayList<>();
    ArrayList<String> proficiencies = new ArrayList<>(); 
    ArrayList<String> equipment = new ArrayList<>();
    Currency wealth;
    ArrayList<Feature> features = new ArrayList<>();
    ArrayList<Weapon> attacks = new ArrayList<>();
    SpellBook spells;
    CharacterDescription description;
}
