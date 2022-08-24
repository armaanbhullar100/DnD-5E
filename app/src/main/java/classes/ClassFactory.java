package classes;

import classes.classList.*;

public class ClassFactory {
    public Class createClass(String classType) {
        if (classType.equals("Barbarian")) {
            return new Barbarian();
        } if (classType.equals("Bard")) {
            return new Bard();
        } if (classType.equals("Cleric")) {
            return new Cleric();
        } if (classType.equals("Druid")) {
            return new Druid();
        } if (classType.equals("Fighter")) {
            return new Fighter();
        } if (classType.equals("Monk")) {
            return new Monk();
        } if (classType.equals("Paladin")) {
            return new Paladin();
        } if (classType.equals("Ranger")) {
            return new Ranger();
        } if (classType.equals("Rogue")) {
            return new Rogue();
        } if (classType.equals("Sorcerer")) {
            return new Sorcerer();
        } if (classType.equals("Warlock")) {
            return new Warlock();
        } if (classType.equals("Wizard")) {
            return new Wizard();
        } else {
            return null;
        }
    }
}
