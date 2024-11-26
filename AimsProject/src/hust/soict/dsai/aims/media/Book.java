package hust.soict.dsai.aims.media;

import java.util.*;

public class Book {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void addAuthor(String authorName) {
		boolean inList = false;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i) == authorName) {
				inList = true;
			}
		}
		if (inList) {
			System.out.println("Author already in list.");
		} else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " successfully added.");
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean inList = false;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i) == authorName) {
				inList = true;
				authors.remove(i);
				System.out.println("Author " + authorName + " successfully removed.");
			}
		}
		if (inList == false) {
			System.out.println("Author not in list.");
		} 
	}
	
}
