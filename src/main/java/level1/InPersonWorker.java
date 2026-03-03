package level1;

public class InPersonWorker extends Worker {
    static public int  fuel;

    public InPersonWorker(String name, String surname, double priceHour) {
        super(name, surname, priceHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return (hours*priceHour)+fuel;

    }

    @Deprecated
    public double calculateSalaryWithoutFuel(int hours)
    {
        return hours*priceHour;
    }
}
