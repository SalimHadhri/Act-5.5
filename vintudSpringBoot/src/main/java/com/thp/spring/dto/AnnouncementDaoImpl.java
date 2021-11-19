
/*
package com.thp.spring.daoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.thp.spring.dao.AnnouncementDao;
import com.thp.spring.entity.Announcement;




public class AnnouncementDaoImpl implements AnnouncementDao{

	@Override
	public void consulterAnnonces() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAnnouncementByNameCatgeryAndOrPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtreAnnoucementPrix() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtreAnnoucementLocalisation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voirNombreVues(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Announcement> findAnnounceByIdUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Announcement findAnnounceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Announcement> findAllAnnoucement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
	
	
/*
    Connection con = DAOFactory.connect();
    //ConnectionManager.getInstance().getConnection();

	CategoryDao categoryDao = DAOFactory.getCategoryDAO() ;
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
    
 
	public AnnouncementDaoImpl() {
	}

	
	public Announcement findAnnounceById (int id) {
		
		Announcement annonce = new Announcement() ;
		requete = "SELECT * FROM vintud.announcement WHERE id ="+id + "  ;" ;
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
			if(encore) {				
				  annonce.setId_annoucement(r�sultats.getInt("id"));
				  annonce.setTitle(r�sultats.getString("title"));
				  annonce.setDescription(r�sultats.getString("description"));
				  annonce.setCategory_id(r�sultats.getInt("category_id"));
				  annonce.setPrice(r�sultats.getInt("price"));
				  annonce.setPicture(r�sultats.getString("picture"));
				  annonce.setPublication_date(r�sultats.getString("publication_date"));
				  annonce.setIs_available(r�sultats.getBoolean("is_available"));
				  annonce.setView_number(r�sultats.getInt("view_number"));
				  annonce.setLocalisation(r�sultats.getString("localisation"));
				  annonce.setUser_id(r�sultats.getInt("user_id") );
			   	}
			   
			   r�sultats.close();
			   
		} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
		}
		return annonce ;
		
		
	}
	
	
	
	public void findAnnouncementByNameCatgeryAndOrPrice () {
		
		System.out.println("****Commencons notre recherche de l'annonce *****");
		
		System.out.println("  Entrez le nom de l'annonce ");
		Scanner sc1 = new Scanner(System.in);
		String nomAnnonce= sc1.nextLine();
		
		System.out.println("**********choisissez entre ces categories******");
		categoryDao.AfficherCategories();
		
		
		System.out.println("  Entrez la category de l'annonce ");
		Scanner sc2 = new Scanner(System.in);
		int categoriId= sc2.nextInt();
		
		System.out.println("  Entrez le prix de notre annonce  NB : O pour ne pas rechercher avec le prix");
		Scanner sc3 = new Scanner(System.in);
		String prixString = sc3.nextLine()  ;
    	Scanner scanner = new Scanner(prixString);
    	scanner.useLocale(Locale.US);
		float prixCategoryFoat= scanner.nextFloat() ;
		

		if(prixCategoryFoat !=0) {
			
		
		requete = "SELECT * FROM vintud.announcement WHERE title  ILIKE '%"+nomAnnonce+"%' "
				+ "AND category_id="+ categoriId +" AND price = "+ prixCategoryFoat  ;
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
	         
	         if (encore) {
	        	 
	       
			  while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+r�sultats.getFloat("price")
					+"\n"+r�sultats.getByte("picture")
					+"\n"+r�sultats.getTimestamp("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   encore = r�sultats.next();
			   }
	         } else {
	        	 affiche("pas d'annonce correspondante !!");
	         }
			   
			  r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		affiche("fin du programme");
	    System.exit(0);  
		}else {

			requete = "SELECT * FROM vintud.announcement WHERE title ILIKE '%"+nomAnnonce+"%' "
					+ "AND category_id="+ categoriId  ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
		         
		         if (encore) {
		        	 
		       
				  while (encore) {
					   System.out.println("*********** new announcement ********");
					   System.out.println(r�sultats.getInt("id")
						+"\n"+r�sultats.getString("title")
						+"\n"+r�sultats.getString("description")
						+"\n"+r�sultats.getInt("category_id")
						+"\n"+r�sultats.getFloat("price")
						+"\n"+r�sultats.getByte("picture")
						+"\n"+r�sultats.getTimestamp("publication_date")
						+"\n"+r�sultats.getBoolean("is_available")
						+"\n"+r�sultats.getInt("view_number")
						+"\n"+r�sultats.getString("localisation")
						+"\n"+r�sultats.getInt("user_id") );
					   encore = r�sultats.next();
				   }
		         } else {
		        	 affiche("pas d'annonce correspondante !!");
		         }
				   
				  r�sultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
				}
			affiche("fin du programme");
		    System.exit(0);  
		}
	}
	
	public void filtreAnnoucementPrix () {
		
		requete = "SELECT * FROM vintud.announcement  ORDER BY price ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+"that's the price : "+r�sultats.getFloat("price")
					+"\n"+r�sultats.getByte("picture")
					+"\n"+r�sultats.getTimestamp("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
	}
	
	public void filtreAnnoucementLocalisation () {
		
		requete = "SELECT * FROM vintud.announcement  ORDER BY localisation ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+r�sultats.getFloat("price")
					+"\n"+r�sultats.getByte("picture")
					+"\n"+r�sultats.getTimestamp("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+"that's the localisation : "+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
	}

	public void voirNombreVues (String email, String pwd) {
		
		User userConnected = userDAO.connectAccount(email,pwd) ;
		
		requete = "SELECT * FROM vintud.announcement WHERE user_id = "+userConnected.getId_user()+"; ";
		
		
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				 System.out.println("***********voici le nombre de vue pour chacune de vos annonces *************");
				   System.out.println("*********** new announcement ********");
				   System.out.println("id announcement : "+r�sultats.getInt("id")
					+"\n"+"title of your annoucement : " +  r�sultats.getString("title")
					+"\n" +" description of your annoucement : "  +r�sultats.getString("description")
					+"\n"+" number of view of your annoucement : " +r�sultats.getInt("view_number"));
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
	}

	public ArrayList<Announcement> findAnnounceByIdUser(int id){
		
		ArrayList<Announcement> listAnnonces = new ArrayList<Announcement>() ;
		
		requete = "SELECT * FROM vintud.announcement WHERE user_id ="+id+"  ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         
	         boolean encore = r�sultats.next();
			  while (encore) {
				  Announcement annonce = new Announcement() ;
				  annonce.setId_annoucement(r�sultats.getInt("id"));
				  annonce.setTitle(r�sultats.getString("title"));
				  annonce.setDescription(r�sultats.getString("description"));
				  annonce.setCategory_id(r�sultats.getInt("category_id"));
				  annonce.setPrice(r�sultats.getInt("price"));
				  annonce.setPicture(r�sultats.getString("picture"));
				  annonce.setPublication_date(r�sultats.getString("publication_date"));
				  annonce.setIs_available(r�sultats.getBoolean("is_available"));
				  annonce.setView_number(r�sultats.getInt("view_number"));
				  annonce.setLocalisation(r�sultats.getString("localisation"));
				  annonce.setUser_id(r�sultats.getInt("user_id") );
				  
				  listAnnonces.add(annonce) ;	
				   encore = r�sultats.next();
			   }
			   
			  r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
		return listAnnonces ;
	}
	
	public ArrayList<Announcement> findAllAnnoucement(){
		
		ArrayList<Announcement> listAnnonces = new ArrayList<Announcement>() ;
		
		requete = "SELECT * FROM vintud.announcement  ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         
	         boolean encore = r�sultats.next();
			  while (encore) {
				  Announcement annonce = new Announcement() ;
				  annonce.setId_annoucement(r�sultats.getInt("id"));
				  annonce.setTitle(r�sultats.getString("title"));
				  annonce.setDescription(r�sultats.getString("description"));
				  annonce.setCategory_id(r�sultats.getInt("category_id"));
				  annonce.setPrice(r�sultats.getInt("price"));
				  annonce.setPicture(r�sultats.getString("picture"));
				  annonce.setPublication_date(r�sultats.getString("publication_date"));
				  annonce.setIs_available(r�sultats.getBoolean("is_available"));
				  annonce.setView_number(r�sultats.getInt("view_number"));
				  annonce.setLocalisation(r�sultats.getString("localisation"));
				  annonce.setUser_id(r�sultats.getInt("user_id") );
				  
				  listAnnonces.add(annonce) ;	
				   encore = r�sultats.next();
			   }
			   
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
		return listAnnonces ;
		
	}
	
public void consulterAnnonces () {
		
		
    	requete = "SELECT * FROM vintud.announcement ; ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+r�sultats.getInt("price")
					+"\n"+r�sultats.getString("picture")
					+"\n"+r�sultats.getString("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
	}

	@Override
	public int addAnnouncement(Announcement announcement) {

		  
		int status = 0 ;
		
			
		String title = "'"+announcement.getTitle()+"'" ;
		String description ="'"+announcement.getDescription()+"'" ;
		String picture ="'"+ announcement.getPicture() +"'";
		String date = "'"+announcement.getPublication_date() +"'";
		String localisation = "'"+announcement.getLocalisation() + "'" ;
		
		
		
		
		
		requete="INSERT INTO vintud.announcement values ("+announcement.getId_annoucement()+","+ title+","+description+","+announcement.getCategory_id()+","+announcement.getPrice()+","+picture+","+date+","+announcement.isIs_available()+","+announcement.getView_number()+","+localisation+","+announcement.getUser_id() +");" ;



		try {
			Statement stmt = con.createStatement();
	        status = stmt.executeUpdate(requete) ;        
	        System.out.println("Your profile has been saved !! Congrat ;)  ");
		} 
		catch (SQLException e) {
			status=-1 ;
		}
		affiche("fin du programme");
		return status ;
		
	}
	*/


	

	

    

