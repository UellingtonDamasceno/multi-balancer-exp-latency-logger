package experiments.latency.logger.dtos;

import experiments.latency.logger.entities.LatencyRecord;
import experiments.latency.logger.enums.ExperimentLevel;
import experiments.latency.logger.enums.ExperimentType;

/**
 *
 * @author Uellington Damasceno
 */
public class LatencyRecordDTO {

    private String deviceID;
    private Integer experiment;
    private Integer type;
    private Integer level;
    private Long latency;
    private String message;
    private String sensorId;
    private String brokerIp;

    public LatencyRecordDTO() {
    }

    public LatencyRecordDTO(String deviceID,
            String sensorId,
            String brokerIp,
            Integer experiment,
            Integer type,
            Integer level,
            Long latency,
            String message) {
        this.deviceID = deviceID;
        this.sensorId = sensorId;
        this.experiment = experiment;
        this.type = type;
        this.level = level;
        this.latency = latency;
        this.message = message;
        this.brokerIp = brokerIp;
    }

    public static LatencyRecordDTO fromEntity(LatencyRecord record) {
        LatencyRecordDTO dto = new LatencyRecordDTO();

        dto.deviceID = record.getDeviceID();
        dto.experiment = record.getExperiment();
        dto.type = record.getType().getValue();
        dto.level = record.getLevel().getValue();
        dto.latency = record.getLatency();
        dto.message = record.getMessage();
        dto.sensorId = record.getSensorId();
        dto.brokerIp = record.getBrokerIp();
        return dto;
    }

    public LatencyRecord toEntity() {
        ExperimentLevel levelEnum = ExperimentLevel.from(this.level);
        ExperimentType typeEnum = ExperimentType.from(this.type);
        return LatencyRecord.of(deviceID, sensorId, brokerIp, experiment, typeEnum, levelEnum, latency, message);
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getExperiment() {
        return experiment;
    }

    public void setExperiment(Integer experiment) {
        this.experiment = experiment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getBrokerIp() {
        return brokerIp;
    }

    public void setBrokerIp(String brokerIp) {
        this.brokerIp = brokerIp;
    }

}
