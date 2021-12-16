package seylim.seynet.core.adaptors;

import org.springframework.stereotype.Service;
import seylim.seynet.MernisService.LGFKPSPublicSoap;
import seylim.seynet.core.services.MernisService;
import seylim.seynet.entities.concretes.Candidate;

@Service
public class MernisAdaptor implements MernisService {
    @Override
    public boolean ifRealPerson(Candidate candidate) throws Exception {
        LGFKPSPublicSoap soap = new LGFKPSPublicSoap();
        return soap.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdNumber().toString()),candidate.getFirstName(), candidate.getLastName(), candidate.getYearOfBirth());
    }
}
