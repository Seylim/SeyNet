package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
}
