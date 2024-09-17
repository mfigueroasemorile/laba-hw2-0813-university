package reflection;

import java.lang.reflect.Field;

public class Reflection {

    public static void main(String[] args) throws Exception {

        Class <?> studentClass = Class.forName("model.Student");

        Field[] fields = studentClass.getDeclaredFields();
        for(Field field : fields){
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Modifiers: " + field.getModifiers());
        }
    }
}
