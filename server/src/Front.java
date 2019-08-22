public class Front{
    public String mainMenu;
    public String subMenu;
    public String donMenu;
    public String menMenu;
    public double ave_calorie;
    public double ave_protein;
    public double ave_lipid;
    public double ave_carbo;
    public double ave_salt;
    public double sleep_h;

    Front(String[] menu, double[] ave, double sleep_h){
        this.mainMenu = menu[0];
        this.subMenu = menu[1];
        this.menMenu = menu[2];
        this.donMenu = menu[3];
        this.ave_calorie = ave[0];
        this.ave_protein = ave[1];
        this.ave_lipid = ave[2];
        this.ave_carbo = ave[3];
        this.ave_salt = ave[4];
        this.sleep_h = sleep_h;
    }
}