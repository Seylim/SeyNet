package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.JobPositionService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobposition")
@CrossOrigin
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.update(jobPosition);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.jobPositionService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<JobPosition> getById(int id){
        return this.jobPositionService.getById(id);
    }

    @GetMapping("/getAllByIsActive")
    public DataResult<List<JobPosition>> getAllByIsActive(boolean isActive){
        return this.jobPositionService.getAllByIsActive(isActive);
    }

    @GetMapping("/getAllActiveOnesByPage")
    public DataResult<List<JobPosition>> getAllActiveOnesByPage(int pageNo, int pageSize){
        return this.jobPositionService.getAllActiveOnesByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDate")
    public DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDate(){
        return this.jobPositionService.getAllActiveOnesSortedByPostingDate();
    }

    @GetMapping("/getAllActiveOnesByPageSortedByPostingDate")
    public DataResult<List<JobPosition>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize){
        return this.jobPositionService.getAllActiveOnesByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDateTop6")
    public DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDateTop6(){
        return this.jobPositionService.getAllActiveOnesSortedByPostingDateTop6();
    }

    @GetMapping("/getAllActiveOnesByEmployerIdSortedByPostingDate")
    public DataResult<List<JobPosition>> getAllActiveOnesByEmployerIdSortedByPostingDate(int employerId){
        return this.jobPositionService.getAllActiveOnesByEmployerIdSortedByPostingDate(employerId);
    }

    @GetMapping("/getAllActiveOnesFilteredByCityAndJobTitle")
    public DataResult<List<JobPosition>> getAllActiveOnesFilteredByCityAndJobTitle(int cityId, int jobTitleId) {
        return this.jobPositionService.getAllActiveOnesFilteredByCityAndJobTitle(cityId, jobTitleId);
    }

    @GetMapping("/getAllActiveOnesByPageFilteredByCityAndJobTitle")
    public DataResult<List<JobPosition>> getAllActiveOnesByPageFilteredByCityAndJobTitle(int cityId, int jobTitleId, int pageNo, int pageSize){
        return this.jobPositionService.getAllActiveOnesByPageFilteredByCityAndJobTitle(cityId, jobTitleId, pageNo, pageSize);
    }
}

