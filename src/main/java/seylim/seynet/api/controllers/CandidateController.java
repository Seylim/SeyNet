package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.CandidateService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate) throws Exception{
        return this.candidateService.register(candidate);
    }

    @GetMapping("/login")
    public Result login(@RequestParam String eMail, @RequestParam String passwordAgain) throws Exception{
        return this.candidateService.login(eMail, passwordAgain);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Candidate candidate){
        return this.candidateService.update(candidate);
    }

    @DeleteMapping("/delete")
    public Result delete(int id) {
        return this.candidateService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Candidate> getById(int id){
        return this.candidateService.getById(id);
    }

    @GetMapping("/getbynationalidnumber")
    public DataResult<Candidate> getByNationalIdNumber(String nationalIdNumber){
        return this.candidateService.getByNationalIdNumber(nationalIdNumber);
    }
}
