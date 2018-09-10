package INfO6205FinalProject.GeneGenotype;

public class City {
    int id = 0;
    double x = 0;
    double y = 0;

    public City(int index){
        id = index;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }
}
