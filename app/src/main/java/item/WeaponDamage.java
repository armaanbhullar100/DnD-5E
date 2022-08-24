package item;

public class WeaponDamage {
    private int hitDice;
    private int numDice;
    private String damageType;

    public WeaponDamage(String damage) {
        
        String[] newString = damage.split(" ");
        String[] dice = newString[0].split("d");

        this.hitDice = Integer.parseInt(dice[1]);
        this.numDice = Integer.parseInt(dice[0]);
        this.damageType = newString[1];
    }

    public int getHitDice() {
        return this.hitDice;
    }

    public int getNumDice() {
        return this.numDice;
    }

    public String getDamageType() {
        return this.damageType;
    }
}
