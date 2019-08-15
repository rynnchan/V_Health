import java.io.Serializable;

public class Set_json implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int sex;
    private int physicalActivityLevel;
    private String wakeUpTime	;
    private String bedTime;
    private double calorie;
    private double salt;
    private double red;
    private double green;
    private double yellow;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getPhysicalActivityLevel() {
        return physicalActivityLevel - 1;
    }

    public void setPhysicalActivityLevel(int physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }

    public int[] getWakeUptime() {
        String[] spl = wakeUpTime.split(":");
        int[] time = {Integer.parseInt(spl[0], Integer.parseInt(spl[1]))};

        return time;
    }

    public void setWakeUptime(String wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public int[] getBedtime() {
        String[] spl = bedTime.split(":");
        int[] time = {Integer.parseInt(spl[0], Integer.parseInt(spl[1]))};

        return time;
    }

    public void setBedtime(String bedTime) {
        this.bedTime = bedTime;
    }

    public int getCalorie() {
        return (int)calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public double[] getColors() {
        double[] colors = {red, green, yellow};

        return colors;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setYellow(double yellow) {
        this.yellow = yellow;
    }
}