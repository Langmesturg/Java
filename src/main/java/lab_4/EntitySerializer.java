package lab_4;
import java.io.File;
import java.io.IOException;

public interface EntitySerializer<T> {
    void serialize(T entity, File file) throws IOException;
    T deserialize(File file, Class<T> clazz) throws IOException;
}
