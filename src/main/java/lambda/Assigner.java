package lambda;

@FunctionalInterface
public interface Assigner<T, U> {
    void assign (T resource, U recipient);
}
