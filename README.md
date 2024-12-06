# Library
Une application fullstack java angular basé sur un tuto de developpez.com
Tutoriel sur le développement full stack d'une application Web avec Angular et Spring Boot 
lien : https://gkemayo.developpez.com/tutoriels/java/tutoriel-sur-creation-application-web-avec-angular7-et-spring-boot-2/?page=expression-du-besoin-de-l-application

## Expression du besoin de l'application
Pour mieux exposer les notions techniques et technologiques de cet article, nous allons nous faire guider par un exemple d'application web.
Il convient donc de fixer ses besoins et ses objectifs ainsi que les détails métier à implémenter.

### -A Expression du besoin
L'application web que nous voulons construire est un outil d'administration de bibliothèque ou de gestion de livres. L'objectif est de proposer un outil qui permet à un bibliothécaire la possibilité de gérer l'insertion dans son système, de nouveaux livres, de nouveaux clients et de réaliser des prêts de livres à ces derniers.

D'après le bibliothécaire, les informations qui l'intéressent sur un livre pour la gestion de sa bibliothèque sont les suivantes : ISBN, titre, date de sortie, nom de son auteur et nombre d'exemplaires qu'il gère. Il souhaite ranger ses livres par catégories (Poésie, Roman, Sciences, etc.) afin de connaitre rapidement dans quel domaine se situe un livre qu'il consulte. Pour les clients, potentiels emprunteurs, qu'il souhaite enregistrer, il lui faut leur nom, leurs prénoms, leur profession, leurs adresses e-mail et postale, et la date à laquelle il les a enregistrés dans son système. Ensuite, lorsque le bibliothécaire réalise une opération d'emprunt, il souhaiterait enregistrer la date de début et de fin prévue de l'emprunt. Pour un client donné, il ne souhaite pas qu'il soit restreint dans l'emprunt de plusieurs livres, mais inversement, comme un livre a plusieurs exemplaires, il souhaite l'emprunter à plusieurs clients autant qu'il y en a d'exemplaires. En revanche, un client ne peut disposer de plusieurs exemplaires du même livre tant qu'il a un emprunt en cours avec ce livre. Par ailleurs, il faudra qu'il puisse être capable d'envoyer un mail à ses emprunteurs. Enfin, le bibliothécaire souhaite une organisation simple de son application pour pouvoir réaliser de façon efficace ses besoins.

### -B Découpage du besoin en User Stories 
Dans un esprit agile et par application de la méthodologie Scrum, nous allons constituer, ci-dessous, le Backlog de notre application exprimé sous forme d'une liste de User Stories (US). Cette approche permet de mettre en place un développement logiciel par petit bout. Chaque bout correspond à une User Story et représente une expression fine et élémentaire du besoin métier concourant à la réalisation de l'objectif global attendu de l'application (cf. section I-A).

Pour info, un Backlog peut être défini comme un bac à sable contenant une liste ordonnée des fonctionnalités à mettre en place pour atteindre la réalisation d'un produit final qui pour le cas d'espèce est notre l'application web. Une User Story dans un backlog représente donc une et une seule fonctionnalité exprimée généralement sous forme de scénario ………« En tant que… je veux que… afin de… »

User Story 1 : en tant qu'administrateur de la bibliothèque, je dois pouvoir ajouter un nouveau livre, afin d'augmenter l'effectif des livres du système.

User Story 2 : en tant qu'administrateur de la bibliothèque, je dois pouvoir rechercher un livre par son ISBN ou par une partie ou totalité de son titre, afin de visualiser l'ensemble de ses informations.

User Story 3 : en tant qu'administrateur de la bibliothèque, suite à une recherche de livres, je dois pouvoir avoir la possibilité de modifier ou de supprimer chacun des livres sur la liste qui s'affiche.

User Story 4 : en tant qu'administrateur de la bibliothèque, je dois pouvoir ajouter un nouveau client, afin d'augmenter l'effectif des clients du système.

User Story 5 : en tant qu'administrateur de la bibliothèque, je dois pouvoir rechercher un client par son e-mail ou par une partie ou totalité de son nom de famille, afin de visualiser l'ensemble de ses informations.

User Story 6 : en tant qu'administrateur de la bibliothèque, suite à une recherche de clients, je dois pouvoir avoir la possibilité de modifier ou de supprimer chacun des clients sur la liste qui s'affiche.

User Story 7 : en tant qu'administrateur de la bibliothèque, je dois pouvoir ajouter un nouveau prêt, afin de réaliser la connexion entre un livre sorti de la bibliothèque et son emprunteur (client enregistré).

User Story 8 : en tant qu'administrateur de la bibliothèque, je dois pouvoir rechercher la liste des prêts d'un client via son e-mail et la liste des prêts réalisés jusqu'à une certaine date, afin de visualiser l'historique.

User Story 9 : en tant qu'administrateur de la bibliothèque, suite à une recherche de prêts, je dois pouvoir avoir la possibilité de modifier ou de clôturer chacun des prêts sur la liste qui s'affiche.

User Story 10 : en tant qu'administrateur de la bibliothèque, suite à une recherche de prêts, je dois pouvoir avoir la possibilité d'envoyer un mail à un emprunteur, afin de lui passer une information utile.

User Story 11 : en tant qu'administrateur de la bibliothèque, je dois pouvoir avoir sur mon application, un menu général qui me permet d'accéder à la page de gestion des livres, celle des clients et celle des prêts ; afin d'être plus efficace dans l'utilisation de l'application.

Cette liste de User stories n'est pas exhaustive. Nous ferons abstraction dans le cadre de cet article de l'aspect sécurisation de l'application décliné par l'authentification de l'administrateur pour avoir accès aux différentes possibilités citées dans les US ci-dessus.