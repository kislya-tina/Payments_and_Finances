package Finance;

public class Date {

    private int year;
    private int month;
    private int day;


    public Date(){
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    // TODO: 3/17/2022
    // исВалидДате переделано вроде как норм
    public Date(int year, int month, int day) {
        if(!isValidDate(year, month, day)){
            throw new IllegalArgumentException("Incorrect date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static boolean isValidDate(int year, int month, int day) {

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthLeapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean leap = true;

        if (((year % 4 == 0) && (year % 100) != 0) || (year % 400 == 0)) {//проверка на високосность
            leap = false;
        } else if (!(year >= 1970)) {
            throw new IllegalArgumentException("Incorrect year");
        }

        if (1 <= month && month <= 12) {
            throw new IllegalArgumentException("Incorrect month");
        }

        if(!(!leap && monthDays[month - 1] >= day)){
            throw new IllegalArgumentException("Incorrect day");
        }

        if(!(leap && monthLeapDays[month - 1] >= day)){
            throw new IllegalArgumentException("Incorrect day");
        }

        return true;
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Date)
            return getDay() == ((Date) obj).getDay() && getMonth() == ((Date) obj).getMonth()
                    && getYear() == ((Date) obj).getYear();
        return false;
    }

    @Override
    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }
}