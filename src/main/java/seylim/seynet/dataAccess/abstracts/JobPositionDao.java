package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
}
