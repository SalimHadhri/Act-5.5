/*
import com.thp.spring.dao.RechercheDAO;
import com.thp.spring.entity.Recherche;

public class RechercheDaoImpl implements RechercheDAO{

	@Override
	public Recherche chooseRechercheSpecifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerRecherche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherRecherches() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRecherche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Recherche findResearchByIdUser(int id_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void lancerRecherche(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyRecherche() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
	
	/*
    Connection con = DAOFactory.connect();
 	UserDao userDAO = DAOFactory.getUserDAO() ;
 	
 	
    ResultSet r�sultats = null;
    String requete = "";
    ResultSetMetaData rsmd;
	private static void arret(String message) {
        System.err.println(message);
        System.exit(99);
     }
    
    private static void affiche(String message) {
        System.out.println(message);
     }
    
    
		
		
		
		public RechercheDaoImpl() {
		super();
	}

		public Recherche chooseRechercheSpecifications () {
			
	    	Recherche newRecherche = new Recherche() ;
	    	
	    	
	    	System.out.println(" Select your search specifications  :  ");
	    	
	    	System.out.println("**************************************");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your search :");
	    	int idFavori= sc6.nextInt();
	    	newRecherche.setId(idFavori);
		
		
	    	
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Choose the type of the dress you're looking for :");
	    	String dress = sc7.nextLine() ;
	    	newRecherche.setType_habit(dress);
	    	
	    	
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Select the size :");
	    	String size = sc8.nextLine() ;
	    	newRecherche.setTaille(size);
	    	
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Choose one color :");
	    	String color = sc9.nextLine() ;
	    	newRecherche.setCouleur(color);
	    	
	    	Scanner sc10 = new Scanner(System.in); ;
	    	System.out.println("What's the maximum money you can afford ? :");
	    	String priceS = sc10.nextLine()  ;
	    	Scanner scanner = new Scanner(priceS);
	    	scanner.useLocale(Locale.US);
	    	float price = scanner.nextFloat() ;
	    	newRecherche.setFourchette_prix(price);
	    	
	    	
	    	userDAO.afficherUtilisateurs(); 
			
	    	Scanner sc11 = new Scanner(System.in);
	    	System.out.println("Enter the id of the user performing this search :");
	    	int idUser= sc11.nextInt();
	    	newRecherche.setUser_id(idUser);
				
	    	return newRecherche;
	    }
		
		
	    public void creerRecherche () {
			
	    	Recherche rechercheChoisi = chooseRechercheSpecifications();	
	    	
	    	
	    	String typeHabit = "'"+rechercheChoisi.getType_habit()+"'" ;
	    	String taille = "'"+rechercheChoisi.getTaille()+"'" ;
	    	String couleur = "'"+rechercheChoisi.getCouleur()+"'" ;

	    	
	    	
	    	requete = "INSERT INTO vintud.recherche  values ("+rechercheChoisi.getId()+","+typeHabit+","+taille+","+couleur+","+rechercheChoisi.getFourchette_prix()+","+rechercheChoisi.getUser_id()+");"   ;
		
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your search has been saved !!   ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}	
	}
	    
	    public void afficherRecherches() {
	    	
	    	requete = "SELECT * FROM vintud.recherche ; ";
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
				 boolean encore = r�sultats.next();
				  while (encore) {
					   System.out.println("*********** new search ********");
					   System.out.println("id search : "+r�sultats.getInt("id")+"\n" +"type d'habit : "+  r�sultats.getString("type_habit") +"\n"+
							   "taille: "+  r�sultats.getString("taille") +"\n"+
							   "couleur: "+  r�sultats.getString("couleur") +"\n"+
							   "fourchette de prix: "+  r�sultats.getFloat("fourchette_prix")+"\n"+
							   "id user : "+r�sultats.getInt("user_id") );
					   
					   encore = r�sultats.next();
				   }
				   r�sultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
				}
	    }
	    
	    public void supprimerRecherche () {
	    	
	    	System.out.println("***Voici la liste des recherche: "+"\n"+" choisissez laquelle vous voulez supprimer *** ");
	    	afficherRecherches();
			
			Scanner sc7 = new Scanner(System.in);
			int idRechercheSupprimer= sc7.nextInt();
			
			try {
			requete ="DELETE FROM vintud.recherche WHERE id="+idRechercheSupprimer+" ;" ;
			
			
			PreparedStatement stmt = con.prepareStatement(requete);
			stmt.executeUpdate() ;

			System.out.println("Search deleted with success !!");
			stmt.close();
			
			System.out.println("Voici la nouvelle liste de favori");
			afficherRecherches();
			
	    	affiche("fin du programme");
		    System.exit(0);  
		} catch (SQLException e) {
			arret("Maybe you entered a false id !!");	}
	    	
	    }
	    
	    
	    public Recherche findResearchByIdUser (int id_user) {
	    		    	
	    	Recherche rechercheTrouv�e = new Recherche() ;
			requete = "SELECT * FROM vintud.recherche WHERE user_id ="+id_user + "  ;" ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
				if(encore) {	
					rechercheTrouv�e.setId(r�sultats.getInt("id"));
					rechercheTrouv�e.setType_habit(r�sultats.getString("type_habit"));
					rechercheTrouv�e.setTaille(r�sultats.getString("taille"));
					rechercheTrouv�e.setCouleur(r�sultats.getString("couleur"));
					rechercheTrouv�e.setFourchette_prix(r�sultats.getFloat("fourchette-prix"));				
					rechercheTrouv�e.setUser_id(r�sultats.getInt("user_id"));		
				   	}
				   
				   r�sultats.close();
				   
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
			return rechercheTrouv�e ;
	    }
	    
	    
	    
	    public void lancerRecherche(String email, String pwd) {
	    	
	    	User utilisateurConnecte = userDAO.connectAccount(email,pwd) ;
	    	
	    	//Recherche searchFound = findResearchByIdUser(utilisateurConnecte.getId_user()) ;
	    	
	    	System.out.println("*********lancement de la recherche *********");
	    	
	    	Recherche rechercheLanc� = new Recherche() ;
	    	rechercheLanc�.setUser_id(utilisateurConnecte.getId_user());
	    	
	    	
	    	
	    	System.out.println(" Select your search specifications  :  ");
	    	
	    	System.out.println("**************************************");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your search :");
	    	int idFavori= sc6.nextInt();
	    	rechercheLanc�.setId(idFavori);
		   	
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Choose the type of the dress you're looking for :");
	    	String dress = sc7.nextLine() ;
	    	rechercheLanc�.setType_habit(dress);
	    	
	    	
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Select the size :");
	    	String size = sc8.nextLine() ;
	    	rechercheLanc�.setTaille(size);
	    	
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Choose one color :");
	    	String color = sc9.nextLine() ;
	    	rechercheLanc�.setCouleur(color);
	    	
	    	
	    
	    	Scanner sc10 = new Scanner(System.in); ;
	    	System.out.println("What's the maximum money you can afford ? :");
	    	String priceS = sc10.nextLine()  ;
	    	Scanner scanner = new Scanner(priceS);
	    	scanner.useLocale(Locale.US);
	    	float price = scanner.nextFloat() ;
	    	rechercheLanc�.setFourchette_prix(price);
	    	
	    	
	    	
	    	String typeHabit = "'"+rechercheLanc�.getType_habit()+"'" ;
	    	String taille = "'"+rechercheLanc�.getTaille()+"'" ;
	    	String couleur = "'"+rechercheLanc�.getCouleur()+"'" ;

	    	
	    	
	    	requete = "INSERT INTO vintud.recherche  values ("+rechercheLanc�.getId()+","+typeHabit+","+taille+","+couleur+","+rechercheLanc�.getFourchette_prix()+","+rechercheLanc�.getUser_id()+");"   ;
			
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your search has been lunched!!   ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}	
	    	
	    	    	
	    }
	    
	    public void modifyRecherche() {
	 		 
			System.out.println("let's proceed to the modification ");		
			try { 
				
				System.out.println("that's the list of your searches");
				afficherRecherches() ;
				System.out.println("  now choose which search do you want to modify ");
				Scanner sc7 = new Scanner(System.in);
				int favoriToModify= sc7.nextInt();
				Recherche newSearch= chooseRechercheSpecifications () ;
				
				//float fourchette = newSearch.getFourchette_prix() ;
				//String fourchetteString ="" + fourchette;

				requete =" UPDATE  vintud.recherche  SET " 
    			 +"id= "+newSearch.getId()
    			 +",type_habit='" + newSearch.getType_habit()
    			 +"' ,taille= '" + newSearch.getTaille()
    			 +"',couleur = '" +newSearch.getCouleur() 
    			 +"',fourchette_prix = "+ newSearch.getFourchette_prix()
    			 +",user_id = " +newSearch.getUser_id()
    			 + " WHERE id="+  favoriToModify + ";" ; 
	
    		
				PreparedStatement stmt1 = con.prepareStatement(requete);
				stmt1.executeUpdate() ;
    		
				System.out.println("successs!! your search has been modified with success");
				stmt1.close();

			} 
			catch (SQLException e) {
			e.printStackTrace();
			}
	    	affiche("fin du programme");
		    System.exit(0) ;
    }	    
	
}
*/

