import java.io.Serializable;

public class Set_json implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double fat ;
    private double slim;
    private double sleepy;
    private double good;
    private double bad;

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSlim() {
        return slim;
    }

    public void setSlim(double slim) {
        this.slim = slim;
    }

    public double getSleepy() {
        return sleepy;
    }

    public void setSleepy(double sleepy) {
        this.sleepy = sleepy;
    }

    public double getGood() {
        return good;
    }

    public void setGood(double good) {
        this.good = good;
    }

    public double getBad() {
        return bad;
    }

    public void setBad(double bad) {
        this.bad= bad;
    }
}