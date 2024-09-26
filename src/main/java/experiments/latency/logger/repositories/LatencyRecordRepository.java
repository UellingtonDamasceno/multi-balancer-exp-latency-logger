package experiments.latency.logger.repositories;

import experiments.latency.logger.entities.LatencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Uellington Damasceno
 */
public interface LatencyRecordRepository extends JpaRepository<LatencyRecord, Long>{
    
}
