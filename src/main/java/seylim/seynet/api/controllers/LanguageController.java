package seylim.seynet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seylim.seynet.business.abstracts.LanguageService;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Language;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Language language){
        return this.languageService.update(language);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.languageService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Language> getById(int id){
        return this.languageService.getById(id);
    }
}
