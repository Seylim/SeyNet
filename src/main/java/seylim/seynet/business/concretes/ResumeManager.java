package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.ResumeService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.ResumeDao;
import seylim.seynet.entities.concretes.Resume;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao){
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.resumeDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(this.resumeDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<List<Resume>> getByCandidate_Id(int candidateId) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.getByCandidate_Id(candidateId));
    }
}
