package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Candidate;
import seylim.seynet.entities.concretes.Employer;

public interface EmployerService extends BaseEntityService<Employer> {
    Result register(Employer employer) throws Exception;
    Result login(String eMail, String passwordAgain) throws Exception;
}
