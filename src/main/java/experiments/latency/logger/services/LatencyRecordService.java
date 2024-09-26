package experiments.latency.logger.services;

import experiments.latency.logger.dtos.LatencyRecordDTO;
import experiments.latency.logger.entities.LatencyRecord;
import experiments.latency.logger.repositories.LatencyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LatencyRecordService {

    private final LatencyRecordRepository latencyRecordRepository;

    @Autowired
    public LatencyRecordService(LatencyRecordRepository latencyRecordRepository) {
        this.latencyRecordRepository = latencyRecordRepository;
    }

    public LatencyRecordDTO create(LatencyRecordDTO dto) {
        LatencyRecord record = dto.toEntity();
        LatencyRecord savedRecord = latencyRecordRepository.save(record);
        return LatencyRecordDTO.fromEntity(savedRecord);
    }

    public void createAll(List<LatencyRecordDTO> dtos) {
        List<LatencyRecord> records = dtos.stream()
                .map(LatencyRecordDTO::toEntity)
                .collect(Collectors.toList());

        latencyRecordRepository.saveAll(records);
    }

    public List<LatencyRecordDTO> getAll() {
        return latencyRecordRepository.findAll().stream()
                .map(LatencyRecordDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<LatencyRecordDTO> getById(Long id) {
        return latencyRecordRepository.findById(id)
                .map(LatencyRecordDTO::fromEntity);
    }

    public boolean delete(Long id) {
        if (latencyRecordRepository.existsById(id)) {
            latencyRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
