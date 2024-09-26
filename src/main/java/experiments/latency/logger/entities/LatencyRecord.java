package experiments.latency.logger.entities;

import experiments.latency.logger.enums.ExperimentLevel;
import experiments.latency.logger.enums.ExperimentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Uellington Damasceno
 */
@Entity
public class LatencyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 39)
    private String deviceID;
    @Column(length = 39)
    private String sensorId;
    @Column(length = 39)
    private String brokerIp;

    private Integer experiment;
    private ExperimentType type;
    private ExperimentLevel level;
    private String message;
    private Long latency;

    @CreationTimestamp
    private Instant createdAt;
    
    public LatencyRecord(){}

    public LatencyRecord(String deviceID,
            String sensorId, 
            String brokerIp,
            Integer experiment,
            ExperimentType type,
            ExperimentLevel level,
            Long latency,
            String message) {

        this.deviceID = deviceID;
        this.experiment = experiment;
        this.type = type;
        this.level = level;
        this.latency = latency;
        this.message = message;
        this.sensorId = sensorId;
        this.brokerIp = brokerIp;
    }

    public static LatencyRecord of(String deviceID,
            String sensorId,
            String brokerIp,
            Integer experiment,
            ExperimentType type,
            ExperimentLevel level,
            Long latency,
            String message) {
        return new LatencyRecord(deviceID, sensorId, brokerIp, experiment, type, level, latency, message);
    }

    public String getBrokerIp() {
        return brokerIp;
    }

    public void setBrokerIp(String brokerIp) {
        this.brokerIp = brokerIp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public ExperimentType getType() {
        return type;
    }

    public void setType(ExperimentType type) {
        this.type = type;
    }

    public ExperimentLevel getLevel() {
        return level;
    }

    public void setLevel(ExperimentLevel level) {
        this.level = level;
    }

    public Integer getExperiment() {
        return experiment;
    }

    public void setExperiment(Integer experiment) {
        this.experiment = experiment;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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

}
