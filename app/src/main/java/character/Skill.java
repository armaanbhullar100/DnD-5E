package character;

public class Skill {
    private boolean proficient;
    private int value;

    public Skill(boolean proficient, int value) {
        this.proficient = proficient;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Skill s = (Skill) obj;

        if (value != s.getValue()) {
            return false;
        } else if (proficient != s.getProficient()) {
            return false;
        }

        return true;
    }

    public boolean getProficient() {
        return proficient;
    }

    public int getValue() {
        return value;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }
}
