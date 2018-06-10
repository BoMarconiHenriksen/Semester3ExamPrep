package entities.messages;

/**
 *
 * @author bladt
 */
public interface JSONMessage<T> {
    public T toInternal();
}
