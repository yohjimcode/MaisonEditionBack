package Maison.EditionLivres.rest.controller;

import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping("/livre")
    void addLivre(@RequestBody LivreDto livreDto){
        livreService.addLivre(livreDto);
    }

    @GetMapping ("/livres")
    List<LivreModel> getAllLivres(){
        return livreService.getAllLivre().stream().toList();
    }

    @GetMapping ("/livre/{id}")
    void getLivre (@RequestParam Long id){
        livreService.getLivrebyId(id);
    }

    @DeleteMapping("/livre/{id}")
    void deleteLivre(@RequestParam Long id){
        livreService.deleteLivre(id);
    }
}
