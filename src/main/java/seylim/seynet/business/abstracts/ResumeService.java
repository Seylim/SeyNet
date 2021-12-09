package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {

    DataResult<List<Resume>> getByCandidate_Id(int candidateId);
}
