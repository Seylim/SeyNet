package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.CandidateService;
import seylim.seynet.business.abstracts.CandidateValidService;
import seylim.seynet.core.services.MernisService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.CandidateDao;
import seylim.seynet.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private CandidateValidService candidateValidService;
    private MernisService mernisService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CandidateValidService candidateValidService, MernisService mernisService) {
        this.candidateDao = candidateDao;
        this.candidateValidService = candidateValidService;
        this.mernisService = mernisService;
    }



    @Override
    public Result register(Candidate candidate) throws Exception {
        List<Candidate> candidates = this.candidateDao.findAll();
        if (this.mernisService.ifRealPerson(candidate)){
            if (checkIfUserExist(candidates, candidate).isSuccess()){
                if (this.candidateValidService.validate(candidate).isSuccess()){
                    this.candidateDao.save(candidate);
                    return new SuccessResult(Messages.registrationIsSuccessful);
                }
                return this.candidateValidService.validate(candidate);
            }
        }
        return new ErrorResult(Messages.informationIsIncorrect);
    }

    @Override
    public Result login(Candidate candidate, String passwordAgain) throws Exception {
        List<Candidate> candidates = this.candidateDao.findAll();
        for (Candidate dbCandidate: candidates){
            if (dbCandidate.getEmail().equals(candidate.getEmail())){
                if (dbCandidate.getPassword().equals(candidate.getPassword())){
                    return new SuccessResult(Messages.loginIsSuccessful);
                }
            }
        }
        return new ErrorResult(Messages.informationIsIncorrect);
    }

    @Override
    public Result add(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Candidate candidate)
    {
        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.candidateDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<Candidate> getByNationalIdNumber(String nationalIdNumber) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByNationalIdNumber(nationalIdNumber));
    }

    private Result checkIfUserExist(List<Candidate> candidates, Candidate checkCandidate){
        for (Candidate candidate : candidates){
            if (candidate.getEmail().equals(checkCandidate.getEmail())){
                return new ErrorResult(Messages.registeredEmail);
            }
            if (candidate.getNationalIdNumber().equals(checkCandidate.getNationalIdNumber())){
                return new ErrorResult(Messages.registeredID);
            }
        }
        return new SuccessResult();
    }
}
