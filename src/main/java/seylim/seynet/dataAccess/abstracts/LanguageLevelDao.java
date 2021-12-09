package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Language;

public interface LanguageLevelDao extends JpaRepository<Language, Integer> {
}
