package hh.minhhn.bookstore.hh.minhhn.bookstore.web;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.Book;
import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.BookRepository;
import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void doSomething() {

    }

    @RequestMapping(value = "/booklist")
    public String booklist(Model model) {
        List<Book> bookList = new ArrayList<Book>();
        model.addAttribute("booklist", bookRepository.findAll());
        return "booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.delete(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.findOne(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    // RESTful service to get all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to get student by id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return (Book) bookRepository.findOne(bookId);
    }

    // Login
    @RequestMapping(value = "/login")
    public String login() { return "login"; }
}
