public class Main {
    
    /** main **/
    public static void main(String[] args) {
        double[] colors = {6,5,4};
        Colorcheck colorcheck = new Colorcheck();
        Shape shape = new Shape();
        double[] calorie =shape.calorie_calc(0, 0, 0, 2600);

        System.out.println(calorie[0]+" "+calorie[1]);

        System.out.println(colorcheck.minColor(colors,0));
        colors = newColors(5,5,10);
        System.out.println(colorcheck.minColor(colors,0));
        colors = newColors(0,5,1);
        System.out.println(colorcheck.minColor(colors,0));

        Colorcheck.printList();
        
        Colorcheck.initializeList(0);
        Colorcheck.printList();

        System.out.println(colorcheck.salt(0, 7));
        System.out.println(colorcheck.salt(0, 8));
        System.out.println(colorcheck.salt(0, 9));
    }

    public static double[] newColors(double r,double g, double y){
        double[] colors = {r,g,y};
        return colors;
    }
}