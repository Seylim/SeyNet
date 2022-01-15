package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.EducationService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Education;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@CrossOrigin
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Education education){
        return this.educationService.update(education);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.educationService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Education> getById(int id){
        return this.educationService.getById(id);
    }

    @GetMapping("/getbyresumeid")
    public DataResult<List<Education>> getByResume_Id(int resumeId){
        return this.educationService.getByResume_Id(resumeId);
    }

    @GetMapping("/getallbyresumeidsortedbygraduationdate")
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId){
        return this.educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
    }
}
