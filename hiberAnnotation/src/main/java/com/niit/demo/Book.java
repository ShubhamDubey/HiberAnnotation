package com.niit.demo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title, description;

	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLISHED")
	private Date publishedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
