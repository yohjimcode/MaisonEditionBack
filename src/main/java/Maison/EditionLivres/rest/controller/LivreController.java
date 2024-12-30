package Maison.EditionLivres.rest.controller;

import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.service.LivreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edition")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }


    @PostMapping("/livre")
    void addLivre(@RequestBody LivreDto livreDto){
        livreService.addLivre(livreDto);
    }

}
