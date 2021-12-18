package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.JobPositionService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.JobPositionDao;
import seylim.seynet.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.jobPositionDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id), Messages.dataListed);
    }
}
