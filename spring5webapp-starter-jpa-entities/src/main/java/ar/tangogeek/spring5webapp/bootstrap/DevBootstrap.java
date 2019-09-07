package ar.tangogeek.spring5webapp.bootstrap;

import ar.tangogeek.spring5webapp.model.Author;
import ar.tangogeek.spring5webapp.model.Book;
import ar.tangogeek.spring5webapp.model.Publisher;
import ar.tangogeek.spring5webapp.repositories.AuthorRepository;
import ar.tangogeek.spring5webapp.repositories.BookRepository;
import ar.tangogeek.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository ar, BookRepository br, PublisherRepository pr){
        this.authorRepository = ar;
        this.bookRepository = br;
        this.publisherRepository = pr;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //initData();
        initData();
    }

    private void initData() {
        Publisher p=new Publisher();
        p.setName("REILLY");
        p.setAddress("123 main st");
        publisherRepository.save(p);

        Author eric=new Author("eric","evans");
        authorRepository.save(eric);

        Book ddd=new Book("Domain Driven Design Distilled", "1234");
        ddd.setPublisher(p);
        ddd.getAuthors().add(eric);
        bookRepository.save(ddd);

    }
}
