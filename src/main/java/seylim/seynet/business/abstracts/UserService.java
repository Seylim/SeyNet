package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    DataResult<User> getById(int id);

    DataResult<User> getByEmail(String email);
}
