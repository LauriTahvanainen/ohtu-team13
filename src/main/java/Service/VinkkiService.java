package Service;

import Domain.Book;
import Domain.Movie;
import Dao.BookDao;
import Dao.MovieDao;
import Domain.Url;
import Dao.UrlDao;
import java.util.ArrayList;

public class VinkkiService {

    private BookDao bookDao;
    private UrlDao urlDao;
    private MovieDao movieDao;

    public VinkkiService(BookDao bookDao, UrlDao urlDao, MovieDao movieDao) {
        this.bookDao = bookDao;
        this.urlDao = urlDao;
        this.movieDao = movieDao;
    }

    public boolean addBook(Book book) {
        return this.bookDao.createBook(book);
    }

    public boolean addURL(Url url) {
        boolean palautus;
        palautus = this.urlDao.createURL(url);
        // System.out.println(palautus);
        return palautus;
    }

    public boolean addMovie(Movie movie) {
        boolean palautus;
        palautus = this.movieDao.createMovie(movie);
        return palautus;
    }

    public ArrayList<Book> listBooks() {
        return this.bookDao.getAllBooks();
    }
    
    public boolean modifyBook(Book book) {
        return this.bookDao.modifyBook(book);
    }
    
    public boolean deleteBook(int id) {
        return this.bookDao.deleteBook(id);
    }
    
    public boolean modifyMovie(Movie movie) {
        return this.movieDao.modifyMovie(movie);
    }
    
    public boolean deleteMovie(int id) {
        return this.movieDao.deleteMovie(id);
    }
    
    public boolean modifyUrl(Url url) {
        return this.urlDao.modifyURL(url);
    }

    public boolean deleteUrl(int id) {
        return this.urlDao.deleteURL(id);
    }
    
    public Book searchBookByISBN(String ISBN) {
        return this.bookDao.findByISBN(ISBN);
    }

    public ArrayList<Book> searchBookByAuthor(String author) {
        return this.bookDao.findByKirjoittaja(author);
    }

    public ArrayList<Book> searchBookByName(String name) {
        return this.bookDao.findByNimeke(name);
    }

    public ArrayList<Url> listURLs() {
        return this.urlDao.getAllURLs();
    }

    public ArrayList<Url> searchUrlByName(String name) {
        return this.urlDao.findByOtsikko(name);
    }
    
    public Book findBookByAuthorAndTitle(String author, String title) {
        return this.bookDao.findWithAuthorAndTitle(author, title);
    }

    public ArrayList<Movie> listMovies() {
        return this.movieDao.getAllMovies();
    }
}
