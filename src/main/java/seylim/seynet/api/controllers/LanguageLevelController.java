package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.LanguageLevelService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.LanguageLevel;

import java.util.List;

@RestController
@RequestMapping("/api/languagelevel")
@CrossOrigin
public class LanguageLevelController {

    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel){
        return this.languageLevelService.add(languageLevel);
    }

    @PutMapping("/update")
    public Result update(@RequestBody LanguageLevel languageLevel){
        return this.languageLevelService.update(languageLevel);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.languageLevelService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageLevel>> getAll(){
        return this.languageLevelService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<LanguageLevel> getById(int id){
        return this.languageLevelService.getById(id);
    }
}
