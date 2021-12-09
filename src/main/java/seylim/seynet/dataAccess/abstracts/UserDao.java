package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User getById(int id);

    User getByEmail(String email);
}
