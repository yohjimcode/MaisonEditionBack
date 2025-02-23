package Maison.EditionLivres.rest.controller.ref;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.rest.dto.ref.AuteurDto;
import Maison.EditionLivres.service.ref.AuteurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auteur")
public class AuteurController {

    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @PostMapping
    void addAuteur(@RequestBody @Valid AuteurDto auteurDto){
        auteurService.addAuteur(auteurDto);
    }

    @GetMapping
    public ResponseEntity<List<AuteurModel>> getAllAuteurs(){
        List<AuteurDto> auteurs = auteurService.getAllAuteurs();
        return ResponseEntity.ok(auteurs);
    }

    /*
        @GetMapping
    public ResponseEntity<List<LivreDto>> getAllLivres() {
        List<LivreDto> livres = livreService.getAllLivre();
        return ResponseEntity.ok(livres);
    }
     */

}
