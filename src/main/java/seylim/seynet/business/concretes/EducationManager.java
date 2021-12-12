package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.EducationService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.EducationDao;
import seylim.seynet.entities.concretes.Education;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao){
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.educationDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Education> getById(int id) {
        return new SuccessDataResult<Education>(this.educationDao.getById(id),Messages.dataListed);
    }

    @Override
    public DataResult<List<Education>> getByResume_Id(int resumeId) {
        return new SuccessDataResult<List<Education>>(this.educationDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");
        return new SuccessDataResult<List<Education>>(this.educationDao.getByResume_Id(resumeId, sort));
    }
}
