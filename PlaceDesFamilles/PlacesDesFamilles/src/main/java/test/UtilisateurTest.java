package main.java.test;

import static org.junit.Assert.assertEquals;
import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;
import main.java.services.interfaces.IUtilisateurService;
import net.bytebuddy.utility.RandomString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilisateurTest {

	private static IUtilisateurService utilisateurService;
	
	private static Utilisateur utilisateurToFind;
	private static String randomLogin;
	private static String randomNom;
	private static String randomPrenom;
	private static String randomPassword;
	private static String randomToken;

    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
    	System.out.println("@BeforeClass - runOnceBeforeClass");
    	
    	/** Mise en place du context spring **/
    	ApplicationContext context = new ClassPathXmlApplicationContext("./applicationContext.xml");
    	utilisateurService = (IUtilisateurService) context.getBean("utilisateurService");
    	
        randomLogin = RandomString.make();
        randomNom = RandomString.make();
        randomPrenom = RandomString.make();
        randomPassword = RandomString.make();
        randomToken = RandomString.make();
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
        
        
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() throws ExceptionFonctionnelle, ExceptionTechnique {
        System.out.println("@Before - runBeforeTestMethod");
        
        /** Création d'un utilisateur aléatoire pour effectuer les tests **/
		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setLogin(randomLogin);
		utilisateur.setCivilite("Mr");
		utilisateur.setPassword(randomPassword);
		utilisateur.setNom(randomNom);
		utilisateur.setPrenom(randomPrenom);
		utilisateur.setRole("CLIENT");
		
		utilisateurService.creerUtilisateur(utilisateur);
		utilisateurToFind = utilisateur;
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() throws ExceptionFonctionnelle, ExceptionTechnique {
        System.out.println("@After - runAfterTestMethod");
        utilisateurService.supprimerUtilisateur(utilisateurToFind);
    }

	@Test
	public void trouverUtilisateur() throws ExceptionFonctionnelle, ExceptionTechnique {
		Utilisateur utilisateur = utilisateurService.chercherUtilisateur(utilisateurToFind.getId());
		
		assertEquals(utilisateur.getLogin(), randomLogin);		
		assertEquals(utilisateur.getPrenom(), randomPrenom);
		assertEquals(utilisateur.getNom(), randomNom);
		assertEquals(utilisateur.getPassword(), randomPassword);
	}
	
	@Test
	public void verifierUtilisateurParToken() throws ExceptionFonctionnelle, ExceptionTechnique {
		
		/** Test de la mise à jour du token **/
		mettreAJourTokenUtilisateur();
		
		/** Vérification de la validité du token **/
		Utilisateur utilisateur = utilisateurService.verifierUtilisateurParToken(randomLogin, randomToken);
		assertEquals(utilisateur.getLogin(), randomLogin);
	}
	
	public void mettreAJourTokenUtilisateur() throws ExceptionFonctionnelle, ExceptionTechnique {
		utilisateurService.mettreAJourTokenUtilisateur(utilisateurToFind, randomToken);
		Utilisateur utilisateur = utilisateurService.chercherUtilisateur(utilisateurToFind.getId());
		assertEquals(utilisateur.getToken(), randomToken);
	}
	
	@Test
	public void authentiferUtilisateur() throws ExceptionFonctionnelle, ExceptionTechnique{
		Utilisateur utilisateur  = utilisateurService.authentifierUtilisateur(utilisateurToFind);
		assertEquals(utilisateur.getLogin(), utilisateurToFind.getLogin());
	}
}
