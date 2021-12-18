package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.JobTitleService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.JobTitleDao;
import seylim.seynet.entities.concretes.JobTitle;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao){
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.jobTitleDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<JobTitle> getById(int id) {
        return new SuccessDataResult<JobTitle>(this.jobTitleDao.getById(id), Messages.dataListed);
    }
}
