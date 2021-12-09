package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    Candidate getByNationalIdNumber(String natianlIdNumber);
}
