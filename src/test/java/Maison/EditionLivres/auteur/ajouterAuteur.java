package Maison.EditionLivres.auteur;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ajouterAuteur {
    
    
    @Given("auteur {string} n'existe pas")
    public void auteurNExistePas(String arg0) {
        AuteurModel auteur = new AuteurModel();
        

    }


    @When("je saisis les informations de l'auteur {string}")
    public void jeSaisisLesInformationsDeLAuteur(String arg0) {

    }

    @Then("l'auteur {string} est ajouté avec succès")
    public void lAuteurEstAjoutéAvecSuccès(String arg0) {

    }
}
