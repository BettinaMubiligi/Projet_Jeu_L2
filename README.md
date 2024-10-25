 Cette simulation a pour cadre la collecte de joyaux (diamant, rubis, opale,...) dans une grille où se trouve
 des gardiens. Joyaux et gardiens sont des Contenu qui se trouvent dans les cases de la grille. Les joyaux
 ont un prix évalué en nombre de pièces d’or (entre 1 et X ∗ 10000). Les gardiens ont un nombre de points de vie (entre 0 et 200).
 
 — La simulation se déroule sur une grille représentée à l’aide de la classe Grille qui est fournie.
 — La simulation gére des Contenu (classe qui est aussi fournie) placés sur la grille, ces contenus doivent
 être placés dans une case (et une seule) ou retirés.
 — La simulation doit définir au moins 2 types de contenus. Les joyaux et les gardiens peuvent
 donner lieu à plusieurs classes selon des propriétés que vous voudrez leur donner, c’est à vous de
 choisir ce que vous souhaitez ajouter.
 
La classe AgentX possède deux attributs qui correspondent à la position de l’agent
 sur le terrain (numéros de ligne et de colonne), ainsi qu’un sac de joyaux qui est vide au départ.
 Remarque : les agents ne sont pas placés dans la grille, ils parcourent la grille en se déplaçant.
 — seDeplacer(xnew,ynew)  change la position de l’agent sur la grille et le place en (xnew,
 ynew) si le déplacement est possible, sinon une exception DeplacementIncorrectException
 doit être levée. Il est nécessaire de définir vous-même cette exception. Une fois que l’agent
 arrive dans une case :
 
 — si la case où il arrive contient un joyau, il le ramasse (le joyaux est donc retiré de la grille
 et il le met dans son sac à joyaux.
 
 — si la case est occupée par un gardien, il perd tous les joyaux de son sac (qui est donc vidé).
 
 — seDeplacer(xnew,ynew,f)  change la position de l’agent courant sur le terrain et le place en
 (xnew, ynew) si le déplacement est possible sinon une exception DeplacementIncorrectException
 doit être levé. Le troisième argument est un entier f (la force) qui est utilisé de la façon décrite
 ci-dessous. Une fois que l’agent arrive dans une case :
 
 — si la case où il arrive contient un joyau, il le ramasse.
 
 — si la case est occupée par un gardien, si son nombre de point de vie est inférieur ou égal
 à f, alors le gardien est retiré de la grille. Par contre, si le gardien possède un nombre de
 points de vie strictement supérieur à f alors l’agent perd tous les joyaux de son sac et le
 gardien voit son nombre de points de vie baisser de f points.
 
 — fortune()  donne la valeur en pièces d’or du sac de joyaux de l’agent.
 
 — contenuSac()  donne l’ensemble des joyaux contenus dans son sac.

 La classe Simulation contient un agent, une grille, et un tableau de contenus. Cette
 classe possède un constructeur qui place aléatoirement m contenus sur la grille. Elle contient
 aussi une méthode toString qui permet d’avoir le contenu de la grille et les informations sur
 l’agent (position, fortune) et qui sera utilisée pour afficher l’état de la simulation. Cette classe
 doit contenir une méthode lance(nbEtapes) qui prend un entier naturel en argument et réalise
 le travail suivant :
 
 (a) choisir le déplacement de l’agent (avec ou sans force) par un choix aléatoire : une case juste à
 côté de sa position où il se trouve est choisie et l’agent à 30% de chance de faire un déplacement
 avec force (la valeur f est alors générée aléatoirement entre 10 et 100).
 
 (b) réaliser le déplacement de l’agent;
 
 (c) afficher des informations sur ce qui s’est produit durant l’étape;
 
 (d) recommencer à l’étape (a) un nombre nbEtapes de fois.
 
 La classe TestSimulation contient un main(), dans lequel des essais de simulation sont
 effectués et qui produit un log à l’écran avec les différentes actions réalisées et leurs résultats. 
