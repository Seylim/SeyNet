package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.SocialMediaNameService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.SocialMediaDao;
import seylim.seynet.dataAccess.abstracts.SocialMediaNameDao;
import seylim.seynet.entities.concretes.SocialMediaName;

import java.util.List;

@Service
public class SocialMediaNameManager implements SocialMediaNameService {

    private SocialMediaNameDao socialMediaNameDao;

    @Autowired
    public SocialMediaNameManager(SocialMediaNameDao socialMediaNameDao){
        this.socialMediaNameDao = socialMediaNameDao;
    }

    @Override
    public Result add(SocialMediaName socialMediaName) {
        this.socialMediaNameDao.save(socialMediaName);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(SocialMediaName socialMediaName) {
        this.socialMediaNameDao.save(socialMediaName);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.socialMediaNameDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<SocialMediaName>> getAll() {
        return new SuccessDataResult<List<SocialMediaName>>(this.socialMediaNameDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<SocialMediaName> getById(int id) {
        return new SuccessDataResult<SocialMediaName>(this.socialMediaNameDao.getById(id), Messages.dataListed);
    }
}
