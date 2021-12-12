package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.SocialMediaService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.SocialMediaDao;
import seylim.seynet.entities.concretes.SocialMedia;

import java.util.List;

@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao){
        this.socialMediaDao = socialMediaDao;
    }

    @Override
    public Result add(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.socialMediaDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<SocialMedia>> getAll() {
        return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<SocialMedia> getById(int id) {
        return new SuccessDataResult<SocialMedia>(this.socialMediaDao.getById(id), Messages.dataListed);
    }
}
