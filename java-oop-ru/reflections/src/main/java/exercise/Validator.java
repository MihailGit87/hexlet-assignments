package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address1) {
        List<String> notValidateFields = new ArrayList<>();
        Field[] addressField = address1.getClass().getDeclaredFields();
        for (Field field : addressField) {
            String fieldValue = null;
            NotNull fieldAnnotation = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                fieldValue = (String) field.get(address1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldAnnotation != null && fieldValue == null) {
                notValidateFields.add(field.getName());
            }
        }
        return notValidateFields;
    }
}
// END
