package lambda;


@FunctionalInterface
public interface Filter<T> {
    boolean apply(T entity);
}
