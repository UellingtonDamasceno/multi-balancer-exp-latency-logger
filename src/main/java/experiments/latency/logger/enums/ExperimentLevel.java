package experiments.latency.logger.enums;

import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 */
public enum ExperimentLevel {
    
    EASY(0),
    MEDDIUM(1),
    HARD(2);
    
    private final Integer value;
    
    private ExperimentLevel(Integer value){
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }

    public static ExperimentLevel from(Integer value) {
        return Stream.of(ExperimentLevel.values())
                .filter(v -> Objects.equals(v.getValue(), value))
                .findAny()
                .orElseThrow();
    }
}
