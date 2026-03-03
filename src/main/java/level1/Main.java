package level1;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Definim el valor de betzina a 10 comú per tots els treballadors presencials.");
        InPersonWorker.fuel = 10;
        System.out.println("Definim un treballador presencial anomenat Artur Viader amb un preu hora de 20.");
        InPersonWorker inPersonWorker = new InPersonWorker("Artur","Viader",20);
        System.out.println("Definim un treballador online anomenat Pedro García amb un preu hora de 10.");
        System.out.println("El valor del preu de internet està estipulat a 10 a la classe. No es pot modificar perque es final i és comú a tots els treballadors online perquè és static.");
        OnlineWorker onlineWorker = new OnlineWorker("Pedro","García",10);
        double salaryInPerson = inPersonWorker.calculateSalary(10);
        System.out.println("El salari del treballador presencial que ha treballat 10 hores és " + Double.toString(salaryInPerson));
        double salaryOnline = onlineWorker.calculateSalary(10);
        System.out.println("El salari del treballador online que ha treballat 10 hores és " + Double.toString(salaryOnline));
        @SuppressWarnings("deprecation")
        double salaryInPersonWithoutFuel = inPersonWorker.calculateSalaryWithoutFuel(10);
        System.out.println("El salari del treballador online sense comptar la betzina (mètode obsolet) és de " + Double.toString(salaryInPersonWithoutFuel));
        @SuppressWarnings("deprecation")
        double salaryOnlineWithoutInternet = onlineWorker.calculateSalaryWithoutInternet(10);
        System.out.println("El salari del treballador presencial sense comptar el preu de internet (mètode obsolet) és de " + Double.toString(salaryOnlineWithoutInternet));
    }
}
