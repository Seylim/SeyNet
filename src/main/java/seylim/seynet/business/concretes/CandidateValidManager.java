package seylim.seynet.business.concretes;

import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.CandidateValidService;
import seylim.seynet.core.business.BusinessRules;
import seylim.seynet.core.utilities.ErrorResult;
import seylim.seynet.core.utilities.Messages;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.core.utilities.SuccessResult;
import seylim.seynet.entities.concretes.Candidate;

@Service
public class CandidateValidManager implements CandidateValidService {
    @Override
    public Result validate(Candidate candidate) throws Exception {
        Result[] results = BusinessRules.run(
                checkFirstNameNotNull(candidate.getFirstName()),
                checkLastNameNotNull(candidate.getLastName()),
                checkNationalIdNotNull(candidate.getNationalIdNumber()),
                checkYearOfBirthNotNull(candidate.getYearOfBirth()),
                checkEmailNotNull(candidate.getEmail()),
                checkPasswordNotNull(candidate.getPassword())
        );
        for (Result result:results){
            if (!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }

    private Result checkFirstNameNotNull(String firstName){
        if (firstName == null){
            return new ErrorResult(Messages.firstNameNotNull);
        }
        return new SuccessResult();
    }

    private Result checkLastNameNotNull(String lastName){
        if (lastName == null){
            return new ErrorResult(Messages.lastNameNotNull);
        }
        return new SuccessResult();
    }

    private Result checkNationalIdNotNull(String nationalId){
        if (nationalId == null){
            return new ErrorResult(Messages.nationalIdNotNull);
        }
        return new SuccessResult();
    }

    private Result checkYearOfBirthNotNull(int yearOfBirth){
        if (yearOfBirth == 0){
            return new ErrorResult(Messages.yearOfBirtNotNull);
        }
        return new SuccessResult();
    }

    private Result checkEmailNotNull(String email){
        if (email == null){
            return new ErrorResult(Messages.emailNotNull);
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
