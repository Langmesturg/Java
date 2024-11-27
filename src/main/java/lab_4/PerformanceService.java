package lab_4;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PerformanceService {

    // Метод для обчислення середнього балу студента
    public Map<String, Double> calculateAverageGrade(List<Performance> performances) {
        return performances.stream()
                .collect(Collectors.groupingBy(
                        Performance::getSubject,
                        Collectors.averagingInt(Performance::getGrade)
                ));
    }
}
