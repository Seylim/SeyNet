package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    List<JobPosition> getByIsActive(boolean isActive);

    List<JobPosition> getByIsActive(boolean isActive, Sort sort);

    List<JobPosition> getByIsActive(boolean isActive, Pageable pageable);

    List<JobPosition> getByIsActiveAndEmployer_Id(boolean isActive, int employerId, Sort sort);
}
