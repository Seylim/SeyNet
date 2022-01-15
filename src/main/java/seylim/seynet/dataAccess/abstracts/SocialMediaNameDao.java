package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.SocialMediaName;

public interface SocialMediaNameDao extends JpaRepository<SocialMediaName, Integer> {
}
