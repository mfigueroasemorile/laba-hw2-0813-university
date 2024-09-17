package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionService {

    public void getFields(Class <?> studentClass){
        Field[] fields = studentClass.getDeclaredFields();
        System.out.println("Fields:\n");
        for(Field field : fields){
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Modifiers: " + field.getModifiers());
            System.out.println("----------------------------------------");
        }
    }

    public void getConstructor(Class <?> studentClass){
        Constructor<?>[] studentConstructors = studentClass.getConstructors();
        System.out.println("Constructors:\n");
        for (Constructor<?> constructor : studentConstructors){
            System.out.println("Constructor name: " + constructor.getName());
            System.out.println("Constructor params: ");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> paramType : parameterTypes) {
                System.out.println("\tType: " + paramType.getName());
            }
        }
    }

    public void getMethods(Class<?> studentClass){
        Method[] studentMethods = studentClass.getMethods();
        System.out.println("Methods:\n");
        for(Method method : studentMethods){
            System.out.println("Name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Parameters: ");
            for(Class<?> param : method.getParameterTypes()){
                System.out.println("\t type: " + param.getName());
            }

        }
    }
}
