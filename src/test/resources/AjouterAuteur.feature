Feature : Ajouter un nouvel auteur

  Scenario : ajouter un auteur

  Given auteur "CelineK" n'existe pas
  When je saisis le nouvel auteur
  Then l'auteur "CelineK" est ajouté avec succès
