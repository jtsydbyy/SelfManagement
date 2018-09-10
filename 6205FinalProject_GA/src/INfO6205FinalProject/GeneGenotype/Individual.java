package INfO6205FinalProject.GeneGenotype;

public class Individual {
    City[] order = new City[30];
    double weight = 0;

    public City[] getOrder() {
        return order;
    }

    public void setOrder(City[] order) {
        this.order = order;
    }

    //Calculate the total weight of this Individual.
    public void calculateTotalWeight() {
        for(int i = 0; i < 29; i ++){
            weight = weight + calculateWeight(order[i], order[i + 1]);
        }
        weight = weight + calculateWeight(order[29], order[0]);
    }

    //Calculate the distance between 2 cities.
    public double calculateWeight(City a, City b){

        double _x = Math.abs(a.getX() - b.getX());
        double _y = Math.abs(a.getY() - b.getY());

        return Math.sqrt(_x*_x+_y*_y);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
