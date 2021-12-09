package seylim.seynet.business.abstracts;

import org.springframework.data.domain.Sort;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {

    DataResult<List<Experience>> getByResume_Id(int resumeId);

    DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);
}
