package experiments.latency.logger.converters;

import experiments.latency.logger.enums.ExperimentLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 *
 * @author Uellington Damasceno
 */
@Converter(autoApply = true)
public class ExperimentLevelConverter implements AttributeConverter<ExperimentLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ExperimentLevel attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public ExperimentLevel convertToEntityAttribute(Integer dbData) {
        return dbData != null ? ExperimentLevel.from(dbData) : null;
    }

}
