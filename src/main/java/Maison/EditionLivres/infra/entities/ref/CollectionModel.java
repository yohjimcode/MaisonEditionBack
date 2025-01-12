package Maison.EditionLivres.infra.entities.ref;

import Maison.EditionLivres.infra.entities.LivreModel;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="REF_COLLECTION")
public class CollectionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="NOM_COLLECTION")
    private String nomCollection;

    @OneToMany(mappedBy = "collection")
    private List<LivreModel> livres = new ArrayList<>();

}
