package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.EmployerService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.EmployerDao;
import seylim.seynet.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.employerDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.getById(id), Messages.dataListed);
    }
}
