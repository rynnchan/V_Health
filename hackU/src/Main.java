public class Main {
    
    /** main **/
    public static void main(String[] args) {
        double[] colors = {6,5,4};
        Colorcheck colorcheck = new Colorcheck();
        System.out.println(colorcheck.minColor(colors));
        colors = newColors(5,5,10);
        System.out.println(colorcheck.minColor(colors));
        colors = newColors(0,5,1);
        System.out.println(colorcheck.minColor(colors));
    }

    public static double[] newColors(double r,double g, double y){
        double[] colors = {r,g,y};
        return colors;
    }
}