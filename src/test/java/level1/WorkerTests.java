package level1;

import org.testng.annotations.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WorkerTests {
    @ParameterizedTest
    @CsvSource({
            "10,5",
            "2,4",
            "8,9",
            "5,5"
    })
    public void onlineWorkerSalaryTest(int priceHour, int hours)
    {
        OnlineWorker onlineWorker = new OnlineWorker("Pedro","García",priceHour);
        double salaryOnline = onlineWorker.calculateSalary(hours);
        Assertions.assertEquals(salaryOnline,(priceHour*hours)+ OnlineWorker.internetPrice);
    }

    @ParameterizedTest
    @CsvSource({
            "10,5,10",
            "2,4,8",
            "8,9,15",
            "5,5,2"
    })
    public void inPersonWorkerSalaryTest(int priceHour, int hours, int fuel)
    {
        InPersonWorker.fuel = fuel;
        InPersonWorker inPersonWorker = new InPersonWorker("Artur","Viader",priceHour);
        double salaryInPerson = inPersonWorker.calculateSalary(hours);
        Assertions.assertEquals(salaryInPerson,(priceHour*hours)+ fuel);
    }
}
