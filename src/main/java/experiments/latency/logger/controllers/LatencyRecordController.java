package experiments.latency.logger.controllers;

import experiments.latency.logger.dtos.LatencyRecordDTO;
import experiments.latency.logger.services.LatencyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/latency-records")
public class LatencyRecordController {

    private final LatencyRecordService latencyRecordService;

    @Autowired
    public LatencyRecordController(LatencyRecordService latencyRecordService) {
        this.latencyRecordService = latencyRecordService;
    }

    @PostMapping
    public ResponseEntity<LatencyRecordDTO> create(@RequestBody LatencyRecordDTO latencyRecordDTO) {
        LatencyRecordDTO createdRecord = latencyRecordService.create(latencyRecordDTO);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @PostMapping("/records")
    public ResponseEntity<Void> createAll(@RequestBody List<LatencyRecordDTO> records) {
        try {
            System.out.println("Salvando: " + records.size() + " registros");
            latencyRecordService.createAll(records);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<LatencyRecordDTO>> getAll() {
        List<LatencyRecordDTO> records = latencyRecordService.getAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = latencyRecordService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
