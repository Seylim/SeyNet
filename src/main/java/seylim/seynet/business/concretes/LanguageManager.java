package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.LanguageService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.LanguageDao;
import seylim.seynet.entities.concretes.Language;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.languageDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<Language>(this.languageDao.getById(id), Messages.dataListed);
    }
}
