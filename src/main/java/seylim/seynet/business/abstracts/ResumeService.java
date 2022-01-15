package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Resume;
import seylim.seynet.entities.dtos.ResumeWithAllRelatedEntitiesDto;

import java.util.List;

public interface ResumeService extends BaseEntityService<Resume>{

    DataResult<Resume> getByCandidate_Id(int candidateId);

    DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByCandidate();

    DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);
}
