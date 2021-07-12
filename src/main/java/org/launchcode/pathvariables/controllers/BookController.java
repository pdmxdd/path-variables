package org.launchcode.pathvariables.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    // GET /book -> returns a JSON List of all the books
    @GetMapping
    @ResponseBody
    public ArrayList<HashMap<String, String>> getBooks() {
        return generateBooks();
    }

    // GET /book/author/authorName -> returns a JSON List of all the books matching the path variable authorName
    @GetMapping(value = "/author/{authorName}")
    @ResponseBody
    public ArrayList<HashMap<String, String>> getBooksByAuthor(@PathVariable String authorName) {
        ArrayList<HashMap<String, String>> books = generateBooks();
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("author").equals(authorName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // GET /book/title/titleName -> Returns a JSON List of all the books matching the path variable titleName
    @GetMapping(value = "/title/{titleName}")
    @ResponseBody
    public ArrayList<HashMap<String, String>> getBooksByTitle(@PathVariable String titleName) {
        ArrayList<HashMap<String, String>> books = generateBooks();
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("title").equals(titleName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // helper method. it just generates and returns a list of book-like objects (HashMaps)
    public ArrayList<HashMap<String, String>> generateBooks() {
        ArrayList<HashMap<String, String>> books = new ArrayList<>();
        HashMap<String, String> bookOne = new HashMap<>();
        bookOne.put("title", "It");
        bookOne.put("author", "King");
        bookOne.put("ISBN", "9048qhf");
        HashMap<String, String> bookTwo = new HashMap<>();
        bookTwo.put("title", "Understanding Ecmascript 6");
        bookTwo.put("author", "Zakas");
        bookTwo.put("ISBN", "1-59327-757-1");
        HashMap<String, String> bookThree = new HashMap<>();
        bookThree.put("title", "Salem's Lot");
        bookThree.put("author", "King");
        bookThree.put("ISBN", "43q0978yf");
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        return books;
    }
}
