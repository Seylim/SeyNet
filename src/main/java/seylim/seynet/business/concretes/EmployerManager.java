package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.EmployerService;
import seylim.seynet.business.abstracts.EmployerValidService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.EmployerDao;
import seylim.seynet.entities.concretes.Candidate;
import seylim.seynet.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmployerValidService employerValidService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerValidService employerValidService){
        this.employerDao = employerDao;
        this.employerValidService = employerValidService;
    }

    @Override
    public Result register(Employer employer) throws Exception {
        List<Employer> employers = employerDao.findAll();
        if (checkIfUserExist(employers, employer).isSuccess()){
            if (this.employerValidService.validate(employer).isSuccess()){
                this.employerDao.save(employer);
                return new SuccessResult(Messages.registrationIsSuccessful);
            }
            return new ErrorResult(Messages.informationIsIncorrect);
        }
        return checkIfUserExist(employers, employer);
    }

    @Override
    public Result login(String eMail, String passwordAgain) throws Exception {
        List<Employer> employers = this.employerDao.findAll();
        for (Employer dbEmployer: employers){
            if (dbEmployer.getEmail().equals(eMail)){
                if (dbEmployer.getPassword().equals(passwordAgain)){
                    return new SuccessResult(Messages.loginIsSuccessful);
                }
            }
        }
        return new ErrorResult(Messages.informationIsIncorrect);
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

    private Result checkIfUserExist(List<Employer> employers, Employer checkEmployer){
        for (Employer employer : employers){
            if (employer.getEmail().equals(checkEmployer.getEmail())){
                return new ErrorResult(Messages.registeredEmail);
            }
        }
        return new SuccessResult();
    }
}
