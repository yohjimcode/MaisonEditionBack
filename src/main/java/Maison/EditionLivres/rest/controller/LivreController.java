package Maison.EditionLivres.rest.controller;

import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

//    @PostMapping("/livre")
//    void addLivre(@RequestBody LivreDto livreDto){
//        livreService.addLivre(livreDto);
//    }

    @PostMapping
    public ResponseEntity<String> addLivre(@RequestBody @Valid LivreDto livreDto){
        livreService.addLivre(livreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livre ajouté avec succès");
    }
}
