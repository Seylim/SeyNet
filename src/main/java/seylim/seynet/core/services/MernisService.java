package seylim.seynet.core.services;

import seylim.seynet.entities.concretes.Candidate;

public interface MernisService {
    public boolean ifRealPerson(Candidate candidate) throws Exception;
}
