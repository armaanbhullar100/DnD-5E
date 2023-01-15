package item;

public class Item {
    private String name;
    private Double weight;
    private Currency cost;
    private String description;
    private int amount;

    public Item(String name, Double weight, Currency cost, String description, int amount) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } 
        
        Item i = (Item) obj;
        if (!name.equals(i.getName())) {
            return false;
        } else if (!weight.equals(i.getWeight())) {
            return false;
        } else if (!(cost.equals(i.getCost()))) {
            return false;
        } else if (!description.equals(i.getDescription())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Currency getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }
}
