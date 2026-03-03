package level2And3;

public class Main {
    public static void main(String[] args)
    {
        //Level 2
        Worker worker = new Worker("Artur","Viader Mataix",30);
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String json = converter.convertToJson(worker);
        System.out.println(json);

        //Level 3
        Class<Worker> vclass = Worker.class;
        boolean present = vclass.isAnnotationPresent(JsonSerializable.class);
        if(present)
        {
            System.out.println("La anotació personalitzada està a Worker.");
            JsonSerializable annotation = vclass.getAnnotation(JsonSerializable.class);
            String fileName = annotation.fileName();
            System.out.println("Nom del fitxer =" + fileName);
        }

    }
}


