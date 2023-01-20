package character;

public class SavingThrow {
    private boolean proficient;
    private int value;

    public SavingThrow(boolean proficient, int value) {
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

        SavingThrow st = (SavingThrow) obj;

        if (value != st.getValue()) {
            return false;
        } else if (proficient != st.getProficient()) {
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
