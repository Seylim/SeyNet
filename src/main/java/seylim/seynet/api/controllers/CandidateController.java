package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.CandidateService;
import seylim.seynet.core.utilities.Messages;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.core.utilities.SuccessResult;
import seylim.seynet.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }

    @DeleteMapping("/delete")
    public Result delete(int id) {
        return this.candidateService.delete(id);
    }
}
