package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.repositories.AuthtirRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthtirRepository authtirRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthtirRepository authtirRepository, BookRepository bookRepository) {
        this.authtirRepository = authtirRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authtirRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development with EJB", "23444","Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authtirRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
