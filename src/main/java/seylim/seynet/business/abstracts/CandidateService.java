package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Candidate;

public interface CandidateService extends BaseEntityService<Candidate>{

    DataResult<Candidate> getByNationalIdNumber(String nationalIdNumber);
}
