package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Experience;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

    List<Experience> getByResume_Id(int resumeId);

    List<Experience> getByResume_Id(int resumeId, Sort sort);
}
