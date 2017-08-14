package com.ex.tests;

import com.ex.books.Book;

import genres.Genre;

public class Test {

	public static void main(String[] args) {
		//Genre genre = new Genre(); cant instantiate abstract class
		
		Genre genre = new Book(); //create a basic genre based on Book
		
		Book emptyBook = new Book();//create empty book
		
		//create a real book
		Book hobbit = new Book("The Hobbit", "J.R.R. Tolkien", "A hobbit hole", 300, "Fantasy");
		
		genre.getGenre();
		genre.close();
		System.out.println(""); //new line
		
		emptyBook.open();
		System.out.println("Author: " + emptyBook.getAuthor());
		emptyBook.getGenre();
		emptyBook.readBook(5);
		System.out.println(""); //new line
		
		hobbit.open();
		hobbit.getTitle();
		hobbit.getGenre();
		hobbit.readBook(50);
		hobbit.readBook(50, 300);
		System.out.println("Done reading? : " + hobbit.isDoneReading());
		hobbit.close();
	}

}
