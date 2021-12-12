package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.UserService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.UserDao;
import seylim.seynet.entities.concretes.User;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.userDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email));
    }
}
