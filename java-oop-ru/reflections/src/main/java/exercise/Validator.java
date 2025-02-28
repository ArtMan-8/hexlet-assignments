package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException error) {
                    error.printStackTrace();
                }
            }
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        result.put(field.getName(), new ArrayList<String>(List.of("can not be null")));
                    }
                } catch (IllegalAccessException error) {
                    error.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    field.setAccessible(true);
                    if (
                        field.get(address) != null &&
                        field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()
                    ) {
                        result.put(field.getName(), new ArrayList<String>(List.of("length less than " + field.getAnnotation(MinLength.class).minLength())));
                    }
                } catch (IllegalAccessException error) {
                    error.printStackTrace();
                }
            }
        }

        return result;
    }
}
// END
