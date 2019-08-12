public class Main {
    
    /** main **/
    public static void main(String[] args) {
        double[] colors1 = {4.5,5,4};
        double[] colors2 = {6,5,10};
        Colorcheck colorcheck1 = new Colorcheck(colors1);
        Colorcheck colorcheck2 = new Colorcheck(colors2);
        System.out.println(colorcheck1.minColor());
        System.out.println(colorcheck2.minColor());
        System.out.println(colorcheck1.minColor());
    }
}