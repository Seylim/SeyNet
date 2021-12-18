package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Candidate;

public interface CandidateService extends BaseEntityService<Candidate>{

    Result register(Candidate candidate) throws Exception;
    Result login(String eMail, String passwordAgain) throws Exception;
    DataResult<Candidate> getByNationalIdNumber(String nationalIdNumber);
}
