package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
