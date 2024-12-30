Feature : Ajouter un nouvel auteur
Scenario : Ajouter un nouvel auteur

  Given Le livre "Charly mène l'enquete" n'existe pas
  When j'ajoute le livre
  Then le livre est ajouté