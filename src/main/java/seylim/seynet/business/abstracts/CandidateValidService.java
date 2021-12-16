package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Candidate;

public interface CandidateValidService {
    Result validate(Candidate candidate) throws Exception;
}
