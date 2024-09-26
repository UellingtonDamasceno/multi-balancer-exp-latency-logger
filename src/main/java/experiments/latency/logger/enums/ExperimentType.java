package experiments.latency.logger.enums;

import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 */
public enum ExperimentType {
    WithoutBalance(0),
    SingleLayerBalance(1),
    MultiLayerBalance(2);

    private final Integer value;

    ExperimentType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static ExperimentType from(Integer value) {
        return Stream.of(ExperimentType.values())
                .filter(v -> v.getValue() == value)
                .findAny()
                .orElseThrow();
    }
}
