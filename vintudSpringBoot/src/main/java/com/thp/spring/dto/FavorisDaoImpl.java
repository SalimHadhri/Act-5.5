
/*
import com.thp.spring.dao.FavorisDAO;
import com.thp.spring.entity.Favoris;

public class FavorisDaoImpl implements FavorisDAO{

	@Override
	public void creerFavoris() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Favoris chooseFavorisSpecifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherFavoris() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerFavoris() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RetrouverAnnounce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Favoris findFavoriById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyFavori() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enregistrerAnnonceFavori(int idFavori, String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherFavorisForAUser(int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Favoris> findFavoriByIdUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}

/*	
    	Connection con = DAOFactory.connect();
	 	UserDao userDAO = DAOFactory.getUserDAO() ;
	 	AnnouncementDao announceDAO=DAOFactory.getAnnoucementDAO() ;

	    ResultSet r�sultats = null;
	    String requete = "";
	    ResultSetMetaData rsmd;
	    

		public FavorisDaoImpl() {
		}

		private static void arret(String message) {
	        System.err.println(message);
	        System.exit(99);
	     }
	    
	    private static void affiche(String message) {
	        System.out.println(message);
	     }
	    
	
	    public Favoris chooseFavorisSpecifications () {
		
	    	Favoris favoris = new Favoris() ;  	
	    	System.out.println(" Select your favoris :  ");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your favori :");
	    	int idFavori= sc6.nextInt();
	    	favoris.setId_favoris(idFavori);
		
		
	    	userDAO.afficherUtilisateurs(); 
			
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Enter the id of your user :");
	    	int idUser= sc7.nextInt();
	    	favoris.setId_utilisateur(idUser);
		
	    	announceDAO.consulterAnnonces(); 
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Enter the id of your announcement :");
	    	int idAnnouncement= sc8.nextInt();
	    	favoris.setId_announcement(idAnnouncement);
		
		
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Enter the  date of you favori creation   sous format yyyy-MM-dd:");
	    	String datecreation= sc9.nextLine() ;
	    	favoris.setDateAjout(datecreation);
		
	    	return favoris;
	    }
	
	
	
	    public void creerFavoris () {
		
	    	Favoris favoris = chooseFavorisSpecifications () ;	
	    	String dateRequete = "'"+favoris.getDateAjout()+"'" ;
	    	requete = "INSERT INTO vintud.favoris  values ("+favoris.getId_favoris()+","+favoris.getId_announcement()+","+favoris.getId_utilisateur()+','+dateRequete+");"   ;
		
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your favoris has been saved !! Congrat ;)  ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}	
	}
		
	public void afficherFavoris() {				

		requete = "SELECT * FROM vintud.favoris ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			  while (encore) {
				   System.out.println("*********** new Favori ********");
				   DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				   System.out.println(r�sultats.getInt("id")+"\n"+dateFormat.format(r�sultats.getDate("dateajout"))+"\n" +"id announcement :  "+  r�sultats.getInt("announcement_id")
				   +"\n" +r�sultats.getInt("user_id")); 
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
	}
	
	
	public void supprimerFavoris () {
		
		System.out.println("Voici la liste des favoris: "+"\n"+" choisissez lequel vous voulez supprimer :( ");
		afficherFavoris();
		
		Scanner sc7 = new Scanner(System.in);
		int idFavoriToDelete= sc7.nextInt();
		
		try {
		requete ="DELETE FROM vintud.favoris WHERE id="+idFavoriToDelete+" ;" ;
		
		
		PreparedStatement stmt = con.prepareStatement(requete);
		stmt.executeUpdate() ;

		System.out.println("Favori deleted with success !!");
		stmt.close();
		
		System.out.println("Voici la nouvelle liste de favori");
		afficherFavoris();
		
    	affiche("fin du programme");
	    System.exit(0);  
	} catch (SQLException e) {
		arret("Maybe you entered a false id !!");	}
		
	}
	
		
	public void RetrouverAnnounce() {
		
		System.out.println("For which favori do you want to find the annoucement ? Choose one !!");	
		afficherFavoris() ;		
		Scanner sc7 = new Scanner(System.in);
		int announceToFind= sc7.nextInt();	
		System.out.println(" That's it !! look at your dashbord ");	
		announceDAO.findAnnounceById(announceToFind);

	}

	public Favoris findFavoriById (int id) {
		
		Favoris favoriFound = new Favoris() ;
		requete = "SELECT * FROM vintud.favoris WHERE id ="+id + "  ;" ;
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
			if(encore) {				
				favoriFound.setId_announcement(r�sultats.getInt("announcement_id"));
				favoriFound.setId_favoris(r�sultats.getInt("id"));
				favoriFound.setId_utilisateur(r�sultats.getInt("user_id"));
			 
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		 
				String dateToBe = dateFormat.format(r�sultats.getDate("dateajout"))  ;
		 
				String date = dateFormat.format(r�sultats.getDate("dateajout")) ;
				favoriFound.setDateAjout(dateToBe);
			   	}
			   
			   r�sultats.close();
			   
		} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
		}
		return favoriFound ;
	}


	public void modifyFavori() {
	 		 
		System.out.println("let's proceed to the modification ");		
		try { 
					
			System.out.println("that's the list of your favori");
			afficherFavoris() ;
			System.out.println("  now choose which favori do you want to modify ");
			Scanner sc7 = new Scanner(System.in);
			int favoriToModify= sc7.nextInt();
			Favoris newFavorie = chooseFavorisSpecifications () ;			 

			String date = "'"+ newFavorie.getDateAjout()+"'" ;
				requete =" UPDATE  vintud.favoris  SET " 
	    		+"id= "+newFavorie.getId_favoris()
	    		+",announcement_id=" + newFavorie.getId_announcement()
	    		+",user_id=" + newFavorie.getId_utilisateur()
	    		+",dateajout= " +date 
	    		+ " WHERE id="+  favoriToModify + ";" ; 
    	
	    		
			PreparedStatement stmt1 = con.prepareStatement(requete);
			stmt1.executeUpdate() ;
	    		
			System.out.println("successs!! your personal credentials has been modified with success");
			stmt1.close();

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		    affiche("fin du programme");
			System.exit(0) ;
	    }
	
	public void afficherFavorisForAUser(int idUser) {				

		
		requete = "SELECT * FROM vintud.favoris WHERE user_id="+idUser+"; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			  while (encore) {
				   System.out.println("*********** new Favori ********");
				   DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				   System.out.println(r�sultats.getInt("id")+"\n"+dateFormat.format(r�sultats.getDate("dateajout"))+"\n" +"id announcement :  "+  r�sultats.getInt("announcement_id")
				   +"\n" +r�sultats.getInt("user_id")); 
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
	}
	
	
	public void enregistrerAnnonceFavori(int idFavori,String email, String pwd) {
		
		User userConnected = userDAO.connectAccount(email, pwd);
		
		System.out.println("**********voici la liste de vos annonces***************");
		announceDAO.consulterAnnonces();
		
		System.out.println("***************choose one to make it like favorit*******");
		
		Scanner sc7 = new Scanner(System.in);
		int favoritAnnouncement= sc7.nextInt();
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();

		
		
		requete = "INSERT INTO vintud.favoris  values  ("+idFavori+","+favoritAnnouncement+","+userConnected.getId_user()+",'"+currentDate+"');"   ;
		
		try {
    		Statement stmt = con.createStatement();
    		stmt.executeUpdate(requete) ;
        
    		System.out.println("Your announcement are now in your favorit liste !! ;)  ");
    		
    		System.out.println("That's the list of your current favorits!!" );
    		afficherFavorisForAUser(userConnected.getId_user());
    		//afficherFavoris() ;
    		affiche("fin du programme");
    		System.exit(0);
		} 
    	catch (SQLException e) {
			arret("Anomalie lors de l'execution de la requ�te") ;
		}	
	}
	
	public ArrayList<Favoris> findFavoriByIdUser (int id) {
		
		ArrayList<Favoris> listeFavoris= new ArrayList<Favoris>() ;
		
		
		Favoris favoriFound = new Favoris() ;
		requete = "SELECT * FROM vintud.favoris WHERE user_id ="+id + "  ;" ;
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
			  while (encore) {		
				Favoris favoris = new Favoris() ;
				
				favoris.setId_announcement(r�sultats.getInt("announcement_id"));
				favoris.setId_favoris(r�sultats.getInt("id"));
				favoris.setId_utilisateur(r�sultats.getInt("user_id"));
			 
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		 
				String dateToBe = dateFormat.format(r�sultats.getDate("dateajout"))  ;
		 
				String date = dateFormat.format(r�sultats.getDate("dateajout")) ;
				favoris.setDateAjout(dateToBe);		
				
				listeFavoris.add(favoris) ;
				encore = r�sultats.next();
				   
			  }
			   
			   r�sultats.close();
			   
		} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
		}
		return listeFavoris ;
		
		
	}

 		
}
	
	
*/
