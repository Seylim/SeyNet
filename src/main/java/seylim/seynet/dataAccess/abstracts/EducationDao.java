package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Education;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> getByResume_Id(int resumeId);

    List<Education> getByResume_Id(int resumeId, Sort sort);
}
