# Arena Plugin
Ce plugin ajoute le fonctionnement d'une arène.

### Liste des commandes :
- /event start -> permet de démarré l'evenement
- /event stop -> arrete l'evenement

### Déroulement de l'évemenent :
- les joueurs sont connectés au lobby (même serveur, même monde)
- lorsque la commande "/event start" est exécutée par un administrateur, tous les joueurs sont téléportés dans l'arène
- Un décompte de 10 secondes est effectué ou il n'y a pas de Pvp, celui-ci sert à ce que les joueurs puissent se dégager de la zone de téléportation pour ne pas se faire tuer dès le demarrage
- A la fin lorsqu'il ne reste plus qu'un joueurs, un administrateur fait "/event stop" pour arreté l'event et retéléporté tout le monde au spawn.

### Permission :
- "event.admin" -> donne le faite de ne pas etre téléporté, ne pas etre clear et ne pas etre mis en gamemode survival.
- "event.use" -> donne la permission d'exécuter les commandes d'event.

### IMPORTANT
Lors du /event start, les administrateurs ne seront pas téléportés dans l'arène, donc il faudra soit y aller manuellement, soit y aller en se téléportant à un joueur

### Liste des choses a faire :
- [ ] **Faire une config !**
- [ ] Revoir le system d'administration
- [ ] Revoir les messages
- [ ] Revoir les téléportations
