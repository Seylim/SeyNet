package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.TechnologyService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Technology;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
@CrossOrigin
public class TechnologyController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Technology technology){
        return this.technologyService.add(technology);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Technology technology){
        return this.technologyService.update(technology);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.technologyService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Technology> getById(int id){
        return this.technologyService.getById(id);
    }
}
