package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.JobTitleService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.JobTitle;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitle")
@CrossOrigin
public class JobTitleController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService){
        this.jobTitleService = jobTitleService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.update(jobTitle);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.jobTitleService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return this.jobTitleService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<JobTitle> getById(int id){
        return this.jobTitleService.getById(id);
    }
}
