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
}
