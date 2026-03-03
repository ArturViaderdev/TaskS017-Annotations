package level2And3;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {
    public String convertToJson(Object object)
    {
        try
        {
            Class<?> vclass = object.getClass();
            checkIfSerializable(object);
            initializeObject(object);
            String json = getJsonString(object);
            saveToFile(vclass, json);
            return getJsonString(object);
        } catch(Exception ex)
        {
            throw new JsonSerializationException(ex.getMessage());
        }


    }

    private void checkIfSerializable(Object object)
    {
        Class<?> vClass = object.getClass();
        if(!vClass.isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializationException("La classe no està anotada com a serializable.");
        }
    }

    private void initializeObject(Object object) throws Exception{
        Class<?> vclass = object.getClass();
        for(Method method: vclass.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> vclass = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : vclass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                JsonElement annotation = field.getAnnotation(JsonElement.class);
                String key = annotation.key().isEmpty()
                        ? field.getName()
                        : annotation.key();
                Object value = field.get(object);
                jsonElementsMap.put(key, value != null ? value.toString() : null);
            }

        }

        String jsonBody = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value == null) {
                        return "\"" + key + "\":null";
                    }
                    return "\"" + key + "\":\"" + value + "\"";
                })
                .collect(Collectors.joining(","));
        return "{" + jsonBody + "}";
    }

    public void saveToFile(Class<?> vclass, String json) throws IOException
    {
        JsonSerializable annotation = vclass.getAnnotation(JsonSerializable.class);
        String fileName = annotation.fileName();
        Path path = Paths.get(fileName);
        Files.writeString(path, json);
    }
}
