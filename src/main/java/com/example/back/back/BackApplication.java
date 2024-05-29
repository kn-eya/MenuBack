package com.example.back.back;

import com.example.back.back.entities.*;
import com.example.back.back.security.entities.AppRole;
import com.example.back.back.security.entities.AppUser;
import com.example.back.back.security.services.IAccountService;
import com.example.back.back.services.AppConfig;
import com.example.back.back.services.impls.AdminService;
import com.example.back.back.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
@Import(AppConfig.class)

public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
    //@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
}



	@Bean
	CommandLineRunner start(IArticle iArticle, IAccountService iAccountService, IMarket iMarket, ICategorie iCategorie,
							IAdmin _adminService  , IManager managerService){

		return args -> {

			SuperAdmin sp = new SuperAdmin();
			sp.setUserName("admin");
			sp.setPassword("password");

            iAccountService.addNewRole(new AppRole(null,"SuperAdmin"));
		    iAccountService.addNewRole(new AppRole(null,"Admin"));
		    iAccountService.addNewRole(new AppRole(null,"Manager"));

		    iAccountService.addNewUser(new AppUser(null,"user", "user1","1234",new ArrayList<>()));
			Admin admin = new Admin();
			admin.setNom("ahmed");
			admin.setUserName("ahmed");
			admin.setPassword("1234");
			Admin adminCreated = _adminService.create(admin);

			iAccountService.addRoleToUser("user1","SuperAdmin");
			iAccountService.addRoleToUser("ahmed","Admin");




			Manager manager = new Manager();
			manager.setNom("eya");
			manager.setUserName("eya");
			manager.setPassword("1234");
			manager.setAdmin(adminCreated);
			managerService.create(manager);
			iAccountService.addRoleToUser("eya","Manager");


			Market market = new Market();
			market.setLibelle("ELhaj");
			market.setEmail("a@a.com");


			market.setAdmin(adminCreated);
			iMarket.create(market);

			Categorie categorie = new Categorie();
			categorie.setLibelle("Boisson");
			categorie.setNiveau(0);
			categorie.setMarket(market);
             iCategorie.create(categorie);
			Categorie categorie2 = new Categorie();
			categorie2.setLibelle("Plat");
			categorie2.setNiveau(0);
			categorie2.setMarket(market);
			iCategorie.create(categorie2);

			Categorie chaud = new Categorie();
			chaud.setLibelle("Chaud");
			chaud.setNiveau(1);
			chaud.setMarket(market);
			chaud.setSupCategorie(categorie);
			iCategorie.create(chaud);

			Categorie froid = new Categorie();
			froid.setLibelle("Froid");
			froid.setNiveau(1);
			froid.setMarket(market);
			froid.setSupCategorie(categorie);
			iCategorie.create(froid);

			Categorie glace = new Categorie();
			glace.setLibelle("Glace");
			glace.setNiveau(2);
			glace.setMarket(market);
			glace.setSupCategorie(froid);
			iCategorie.create(glace);

			Categorie jus = new Categorie();
			jus.setLibelle("Jus");
			jus.setNiveau(2);
			jus.setMarket(market);
			jus.setSupCategorie(froid);
			iCategorie.create(jus);

			Categorie entree = new Categorie();
			entree.setLibelle("Entree");
			entree.setNiveau(1);
			entree.setMarket(market);
			entree.setSupCategorie(categorie2);
			iCategorie.create(entree);

			Categorie suite = new Categorie();
			suite.setLibelle("Suite");
			suite.setNiveau(1);
			suite.setMarket(market);
			suite.setSupCategorie(categorie2);
			iCategorie.create(suite);


			//init article
			Article article = new Article();
			article.setTitle("coffee");
			article.setPrix(5.00);
			article.setCategorie(chaud);
			iArticle.create(article);
			Article article2 = new Article();
			article2.setTitle("Jus");
			article.setPrix(10.0);
			article2.setCategorie(jus);
			iArticle.create(article2);

			Article article3 = new Article();
			article3.setTitle("Kaftaji");
			article3.setPrix(8.00);
			article3.setCategorie(suite);
			iArticle.create(article3);

			Article article4 = new Article();
			article4.setTitle("Shan Tounsi");
			article4.setPrix(10.00);
			article4.setCategorie(suite);
			iArticle.create(article4);

			Article salade = new Article();
			salade.setTitle("Salade");
			salade.setPrix(10.00);
			salade.setCategorie(entree);
			iArticle.create(salade);


			Article brik = new Article();
			brik.setTitle("Brik au thon");
			brik.setPrix(10.00);
			brik.setCategorie(entree);
			iArticle.create(brik);

			Article glacedeuxBoule = new Article();
			glacedeuxBoule.setTitle("glace deux boules");
			glacedeuxBoule.setPrix(10.00);
			glacedeuxBoule.setCategorie(glace);
			iArticle.create(glacedeuxBoule);

			Article glaceuneBoule = new Article();
			glaceuneBoule.setTitle("glace une boules");
			glaceuneBoule.setPrix(10.00);
			glaceuneBoule.setCategorie(glace);
			iArticle.create(glaceuneBoule);




		};


	};

	}


