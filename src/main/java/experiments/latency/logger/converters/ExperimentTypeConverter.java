package experiments.latency.logger.converters;

import experiments.latency.logger.enums.ExperimentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 *
 * @author Uellington Damasceno
 */
@Converter(autoApply = true)
public class ExperimentTypeConverter implements AttributeConverter<ExperimentType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ExperimentType attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public ExperimentType convertToEntityAttribute(Integer dbData) {
        return dbData != null ? ExperimentType.from(dbData) : null;
    }

}
