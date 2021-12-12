package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.CityService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.CityDao;
import seylim.seynet.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao=cityDao;
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(City city) {
        this.cityDao.save(city);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.cityDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),Messages.dataListed);
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.getById(id), Messages.dataListed);
    }
}
