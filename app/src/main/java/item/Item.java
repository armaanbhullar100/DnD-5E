package item;

public class Item {
    private String name;
    private Double weight;
    private Currency cost;
    private String description;

    public Item(String name, Double weight, Currency cost, String description) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } 
        
        Item i = (Item) obj;
        if (!this.name.equals(i.getName())) {
            System.err.println("1");
            return false;
        } else if (!this.weight.equals(i.getWeight())) {
            System.err.println("2");
            return false;
        } else if (!(this.cost.equals(i.getCost()))) {
            System.err.println("3");
            return false;
        } else if (!this.description.equals(i.getDescription())) {
            System.err.println("4");
            return false;
        }

        return true;
    }

    public String getName() {
        return this.name;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Currency getCost() {
        return this.cost;
    }

    public String getDescription() {
        return description;
    }
}
