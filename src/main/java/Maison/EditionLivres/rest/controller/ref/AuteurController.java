package Maison.EditionLivres.rest.controller.ref;

import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.rest.dto.ref.AuteurDto;
import Maison.EditionLivres.service.ref.AuteurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

    private final AuteurService auteurService;


    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @PostMapping
    public ResponseEntity<String> addAuteur(@RequestBody @Valid AuteurDto auteurDto){
        auteurService.addAuteur(auteurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Auteur ajouté avec succès");
    }

}
