package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	
	private ArrayList<String> authors;

	public Book() {
		this.authors = new ArrayList<String>();
	}
	
	public void addAuthor(String authorName) {
		boolean inList = false;
		for (int i = 0; i < this.authors.size(); i++) {
			if (this.authors.get(i) == authorName) {
				inList = true;
			}
		}
		if (inList) {
			System.out.println("Author already in list.");
		} else {
			this.authors.add(authorName);
			System.out.println("Author " + authorName + " successfully added.");
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean inList = false;
		for (int i = 0; i < this.authors.size(); i++) {
			if (this.authors.get(i) == authorName) {
				inList = true;
				this.authors.remove(i);
				System.out.println("Author " + authorName + " successfully removed.");
			}
		}
		if (inList == false) {
			System.out.println("Author not in list.");
		} 
	}
	
}
