package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Resume;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

    List<Resume> getByCandidate_Id(int candidateId);
}
