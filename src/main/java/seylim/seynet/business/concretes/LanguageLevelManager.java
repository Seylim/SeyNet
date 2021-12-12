package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.LanguageLevelService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.LanguageLevelDao;
import seylim.seynet.entities.concretes.LanguageLevel;

import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao){
        this.languageLevelDao = languageLevelDao;
    }

    @Override
    public Result add(LanguageLevel languageLevel) {
        this.languageLevelDao.save(languageLevel);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(LanguageLevel languageLevel) {
        this.languageLevelDao.save(languageLevel);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.languageLevelDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(this.languageLevelDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<LanguageLevel> getById(int id) {
        return new SuccessDataResult<LanguageLevel>(this.languageLevelDao.getById(id), Messages.dataListed);
    }
}
