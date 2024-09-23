package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionMain {

    public static void main(String[] args) throws Exception {

        Class <?> studentClass = Class.forName("model.Student");

        ReflectionService reflectionService = new ReflectionService();
        reflectionService.getFields(studentClass);
        reflectionService.getConstructor(studentClass);
        reflectionService.getMethods(studentClass);

        Constructor<?> studentConstructor = studentClass.getConstructor(String.class, String.class);
        Object student = studentConstructor.newInstance("123","Maxi");

        System.out.println(student);
        System.out.println("After method invocation:\n");

        Method setNameMethod = studentClass.getMethod("setFirstName", String.class);
        setNameMethod.invoke(student, "Charlie");
        System.out.println(student);

    }
}
