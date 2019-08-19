public class Average{
    public double ave_calorie;
    public double ave_protein;
    public double ave_lipid;
    public double ave_carbohydrate;
    public double ave_salt;
    public double ave_red;
    public double ave_green;
    public double ave_yellow;
    public int start;

    Average(double ave_calorie,double ave_protein,double ave_lipid,double ave_carbohydrate,double ave_salt,double ave_red,double ave_green,double ave_yellow,int start){
    this.ave_calorie = ave_calorie;
    this.ave_protein = ave_protein;
    this.ave_lipid = ave_lipid;
    this.ave_carbohydrate = ave_carbohydrate;
    this.ave_salt = ave_salt;
    this.ave_red = ave_red;
    this.ave_green = ave_green;
    this.ave_yellow = ave_yellow;
    this.start = start;
    }
}