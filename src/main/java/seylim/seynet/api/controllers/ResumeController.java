package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.ResumeService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Resume;
import seylim.seynet.entities.dtos.ResumeWithAllRelatedEntitiesDto;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume){
        return this.resumeService.add(resume);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Resume resume){
        return this.resumeService.update(resume);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.resumeService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Resume> getById(int id){
        return this.resumeService.getById(id);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<Resume> getByCandidate_Id(int candidateId){
        return this.resumeService.getByCandidate_Id(candidateId);
    }

    @GetMapping("/getallresumesdetailsbycandidate")
    public DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByCandidate(){
        return this.resumeService.getAllResumesDetailsByCandidate();
    }

    @GetMapping("/getResumeDetailsByCandidateId")
    public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(@RequestParam int candidateId) {
        return this.resumeService.getResumeDetailsByCandidateId(candidateId);
    }

}
