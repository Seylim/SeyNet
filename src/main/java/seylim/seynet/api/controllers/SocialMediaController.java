package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.SocialMediaService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.SocialMedia;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedia")
@CrossOrigin
public class SocialMediaController {

    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SocialMedia socialMedia){
        return this.socialMediaService.add(socialMedia);
    }

    @PutMapping("/update")
    public Result update(@RequestBody SocialMedia socialMedia){
        return this.socialMediaService.update(socialMedia);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.socialMediaService.delete(id);
    }

    @GetMapping("getall")
    public DataResult<List<SocialMedia>> getAll(){
        return this.socialMediaService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<SocialMedia> getById(int id){
        return this.socialMediaService.getById(id);
    }
}
