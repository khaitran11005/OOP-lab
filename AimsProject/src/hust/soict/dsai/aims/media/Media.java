package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	

	public Media() {
		super();
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
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

	// this method was originally in DigitalVideoDisc, migrated here so that searchTitle in Cart would continue working
	public boolean isMatch(String title) {
		if (this.title.toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals(Object media) {
		Media castMedia = (Media) media;
		if (this.title == castMedia.getTitle()) {
			return true;
		} else {return false;}
	}

	public abstract void play();
	
}
