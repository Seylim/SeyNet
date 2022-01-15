package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.ExperienceService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Experience;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Experience experience){
        return this.experienceService.add(experience);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Experience experience){
        return this.experienceService.update(experience);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.experienceService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Experience>> getAll(){
        return this.experienceService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Experience> getById(int id){
        return this.experienceService.getById(id);
    }

    @GetMapping("/getbyresumeid")
    public DataResult<List<Experience>> getByResume_Id(int resumeId){
        return this.experienceService.getByResume_Id(resumeId);
    }

    @GetMapping("/getallbyresumeidsortedbyterminaationdate")
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId){
        return this.experienceService.getAllByResumeIdSortedByTerminationDate(resumeId);
    }
}
