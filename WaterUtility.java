public class WaterUtility extends Utility{
    
    //private double monthlyCharge;
    private int numBaths;
    private double bathFee;
    public WaterUtility(double utilityRate, Date anniversaryDate, int numBaths, double bathFee){
        //this.super(utilityRate, anniversaryDate);
        super(utilityRate, anniversaryDate);
        this.numBaths = numBaths;
        this.bathFee = bathFee;

    }


    //GETTERS ------------------------

    //adds the total cost of the baths (bath fee * rate per bath) to the original Utility class value of monthlycharge
    public double getMonthlyCharge(){
        return super.getMonthlyCharge() + this.bathFee*this.numBaths;
    }

    //returns the number of bathrooms for the waterutility class.
    public int getNumBaths(){
        return this.numBaths;
    }

    //Returns the fee amount for each bath on the water utility class
    public double getBathFee(){
        return this.bathFee;
    }



    //SETTERS ------------------------



    //Sets the number of baths for the utility to the input passed into the function.
    public void setNumBaths(int newNumBaths){
        this.numBaths = newNumBaths;
    }

    //Sets the fee amount for each bath to the value in the input
    public void setBathFee(int newBathFee){
        this.bathFee = newBathFee;
    }


}
