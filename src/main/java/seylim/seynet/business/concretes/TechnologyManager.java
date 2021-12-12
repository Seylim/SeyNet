package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.TechnologyService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.TechnologyDao;
import seylim.seynet.entities.concretes.Technology;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao){
        this.technologyDao = technologyDao;
    }

    @Override
    public Result add(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.technologyDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Technology> getById(int id) {
        return new SuccessDataResult<Technology>(this.technologyDao.getById(id), Messages.dataListed);
    }
}
