package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService extends BaseEntityService<JobPosition> {
    DataResult<List<JobPosition>> getAllByIsActive(boolean isActive);

    DataResult<List<JobPosition>> getAllActiveOnesByPage(int pageNo, int pageSize);

    DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDate();

    DataResult<List<JobPosition>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize);

    DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDateTop6();

    DataResult<List<JobPosition>> getAllActiveOnesByEmployerIdSortedByPostingDate(int employerId);

    DataResult<List<JobPosition>> getAllActiveOnesFilteredByCityAndJobTitle(int cityId, int jobTitleId);

    DataResult<List<JobPosition>> getAllActiveOnesByPageFilteredByCityAndJobTitle(int cityId, int jobTitleId, int pageNo, int pageSize);
}
