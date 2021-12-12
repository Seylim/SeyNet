package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Language;
import seylim.seynet.entities.concretes.LanguageLevel;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {
}
