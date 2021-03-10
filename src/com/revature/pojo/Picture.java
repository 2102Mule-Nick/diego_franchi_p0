package com.revature.pojo;

public class Picture {
	
	private String title;
	
	private String filename;
	
	private String details;

	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Picture(String title, String filename, String details) {
		super();
		this.title = title;
		this.filename = filename;
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
