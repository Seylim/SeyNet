package seylim.seynet.business.abstracts;

import org.springframework.data.domain.Sort;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Education;

import java.util.List;

public interface EducationService{

    DataResult<List<Education>> getByResume_Id(int resumeId);

    DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);
}
