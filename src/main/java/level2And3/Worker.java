package level2And3;
@JsonSerializable(fileName="worker.json")
public class Worker {
    @JsonElement
    private String name;
    @JsonElement
    private String surname;
    @JsonElement
    private double priceHour;
    @Init
    public Worker(String name, String surname, double priceHour) {
        this.name = name;
        this.surname = surname;
        this.priceHour = priceHour;
    }


}
