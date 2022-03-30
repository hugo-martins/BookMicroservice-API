package br.com.phoebustecnologia.BookMicroservice.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
        super("the book with the specific id does not exist");
    }
}
