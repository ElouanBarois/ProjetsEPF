/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
import java.util.Random;
import java.util.Scanner;
public class Partie {
    //Attributs:
    Joueur [] listeJoueurs =  new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleJeu;
    
    //Constructeurs: 
    public Partie(Joueur Joueur1,Joueur Joueur2){
        listeJoueurs[0]=Joueur1;
        listeJoueurs[1]=Joueur2;
    }
    
    
    
    //Méthodes
    public void attribuerCouleursAuxJoueurs(){ //attribue aléatoirement une couleur au joueur
        Random rand = new Random();
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound); //On tire un chiffre au hasard (0 ou 1)
        //Selon le chiffre tiré on affecte les couleurs aux joueurs
        if (int_random==0){ 
            listeJoueurs[0].Couleur="Rouge";
            listeJoueurs[1].Couleur="Jaune";
        } else{
            listeJoueurs[0].Couleur="Jaune";
            listeJoueurs[1].Couleur="Rouge";
        }
    }
    public void initialiserPartie(){ //crée une grille, place les désint et trous noirs, donne les jetons aux joueurs, détermine quel joueur commence
        grilleJeu= new Grille (); //crée une grille
        Random rand = new Random();
        int maxLigne = 6;
        int maxColonne= 7;
        int random_ligne =0;
        int random_colonne=0;
        for (int i=0; i<5;i++){ //Pour 5 trous noirs
           //On tire une cellule au hasard pour y placer notre trou noir
           random_ligne = rand.nextInt(maxLigne);
           random_colonne= rand.nextInt(maxColonne);
           if (grilleJeu.placerTrouNoir(random_ligne,random_colonne)==false){ //on place un troue noir dans la cellule(si il n'y en a pas déjà un) on vérifie si un trou noir a été placé
               i--;//Si le trou noir n'a pas été place, on fait i--, pour s'assurer qu'à la fin du for on aura bien 5 trous noir et pas superposés pas malchance
           }else{
               continue;
           }
        }
        int deux_desint=0;
        while(deux_desint<2){ //On va ici placer les 2 desintégrateurs cachés derrière un trou noir
            //On tire des cellules au hasard
            random_ligne = rand.nextInt(maxLigne);
            random_colonne= rand.nextInt(maxColonne);
            if (grilleJeu.CellulesJeu[random_ligne][random_colonne].presenceTrouNoir()==true){ //on teste si il y a déjà un trou noir dans la cellule
                grilleJeu.placerDesintegrateur(random_ligne,random_colonne);//on rajoute un désintégrateur dans la celluleavec le trou noir
                deux_desint++;//on incrément le compteur pour n'avoir que 2 trous noirs cachés
            }
        }
        int trois_desint=0;
        while (trois_desint<3){ //On va placer les 3 désintégrateurs qui ne sont pas avec des trous noirs
            random_ligne = rand.nextInt(maxLigne);
            random_colonne= rand.nextInt(maxColonne);
            if (grilleJeu.CellulesJeu[random_ligne][random_colonne].presenceTrouNoir()==false){//On vérifie qu'il n'y a pas déjà un trou noir
                grilleJeu.placerDesintegrateur(random_ligne,random_colonne);
                trois_desint++;
            }
        }
        
        
        for (int i=0;i<21;i++){ //On va remplir les listes de jetons des joueurs avec des jetons de meme couleur que le joueur
            Jeton unJeton= new Jeton("Rouge");//On crée les jetons rouges
            if (listeJoueurs[0].Couleur=="Rouge"){
                listeJoueurs[0].ajouterJeton(unJeton);
                listeJoueurs[0].nombreJetonsRestants++;
            }else{
                listeJoueurs[1].ajouterJeton(unJeton);
                listeJoueurs[1].nombreJetonsRestants++;
            }
        }
        for (int i=0;i<21;i++){
            Jeton deuxJeton= new Jeton("Jaune");//On crée les jetons jaunes
            if (listeJoueurs[1].Couleur=="Jaune"){
                listeJoueurs[1].ajouterJeton(deuxJeton);
                listeJoueurs[1].nombreJetonsRestants++;
                
            }else{
                listeJoueurs[0].ajouterJeton(deuxJeton);
                listeJoueurs[0].nombreJetonsRestants++;
            }
        }
        //On détermine aléatoirement quel joueur va commencer la partie
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound);
        if (int_random==0){
            JoueurCourant=listeJoueurs[0];
        }else{
            JoueurCourant=listeJoueurs[1];
        }
    }
    
    public void debuterPartie(){
        Joueur DernierJoueur=null;
        Scanner sc = new Scanner(System.in) ;
        int i=0;
        int j=0;
        boolean test1=false;
        boolean test2=false;
        while (test1==false&&test2==false){ //On teste qu'aucun des joueurs n'ait une grille gagnante
            //On affiche des informations utiles au joueur courant
            System.out.println();
            System.out.println();
            System.out.println("Au tour de " +JoueurCourant.nom+ " le Joueur de couleur "+JoueurCourant.Couleur+" !");
            System.out.println("Vous avez "+JoueurCourant.nombreJetonsRestants +" Jetons et "+JoueurCourant.nombreDesintegrateurs+" Desintegrateurs");
            System.out.println();
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Si vous voulez jouer un Jeton: Tapez 1\nSi vous voulez en récupérer: Tapez 2\nSi vous voulez jouer une Desintegrateur: Tapez 3 ");
            int Choix = sc.nextInt(); //On enregistre le choix du joueur
            int verif_1=1;
            
            
            //Si le Joueur choisit de récupérer un jeton (Choix==2)
            if (Choix==2){
                //Premier test pour s'assurer que la grille, contient bien au moins un jeton de meme couleur que le Joueur Courant
                for (int q=0;q<6;q++){
                    for (int w=0;w<7;w++){
                        if (grilleJeu.celluleOccupee(q, w)){// On est obligés de mettre ce test avant sinon on pourrait comparer des couleurs avec des null
                            if (grilleJeu.lireCouleurDuJeton(q, w)==JoueurCourant.Couleur){
                                verif_1=0;
                                break;
                            }
                        }
                    }
                }
                if(verif_1==0){//Si il y a bien un jeton de la bonne couleur dans la grille
                    for (int t=0;t<100;t++){////Boucle très grande pour éviter tout cas où le joueur se tromperait dans l'input de la cellule 
                        //L'utilisateur rentre une cellule d'où il veut récuperer le jeton
                        System.out.println("Quel jeton souhaitez-vous récupérer?");
                        System.out.print("Tapez la ligne:");
                        int ligne_choisie = sc.nextInt()-1;
                        System.out.print("Tapez la colonne:");
                        int colonne_choisie = sc.nextInt()-1;
                        if (grilleJeu.celluleOccupee(ligne_choisie, colonne_choisie)){//Test anti null
                            if(grilleJeu.lireCouleurDuJeton(ligne_choisie, colonne_choisie)==JoueurCourant.Couleur){//Si dans la cellule choisie on a un jeton de la bonne couleur
                                Jeton a=grilleJeu.recupererJeton(ligne_choisie, colonne_choisie);//On sauvegarde la valeur du jeton puis on l'efface de la cellule
                                JoueurCourant.ajouterJeton(a);//on rajoute ce jeton à la liste de jetons du joueur
                                JoueurCourant.nombreJetonsRestants++;//On incrémente le compteur de jetons restant
                                grilleJeu.tasserGrille(colonne_choisie);
                                break;//On sort de la boucle for "infinie" dés que le jeton a été récupéré, pour éviter qu'on en récupère plusieurs
                            }else{
                            System.out.println("Il n'y a pas de jeton à vous dans cette case!");//si la cellule choisie par l'utilisateur n'a pas de jeton de sa couleur
                            }
                        }
                    }
                }else{
                    System.out.println("Vous ne pouvez pas retirer un jeton car il n'y en a aucun à vous sur la grille!\n Veuillez placer un Jeton:\n");//Si il n'y a aucun jeton de la bonne couleur dans la grille
                    Choix=1;//On renvoie le jouer sur le choix 1, jouer un jeton car c'est la seule action à faire
                }
            }
            
            //Si le Joueur choisit de jouer un désintégrateur (Choix==3)  
            if (Choix==3){
                //Premier test pour s'assurer que la grille, contient bien au moins un jeton de la couleur du joueur adverse
                for (int q=0;q<6;q++){
                    for (int w=0;w<7;w++){
                        if (grilleJeu.celluleOccupee(q, w)){
                            if(grilleJeu.lireCouleurDuJeton(q, w)!=JoueurCourant.Couleur){
                                verif_1=0;
                                break;
                            }
                        }
                    }
                }
                if(verif_1==0){//Si il y a bien un jeton de la bonne couleur dans la grille
                    if(JoueurCourant.nombreDesintegrateurs!=0){//On vérifie que le joueur courant à au moins 1 désintégrateur à sa disposition
                        for (int t=0;t<100;t++){//Boucle très grande pour éviter tout cas où le joueur se tromperait dans l'input de la cellule
                            System.out.println("Dans quelle case souhaitez vous jouer votre désintigrateur?");
                            System.out.print("Tapez la ligne:");
                            int ligne_choisie = sc.nextInt()-1;
                            System.out.print("Tapez la colonne:");
                            int colonne_choisie = sc.nextInt()-1;
                            if (grilleJeu.celluleOccupee(ligne_choisie, colonne_choisie)){//Test anti null
                                if(grilleJeu.lireCouleurDuJeton(ligne_choisie, colonne_choisie)!=JoueurCourant.Couleur){//Si dans la cellule choisie on a un jeton de la bonne couleur
                                    grilleJeu.supprimerJeton(ligne_choisie, colonne_choisie);
                                    grilleJeu.tasserGrille(colonne_choisie);
                                    JoueurCourant.nombreDesintegrateurs--;
                                    break;//On sort de la boucle for "infinie" dés que le jeton a été supprimé, pour éviter qu'on en supprime plusieurs
                                
                                }else{
                                    System.out.println("Il n'y a pas de jeton ennemi dans cette case!");
                                }
                            }
                        }
                    }
                } else{
                    System.out.println("Vous ne pouvez pas désintégrer un jeton ennemi car il n'y en a pas sur la grille!\n Veuillez placer un Jeton:\n");
                    Choix=1;
                }

            }    
                
                
            //Si le Joueur choisit de jouer un Jeton (Choix==1)
            if (Choix==1){
                System.out.println("Dans quelle colonne voulez-vous placer votre Jeton?") ;
                int numCol=0;
                int testBug=1;
                while (testBug!=0){
                    testBug=0;
                    try{
                        numCol=sc.nextInt();
                    }
                    catch(Exception e){
                        testBug=1;
                        System.out.println("erreur: Rentrez une colonne entre 1 et 7");
                        sc.reset();
                        sc.next();
                    }
                }
                int numColonne ;
                numColonne=numCol-1 ;
                if (JoueurCourant.Couleur=="Rouge"){
                    grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[i],numColonne);
                    JoueurCourant.listeJetons[i]=null;
                    JoueurCourant.nombreJetonsRestants--;
                    i++;
                    for (int z=0;z<6;z++){
                        if (grilleJeu.CellulesJeu[z][numColonne].presenceTrouNoir() && grilleJeu.celluleOccupee(z,numColonne)){
                            grilleJeu.CellulesJeu[z][numColonne].activerTrouNoir();
                            if (grilleJeu.CellulesJeu[z][numColonne].presenceDesintegrateur()){
                                grilleJeu.CellulesJeu[z][numColonne].recupererDesintegrateur();
                                JoueurCourant.obtenirDesintegrateur();
                                System.out.println("Vous avez maintenant "+JoueurCourant.nombreDesintegrateurs+" Desintégrateurs!");
                            }
                            break;
                        }
                    }
                    for (int z=0;z<6;z++){
                        if (grilleJeu.CellulesJeu[z][numColonne].presenceDesintegrateur() && grilleJeu.celluleOccupee(z,numColonne)){
                            grilleJeu.CellulesJeu[z][numColonne].recupererDesintegrateur();
                            JoueurCourant.obtenirDesintegrateur();
                            System.out.println("Vous avez maintenant "+JoueurCourant.nombreDesintegrateurs+" Desintégrateurs!");
                            break;
                        }
                    }
                }
                if (JoueurCourant.Couleur=="Jaune"){
                    grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[j],numColonne);
                    JoueurCourant.listeJetons[j]=null;
                    JoueurCourant.nombreJetonsRestants--;
                    j++;
                    for (int y=0;y<6;y++){
                        if (grilleJeu.CellulesJeu[y][numColonne].presenceTrouNoir() && grilleJeu.celluleOccupee(y,numColonne)){
                            grilleJeu.CellulesJeu[y][numColonne].activerTrouNoir();
                            if (grilleJeu.CellulesJeu[y][numColonne].presenceDesintegrateur()){
                                grilleJeu.CellulesJeu[y][numColonne].recupererDesintegrateur();
                                JoueurCourant.obtenirDesintegrateur();
                                System.out.println("Vous avez maintenant "+JoueurCourant.nombreDesintegrateurs+" Desintégrateurs!");
                            }
                            break;
                        }
                    }
                    for (int y=0;y<6;y++){
                        if (grilleJeu.CellulesJeu[y][numColonne].presenceDesintegrateur() && grilleJeu.celluleOccupee(y,numColonne)){
                            grilleJeu.CellulesJeu[y][numColonne].recupererDesintegrateur();
                            JoueurCourant.obtenirDesintegrateur();
                            System.out.println("Vous avez maintenant "+JoueurCourant.nombreDesintegrateurs+" Desintégrateurs!");
                            break;
                        }
                    }
                }
            }
            
            
            
            
            
                
            
                
            test1=grilleJeu.etreGagnantePourJoueur(listeJoueurs[0]);  
            test2=grilleJeu.etreGagnantePourJoueur(listeJoueurs[1]); 
            DernierJoueur=JoueurCourant;
            
            if (JoueurCourant==listeJoueurs[0]){
                JoueurCourant=listeJoueurs[1];
            }else{ JoueurCourant=listeJoueurs[0];}
            
        
        }
        JoueurCourant=DernierJoueur;
        if (test1==true&&test2==true){
            JoueurCourant.Couleur="Noir";
        }else if(test1==true){
            JoueurCourant.Couleur=listeJoueurs[0].Couleur;
        }else if(test2==true){
            JoueurCourant.Couleur=listeJoueurs[1].Couleur;
        }
    }
}




















