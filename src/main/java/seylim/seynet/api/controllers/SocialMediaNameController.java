package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.SocialMediaNameService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.SocialMediaName;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedianame")
@CrossOrigin
public class SocialMediaNameController {

    private SocialMediaNameService socialMediaNameService;

    @Autowired
    public SocialMediaNameController(SocialMediaNameService socialMediaNameService){
        this.socialMediaNameService = socialMediaNameService;
    }

    @PostMapping("/add")
    public Result add(SocialMediaName socialMediaName){
        return this.socialMediaNameService.add(socialMediaName);
    }

    @PutMapping("/update")
    public Result update(SocialMediaName socialMediaName){
        return this.socialMediaNameService.update(socialMediaName);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.socialMediaNameService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<SocialMediaName>> getAll(){
        return this.socialMediaNameService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<SocialMediaName> getById(int id){
        return this.socialMediaNameService.getById(id);
    }
}
