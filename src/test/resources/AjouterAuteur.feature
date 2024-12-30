Feature : Ajouter un nouvel auteur

  Scenario : ajouter un auteur

  Given auteur "CelineK" n'existe pas
  When je saisis les informations de l'auteur "CelineK"
  Then l'auteur "CelineK" est ajouté avec succès
