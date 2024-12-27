public class Customer {
    
    private Date customerDate;
    private Utility customerElectricUtility;
    private WaterUtility customerWaterUtility;
    private GasUtility customerGasUtility;

    public Customer(Date customerDate){

    }

    public Customer(Date customerDate, Utility customerElectricUtility, WaterUtility customWaterUtility, GasUtility customerGasUtility){


    }
    //Returns the customer's utility
    //WHAT IF THE CUSTOMER HAS NO UTILITY?
    public Utility getElectricUtility(){
        return customerElectricUtility;
    }

    //Sets the customer's electric utility to the desired new electric utility
    public void setElectricUtility(Utility newCustomerElectricUtility){
        this.customerElectricUtility = newCustomerElectricUtility;
    }
    
    //Sets the customer's water utility to the desired new water utility
    public void setWaterUtility(WaterUtility newCustomerWaterUtility){
        this.customerWaterUtility = newCustomerWaterUtility;
    }
    
    //Returns the customer's water utility
    public WaterUtility getWaterUtility(){
        return customerWaterUtility;
    }

    //Returns the customer's gas utility
    public GasUtility getGasUtility(){
        return customerGasUtility;
    }

    //Sets the customer's gas utility to the desired new gas utility
    public void setGasUtility(GasUtility newCustomerGasUtility){
        this.customerGasUtility = newCustomerGasUtility;
    } 

    //Returns the date associated with this customer
    public Date getDate(){
        return this.customerDate;
    }


    //Increments the date associated with the customer while running the according processing on the new date for the customer.
    public void incrementDate(){
        customerDate.incrementDate();
        if (customerDate.sameEffectiveDayAs(customerElectricUtility.getAnniversaryDate())){
            customerElectricUtility.endOfMonthProcessing();
        }
        if (customerDate.sameEffectiveDayAs(customerWaterUtility.getAnniversaryDate())){
            customerWaterUtility.endOfMonthProcessing();
        }
        if (customerDate.sameEffectiveDayAs(customerGasUtility.getAnniversaryDate())){
            customerGasUtility.endOfMonthProcessing();
        }
        if (customerDate.equals(customerElectricUtility.getAnniversaryDate())){
            customerElectricUtility.endOfYearProcessing();
        }
        if (customerDate.equals(customerWaterUtility.getAnniversaryDate())){
            customerWaterUtility.endOfYearProcessing();
        }
        if (customerDate.equals(customerGasUtility.getAnniversaryDate())){
            customerGasUtility.endOfYearProcessing();
        }
    }
}
