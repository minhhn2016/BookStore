package hh.minhhn.bookstore.hh.minhhn.bookstore.web;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.Book;
import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    public void doSomething() {

    }

    @RequestMapping(value = "/booklist")
    public String booklist(Model model) {
        List<Book> bookList = new ArrayList<Book>();
        model.addAttribute("booklist", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.delete(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findOne(id));
        return "editbook";
    }

}
