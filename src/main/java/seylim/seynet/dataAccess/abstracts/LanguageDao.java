package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Language;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
