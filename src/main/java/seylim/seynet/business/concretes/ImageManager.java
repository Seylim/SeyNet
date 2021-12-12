package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.ImageService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.ImageDao;
import seylim.seynet.entities.concretes.Image;

import java.util.List;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao){
        this.imageDao = imageDao;
    }

    @Override
    public Result add(Image image) {
        this.imageDao.save(image);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Image image) {
        this.imageDao.save(image);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.imageDao.deleteById(id);
        return new SuccessResult(Messages.dataListed);
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(this.imageDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<List<Image>> getByUser_Id(int userId) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getByUser_Id(userId), Messages.dataListed);
    }
}
