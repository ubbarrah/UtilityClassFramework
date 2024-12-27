public class Date {
    
    private int day;
    private int month;
    private int year;

    private final int maxYear = 2200;
    private final int minYear = 1800;
    private final int minMonth = 1;
    private final int maxMonth = 12;
    private final int minDay = 1;
    private int maxDay;


    public Date(int day, int month, int year){
        maxDay = daysPerMonth(month);

        if (day <= minDay){
            this.day = minDay;
        } else if (day >= maxDay) {
            this.day = maxDay;
        } else {
            this.day = day;
        }

        if (month <= minMonth){
            this.month = minMonth;
        } else if (month >= maxMonth) {
            this.month = maxMonth;
        } else {
            this.month = month;
        }

        if (year <= minYear){
            this.year = minYear;
        } else if (year >= maxYear) {
            this.year = maxYear;
        } else {
            this.year = year;
        }



    }
    
    //getters for day, month, year
    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    //setters for day, month, and year
    public void setDay(int day){
        if ((minDay <= day) && (day <= maxDay)){
            this.day = day;
        }
    }
    public void setMonth(int month){
        if ((minMonth <= month) && (month <= maxMonth)){
            this.month = month;
            maxDay = daysPerMonth(getMonth());
        }
    }
    public void setYear(int year){
        if ((minYear <= year) && (year <= maxYear)){
            this.year = year;
        }
    }


    //Checks to see how many days are in the month given as input
    public int daysPerMonth(int month){
        if ((month == 9) || (month == 4) || (month == 6) || (month == 11)){
            return 30;
        }
        else if ((month == 2)){
            return 28;
        }
        return 31;
    }

    //Checks to see the comparison between the current date and the date passed in as input
    public boolean sameEffectiveDayAs(Date date){
        if ((getDay() == date.getDay()) && (getYear() == date.getYear()) && (getMonth() == date.getMonth())) {
            return true;                
        } else if ((getDay() == daysPerMonth(getMonth())) && (getDay() < date.getDay())){
            return true;
        } 
        return false;
    }

    public void incrementDate(){
        if (getDay() == daysPerMonth(getMonth())){
            this.setDay(1);
            if (getMonth() == 12){
                this.setYear(getYear() + 1);
                this.setMonth(1);
            } else {
            this.setMonth(getMonth() + 1);
            }
            maxDay = this.daysPerMonth(getMonth());
        } else {
            this.setDay(getDay() + 1);
        }
        
        
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Date){
            Date date = (Date)o;
            return (this.getDay() == date.getDay() && this.getMonth() == date.getMonth());
        }
        return false;
    }

    @Override
    public String toString(){
        if (getMonth() == 1){
            return "January " + getDay() + ", " + getYear() + " maxday: ";
        }
        if (getMonth() == 2){
            return "February " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 3){
            return "March " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 4){
            return "April " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 5){
            return "May " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 6){
            return "June " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 7){
            return "July " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 8){
            return "August " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 9){
            return "September " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 10){
            return "October " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        if (getMonth() == 11){
            return "November " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        }
        //if (getMonth() == 12){
        return "December " + getDay() + ", " + getYear() + " maxday: "+this.daysPerMonth(getMonth());
        


       
    }


}
