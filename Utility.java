public class Utility {
    
    //automatic setting of variables
    private double utilityRate = 0;
    private int monthUsage = 0;
    private int yearUsage = 0;
    private double monthBill = 0;
    private double balance = 0;
    private double amountPaidThisMonth = 0;
    private double amountDelinquent = 0;
    private Date anniversaryDate;
    private static double salesTaxRate = .15;
    private static double interestRate = .1;

    //construct an instance of the Utility class with the desired values of utilityRate and anniversaryDate
    public Utility(double utilityRate, Date anniversaryDate){

        this.utilityRate = utilityRate;
        this.anniversaryDate = anniversaryDate;
    }




    //GETTERS ------------------------

    //Retrieves the variable utilityRate
    public double getUtilityRate(){
        return utilityRate;
    }
    
    //Returns the value monthUsage for the utility
    public int getMonthUsage(){
        return monthUsage;
    } 
    
    //Retrieves the yearUsage value for the utility
    public int getYearUsage(){
        return yearUsage;
    } 

    //Returns the billing amount for the month
    public double getMonthBill(){
        return monthBill;
    }

    //Returns the account balance for the utility
    public double getBalance(){
        return balance;
    }

    //Returns the amount paid this month for the utility
    public double getAmountPaidThisMonth(){
        return amountPaidThisMonth;
    }

    //Returns the amount delinquent for the utility
    public double getAmountDelinquent(){
        return amountDelinquent;
    }

    //Returns the annivesary date for the utilty
    public Date getAnniversaryDate(){
        return this.anniversaryDate;
    }

    //Returns the interest Rate of all instances of the utility class 
    public static double getInterestRate(){
        return interestRate;
    }

    //Returns the sales tax rate used by all instances of utility in the class
    public static double getSalesTaxRate(){
        return salesTaxRate;
    }

    //Returns the monthlyCharge which is equal to the monthUsage * utilityRate
    public double getMonthlyCharge(){
        return utilityRate * monthUsage;
    }

    //SETTERS ------------------------

    //sets the utilityrate to the input passed into the method
    public void setUtilityRate(double utilityRate){
        this.utilityRate = utilityRate;
    } 

    //sets the monthUsage to the input passed into the method
    public void setMonthUsage(int monthUsage){
        this.monthUsage = monthUsage;
    } 

     //Sets the billing amount for the month to the amount passed in
    public void setMonthBill(double monthbill){
        this.monthBill = monthbill;
    } 

    //Sets the amount delinquent to the value passed into the function
    public void setAmountDelinquent(double amountDelinquent){
        this.amountDelinquent = amountDelinquent;
    }

    //Changes the anniversary date to the value passed into the function
    public void setAnniversaryDate(Date newAnniversaryDate){
        this.anniversaryDate = newAnniversaryDate;
    }

    //Sets the interest rate for the entire class to the value passed into the function.
    public static void setInterestRate(double newInterestRate){
        interestRate = newInterestRate;

    }

    //Sets the sales tax rate for the entire class to a new value passed into the function.
    public static void setSalesTaxRate(double newSalesTaxRate){
        salesTaxRate = newSalesTaxRate;
    }

    //UPDATE FUNCTIONS ------------------------

    //Increases, not sets, the yearUsage by the value passed into the function.
    public void updateYearUsage(int yearUsageIncrease){
        this.yearUsage += yearUsageIncrease;
    }

    //Increases, not sets, the balance of the account on the utility
    public void updateBalance(double balanceIncrease){
        this.balance += balanceIncrease;
    }

    //Increases the amountPaidThisMonth variable by the specified amount passed into the function.
    public void updateAmountPaidThisMonth(double amountPaidThisMonthIncrease){
        amountPaidThisMonth += amountPaidThisMonthIncrease;
    } 

    
    //UTILITY FUNCTIONS ------------------------


    public void makePayment(double balanceDecrease){
        this.balance -= balanceDecrease;
        amountPaidThisMonth += balanceDecrease;
    }

    
    
    /*Handles the end of month processing, setting up the utility finances for the next month by doing the following steps.
    1. Changes Balance amount to the monthly charge multiplied by the tax rate
    2. Adds the money not paid back to the delinquent while factoring in sales tax if delinquent is positive
    3. Updates the monthly bill to the new balance
    4. Resets the amount paid this month to 0. the Increases the delinquent amount by*/
    public void endOfMonthProcessing(){
        updateBalance(getMonthlyCharge() + (getMonthlyCharge() * getSalesTaxRate()));
        if (getAmountPaidThisMonth() < getMonthBill()){
            setAmountDelinquent(getAmountDelinquent()+(getMonthBill()-getAmountPaidThisMonth()));
        } else if (getAmountPaidThisMonth() > getMonthBill()){
            setAmountDelinquent(getAmountDelinquent()-(getAmountPaidThisMonth()-getMonthBill()));
        }
        if (getAmountDelinquent() > 0){ 
            //public final double temporaryDelinquentTax = (getAmountDelinquent() * getInterestRate());
            final double tempDelinquentRate = (getAmountDelinquent() * getInterestRate());
            setAmountDelinquent(getAmountDelinquent() + (tempDelinquentRate));
            updateBalance((tempDelinquentRate));
        }
        setMonthBill(getBalance());
        updateAmountPaidThisMonth(-getAmountPaidThisMonth());

    }

    //Resets the year usage to 0 at the end of year.
    public void endOfYearProcessing(){
        updateYearUsage(-getYearUsage());
    }


}
