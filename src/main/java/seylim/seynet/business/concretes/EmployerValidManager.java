package seylim.seynet.business.concretes;

import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.EmployerValidService;
import seylim.seynet.core.business.BusinessRules;
import seylim.seynet.core.utilities.ErrorResult;
import seylim.seynet.core.utilities.Messages;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.core.utilities.SuccessResult;
import seylim.seynet.entities.concretes.Employer;

@Service
public class EmployerValidManager implements EmployerValidService {
    @Override
    public Result validate(Employer employer) throws Exception {
        Result[] results = BusinessRules.run(
                checkCompanyNameNotNull(employer.getCompanyName()),
                checkWebSiteNotNull(employer.getWebAdrress()),
                checkEmailNotNull(employer.getEmail()),
                checkPhoneNumberNotNull(employer.getPhoneNumber()),
                checkPasswordNotNull(employer.getPassword())
        );
        for (Result result:results){
            if (!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }

    private Result checkCompanyNameNotNull(String companyName){
        if (companyName == null){
            return new ErrorResult(Messages.companyNameNotNull);
        }
        return new SuccessResult();
    }

    private Result checkWebSiteNotNull(String webSite){
        if (webSite == null){
            return new ErrorResult(Messages.webSiteNotNull);
        }
        return new SuccessResult();
    }

    private Result checkEmailNotNull(String email){
        if (email == null){
            return new ErrorResult(Messages.emailNotNull);
        }
        return new SuccessResult();
    }

    private Result checkPhoneNumberNotNull(String phoneNumber){
        if (phoneNumber == null){
            return new ErrorResult(Messages.phoneNumberNotNull);
        }
        return new SuccessResult();
    }

    private Result checkPasswordNotNull(String password){
        if (password == null){
            return new ErrorResult(Messages.passwordNotNull);
        }
        return new SuccessResult();
    }
}
