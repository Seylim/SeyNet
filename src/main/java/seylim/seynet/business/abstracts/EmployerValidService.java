package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Employer;

public interface EmployerValidService {
    Result validate(Employer employer) throws Exception;
}
