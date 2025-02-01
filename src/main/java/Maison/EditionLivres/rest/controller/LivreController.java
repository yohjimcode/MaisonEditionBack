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
@RequestMapping("livre")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping
    public ResponseEntity<LivreDto> addLivre(@RequestBody LivreDto livreDto){
        LivreDto livre = livreService.addLivre(livreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livre);
    }

    @GetMapping
    public ResponseEntity<List<LivreDto>> getAllLivres() {
        List<LivreDto> livres = livreService.getAllLivre();
        return ResponseEntity.ok(livres);
    }

    @GetMapping ("{id}")
    public ResponseEntity<LivreDto> getLivre(@PathVariable Long id){
        LivreDto livre = livreService.getLivrebyId(id).orElseThrow();
        return ResponseEntity.ok(livre);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LivreDto> deleteLivre(@PathVariable Long id){
        LivreDto livreSupprime = livreService.deleteLivre(id);
        return ResponseEntity.ok(livreSupprime);
    }
}
