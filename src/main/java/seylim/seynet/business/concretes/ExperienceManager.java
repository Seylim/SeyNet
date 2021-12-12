package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.ExperienceService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.ExperienceDao;
import seylim.seynet.entities.concretes.Experience;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao){
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.experienceDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Experience> getById(int id) {
        return new SuccessDataResult<Experience>(this.experienceDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<List<Experience>> getByResume_Id(int resumeId) {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "terminationDate");
        return new SuccessDataResult<List<Experience>>(this.experienceDao.getByResume_Id(resumeId, sort), Messages.dataListed);
    }
}
