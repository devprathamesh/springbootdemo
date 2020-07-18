package dev.prathamesh.springbootdemo.bootstrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.prathamesh.springbootdemo.domain.Auther;
import dev.prathamesh.springbootdemo.domain.Book;
import dev.prathamesh.springbootdemo.domain.Publisher;
import dev.prathamesh.springbootdemo.repositories.AutherRepository;
import dev.prathamesh.springbootdemo.repositories.BookRepository;
import dev.prathamesh.springbootdemo.repositories.PublisherRepository;

@Component
public class DataBootstrap implements CommandLineRunner {
	
	private AutherRepository autherRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DataBootstrap(AutherRepository autherRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.autherRepository = autherRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher rajhansPrakashan = new Publisher("Rajhans Prakashan", "Address Line 1", "Mumbai", "Suburb");
		publisherRepository.save(rajhansPrakashan);
		
		Publisher parchurePrakashan = new Publisher("Parchure Prakashan", "Goregaonkar Lane", "Mumbai", "Girgaon");
		publisherRepository.save(parchurePrakashan);

		Auther achyutGodbole = new Auther("Achyut", "Godbole");
		autherRepository.save(achyutGodbole);

		//Books of achyutGodbole
		Book arthat = new Book("Arthat", "8174347062");
		arthat.getAuthers().add(achyutGodbole);
		arthat.setPublisher(rajhansPrakashan);
		Book kimayagar = new Book("Kimayagar", " 817434697X");
		kimayagar.getAuthers().add(achyutGodbole);
		kimayagar.setPublisher(rajhansPrakashan);
		Book musafir = new Book("Musafir", "9386118270");
		musafir.getAuthers().add(achyutGodbole);
		musafir.setPublisher(rajhansPrakashan);
		achyutGodbole.getBooks().addAll(Arrays.asList(musafir, kimayagar, arthat));
		bookRepository.saveAll(Arrays.asList(musafir, kimayagar, arthat));
		
		Auther vinayakSavarkar = new Auther("Vinayak", "Savarkar");
		autherRepository.save(vinayakSavarkar);

		//Books of vinayakSavarkar
		Book mazhiJanmthep = new Book("Mazhi Janmthep", "8186530126");
		mazhiJanmthep.getAuthers().add(vinayakSavarkar);
		mazhiJanmthep.setPublisher(parchurePrakashan);
		Book chhahaSwarnimPristha = new Book("Chhaha Swarnim Pristha", "8173156859");
		chhahaSwarnimPristha.getAuthers().add(vinayakSavarkar);
		chhahaSwarnimPristha.setPublisher(parchurePrakashan);
		Book hindutva = new Book("Hindutva", "9389982111");
		hindutva.getAuthers().add(vinayakSavarkar);
		hindutva.setPublisher(parchurePrakashan);
		
		vinayakSavarkar.getBooks().addAll(Arrays.asList(mazhiJanmthep, chhahaSwarnimPristha, hindutva));
		bookRepository.saveAll(Arrays.asList(mazhiJanmthep, chhahaSwarnimPristha, hindutva));
		
		System.out.println("******************* Saving Entities *******************");
		System.out.println("Saved Books : " + bookRepository.count());
		System.out.println("Saved Authers : " + autherRepository.count());
		System.out.println("Saved Publishers : " + publisherRepository.count());
		System.out.println("************************** # **************************");


		
		
	}

}
