package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.CandidateService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Messages;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.core.utilities.SuccessResult;
import seylim.seynet.dataAccess.abstracts.CandidateDao;
import seylim.seynet.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Candidate candidate) {
        return null;
    }

    @Override
    public Result delete(int id) {
        this.candidateDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return null;
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return null;
    }

    @Override
    public DataResult<Candidate> getByNationalIdNumber(int nationalIdNumber) {
        return null;
    }
}
