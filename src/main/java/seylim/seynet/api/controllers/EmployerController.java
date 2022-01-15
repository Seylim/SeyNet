package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.EmployerService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer) throws Exception{
        return this.employerService.register(employer);
    }

    @GetMapping("/login")
    public Result login(@RequestParam String eMail, @RequestParam String passwordAgain) throws Exception{
        return this.employerService.login(eMail, passwordAgain);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employer employer){
        return this.employerService.update(employer);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.employerService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Employer> getById(int id){
        return this.employerService.getById(id);
    }
}
