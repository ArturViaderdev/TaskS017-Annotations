package level1;

public class OnlineWorker extends Worker{
    private static final double internetPrice = 10;

    public OnlineWorker(String name, String surname, double priceHour) {
        super(name, surname, priceHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return (hours*priceHour) + internetPrice;
    }

    @Deprecated
    public double calculateSalaryWithoutInternet(int hours)
    {
        return hours*priceHour;
    }
}
