package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.CityService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city){
        return this.cityService.add(city);
    }

    @PutMapping("/update")
    public Result update(@RequestBody City city){
        return this.cityService.update(city);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.cityService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<City> getById(int id){
        return this.cityService.getById(id);
    }

}
