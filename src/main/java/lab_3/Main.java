package lab_3;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Створення об'єкта для серіалізації
        Group group = new Group("101", 2024, "Computer Science", "John", "Doe");

        // Створення універсального серіалізатора для JSON
        UniversalSerializer<Group> jsonSerializer = new UniversalSerializer<>("json");

        // Серіалізація в JSON
        File jsonFile = new File("group.json");
        jsonSerializer.serialize(group, jsonFile);

        // Десеріалізація з JSON
        Group deserializedGroupJson = jsonSerializer.deserialize(jsonFile, Group.class);
        System.out.println("Deserialized from JSON: " + deserializedGroupJson);

        // Тепер для XML
        UniversalSerializer<Group> xmlSerializer = new UniversalSerializer<>("xml");
        File xmlFile = new File("group.xml");
        xmlSerializer.serialize(group, xmlFile);
        Group deserializedGroupXml = xmlSerializer.deserialize(xmlFile, Group.class);
        System.out.println("Deserialized from XML: " + deserializedGroupXml);

        // Тепер для YAML
        UniversalSerializer<Group> yamlSerializer = new UniversalSerializer<>("yaml");
        File yamlFile = new File("group.yaml");
        yamlSerializer.serialize(group, yamlFile);
        Group deserializedGroupYaml = yamlSerializer.deserialize(yamlFile, Group.class);
        System.out.println("Deserialized from YAML: " + deserializedGroupYaml);
    }
}
