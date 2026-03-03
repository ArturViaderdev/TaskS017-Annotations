package level1;

public abstract class Worker {
    protected String name;
    protected String surname;
    protected double priceHour;

    public abstract double calculateSalary(int hours);

    public Worker(String name, String surname, double priceHour) {
        this.name = name;
        this.surname = surname;
        this.priceHour = priceHour;
    }
}
