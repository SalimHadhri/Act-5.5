/*
import com.thp.spring.dao.UserDao;
import com.thp.spring.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int creerUnCompte(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User chooseUserSpecifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherRoles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User connectAccount(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificationInformationsPersonnelles(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherUtilisateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findIdRoleByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
	
	/*
	
    Connection con = DAOFactory.connect();
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
    
	
	public UserDaoImpl() {
	}

	public int creerUnCompte (User user){
		int status = 0 ;
    	boolean existmail = emailExist(user.getMail()) ;
    	boolean existPhone = phoneExist(user.getPhone()) ;
    	if (!existmail && !existPhone) {
		
		String firstname = "'"+user.getFirstname()+"'" ;
		String name = "'"+user.getName()+"'" ;
		String pseudo = "'"+user.getPseudo()+"'" ;
		String email = "'"+user.getMail()+"'" ;
		String pwd = "'"+user.getU_password()+"'" ;
		String phoneNumber = "'"+user.getPhone()+"'" ;
		String address = "'"+user.getAddress()+"'" ;
			
		requete = "INSERT INTO vintud.user  values ("+user.getId_user()+","+firstname+","+name+","+pseudo+","+email+","+pwd+","+phoneNumber+","+address+","+user.getRole_id()+");"   ;
				
		try {
			Statement stmt = con.createStatement();
			status=stmt.executeUpdate(requete) ;        
	        System.out.println("Your profile has been saved !! Congrat ;)  ");
	        r�sultats.close();
		} 
		catch (SQLException e) {
			status=-1 ;
		}
    	}else if (existmail && !existPhone){
	        System.out.println("Email Already exists ;)  ");
	        status=0 ;

    	}
    	else if (!existmail && existPhone){
	        System.out.println("Phone Already exists ;)  ");
	        status=-2 ;
    	}
    	
		affiche("fin du programme");
		return status ;
	}

	
	 public User chooseUserSpecifications () {
			
	    User user = new User() ;    	
	    System.out.println(" Select your profile credentials :  ");
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Enter the id of your profile:");
		int idUser= sc6.nextInt();
		user.setId_user(idUser);
			
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your firstname :");
		String firstname = sc.nextLine();
		user.setFirstname(firstname);
			
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter your name :");
		String name = sc1.nextLine();
		user.setName(name);
			
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Please enter your pseudo  :");
		String pseudo = sc3.nextLine();
		user.setPseudo(pseudo);
			
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Please enter your email :");
		String email = sc4.nextLine();
		user.setMail(email);
			
		Scanner sc10 = new Scanner(System.in);
		System.out.println("Please enter your password :");
		String password = sc10.nextLine();
		user.setU_password(password);
			
		Scanner sc11 = new Scanner(System.in);
		System.out.println("Please enter your phone number :");
		String phoneNumber = sc11.nextLine();
		user.setPhone(phoneNumber);
			 
		Scanner sc12 = new Scanner(System.in);
		System.out.println("Please enter your address:");
		String address = sc12.nextLine();
		user.setAddress(address);
			
		afficherRoles() ;
			
		Scanner sc14 = new Scanner(System.in);
		System.out.println("Enter the id of your role:");
		int idRole= sc14.nextInt();
		user.setRole_id(idRole);
						
		return user;
		}
	 
	 
	 
	  public void afficherRoles() {	
		  
		  	requete = "SELECT * FROM vintud.role ; ";
			try {
		    	Statement stmt = con.createStatement();
		    	r�sultats = stmt.executeQuery(requete);
				boolean encore = r�sultats.next();
				while (encore) {
				System.out.println("*********** new library ********");
				System.out.println(r�sultats.getInt("id")+"\n"+r�sultats.getString("nom")); 					   
					   encore = r�sultats.next();
				}
			r�sultats.close();
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
		}
	  
	  public void afficherUtilisateurs() {				
			requete = "SELECT * FROM vintud.user ; ";
			try {
		        Statement stmt = con.createStatement();
		        r�sultats = stmt.executeQuery(requete);
				boolean encore = r�sultats.next();
				while (encore) {
				System.out.println("*********** new user ********");
				System.out.println(r�sultats.getInt("id")+"\n"+r�sultats.getString("mail")+"\n"+r�sultats.getString("u_password"));    
				encore = r�sultats.next();
				}
				r�sultats.close();
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
		}
	  
	  public User connectAccount (String email, String pwd) {
	    	
	    	User userConnected = new User () ;
		       
					String Mail = "'"+email+"'" ;
					String passeword = "'"+pwd+"'" ;

			try {				


		         
				requete = "SELECT * FROM vintud.user WHERE mail = "+Mail+" AND  u_password="+passeword +"  ; ";

				Statement stmt = con.createStatement();
				r�sultats = stmt.executeQuery(requete);
				boolean encore = r�sultats.next(); 
				 
				if(encore) 
				{						
					System.out.println("successs");

					userConnected.setId_user(r�sultats.getInt("id"));
					userConnected.setFirstname(r�sultats.getString("firstname"));
					userConnected.setName(r�sultats.getString("name"));
					userConnected.setPseudo(r�sultats.getString("pseudo"));
					userConnected.setMail(r�sultats.getString("mail"));
					userConnected.setU_password(r�sultats.getString("u_password"));
					userConnected.setPhone(r�sultats.getString("phone"));
					userConnected.setAddress(r�sultats.getString("address"));
					userConnected.setRole_id(r�sultats.getInt("role_id"));

				}
				else {
					System.out.println("failed!!  enter new passeword!!");
					userConnected.setId_user(-1);

				}
		  		r�sultats.close();
				   
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			affiche("fin du programme");
		 	return userConnected ;
		 	
	  }
	  
	  
	  
	  public void modificationInformationsPersonnelles (String mail, String password) {
	    	
	    	User connectedUser = connectAccount(mail,password);   	
	    	System.out.println("  let's modify your personal infos "); 	
	    	System.out.println("pleaze enter your new informations");
	    	  	
	    	try {		   		 	
	    		User newUserSpecifications = chooseUserSpecifications() ;
	    		String firstname = "'"+newUserSpecifications.getFirstname()+"'" ;
	    		String name = "'"+newUserSpecifications.getName()+"'" ;
	    		String pseudo = "'"+newUserSpecifications.getPseudo()+"'" ;
	    		String email = "'"+newUserSpecifications.getMail()+"'" ;
	    		String pwd = "'"+newUserSpecifications.getU_password()+"'" ;
	    		String phoneNumber = "'"+newUserSpecifications.getPhone()+"'" ;
	    		String address = "'"+newUserSpecifications.getAddress()+"'" ;		
	    		String Mail2 = "'"+connectedUser.getMail()+"'" ;
    			String pwd2 = "'"+connectedUser.getU_password()+"'" ;
    			
	    		requete =" UPDATE vintud.user SET " + 
	    			 "id= "+newUserSpecifications.getId_user()+
	    			 ",firstname="+firstname+
	    			 ",name="+name+
	    			 ",pseudo="+pseudo+
	    			 ",mail="+email+
	    			 ",u_password="+pwd+
	    			 ",phone="+phoneNumber+
	    			 ",address="+address+
	    			 ",role_id="+newUserSpecifications.getRole_id()+
	    			 " WHERE mail = "+Mail2+" AND  u_password="+pwd2 +"  ; " ; 
	    			
	    		PreparedStatement stmt = con.prepareStatement(requete);
	    		stmt.executeUpdate() ;
	    		
				System.out.println("successs!! your personal credentials has been modified with success");
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	affiche("fin du programme");
		    System.exit(0);  	
	    }
	    
		public ArrayList<User> findAllUsers () {
			
			ArrayList<User> usersList = new ArrayList<User>() ;
			requete = "SELECT * FROM vintud.user ; ";
			try {
		        Statement stmt = con.createStatement();
		        r�sultats = stmt.executeQuery(requete);
				boolean encore = r�sultats.next();
				while (encore) {
					User user = new User() ;
					user.setId_user(r�sultats.getInt("id"));
					user.setFirstname(r�sultats.getString("firstname"));
					user.setName(r�sultats.getString("name"));
					user.setPseudo(r�sultats.getString("pseudo"));
					user.setMail(r�sultats.getString("mail"));
					user.setU_password(r�sultats.getString("u_password"));
					user.setPhone(r�sultats.getString("phone"));
					user.setAddress(r�sultats.getString("address"));
					user.setRole_id(r�sultats.getInt("id"));
					
					usersList.add(user) ;
				encore = r�sultats.next();
				}
				r�sultats.close();
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
			
			return usersList ;
			
		}
		
		@Override
		public int findIdRoleByName(String name) {

			
			int idRole =0 ;
			requete = "SELECT * FROM vintud.role WHERE  nom = '"+name + "'  ;" ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
				if(encore) {
					idRole = r�sultats.getInt("id") ;
				}

				   	
				   
				   r�sultats.close();
				   
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
			return idRole ;

}
		
		public boolean emailExist(String email) {
			
			boolean exist =false ;
			requete = "SELECT * FROM vintud.user WHERE  mail = '"+email + "'  ;" ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
				if(encore) {
					 exist=true;
				}

				   	
				   
				   r�sultats.close();
				   
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
			return exist ;
			
		}
		
		public boolean phoneExist(String phone) {
			
			boolean exist =false ;
			requete = "SELECT * FROM vintud.user WHERE  phone = '"+phone + "'  ;" ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
				if(encore) {
					 exist=true;
				}

				   	
				   
				   r�sultats.close();
				   
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
			}
			return exist ;
			
		}
}
*/