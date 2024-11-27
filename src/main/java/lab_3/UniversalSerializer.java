package lab_3;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

// Клас для серіалізації та десеріалізації у різних форматах
public class UniversalSerializer<T> implements EntitySerializer<T> {
    private final ObjectMapper jsonMapper = new ObjectMapper(); // Для JSON
    private final XmlMapper xmlMapper = new XmlMapper();       // Для XML
    private final YAMLMapper yamlMapper = new YAMLMapper();   // Для YAML

    private final String format; // Зберігаємо формат для вибору

    // Конструктор, що приймає формат (JSON, XML, YAML)
    public UniversalSerializer(String format) {
        this.format = format;
    }

    @Override
    public void serialize(T entity, File file) throws IOException {
        switch (format.toLowerCase()) {
            case "json":
                jsonMapper.writeValue(file, entity);
                break;
            case "xml":
                xmlMapper.writeValue(file, entity);
                break;
            case "yaml":
                yamlMapper.writeValue(file, entity);
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

    @Override
    public T deserialize(File file, Class<T> clazz) throws IOException {
        switch (format.toLowerCase()) {
            case "json":
                return jsonMapper.readValue(file, clazz);
            case "xml":
                return xmlMapper.readValue(file, clazz);
            case "yaml":
                return yamlMapper.readValue(file, clazz);
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}
