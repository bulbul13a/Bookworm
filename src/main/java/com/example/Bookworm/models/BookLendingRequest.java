package com.example.Bookworm.models;

import java.util.Date;
import java.util.List;

import com.example.Bookworm.enums.RequestStatus;
import com.example.Bookworm.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "book_requests")
public class BookLendingRequest extends Root{
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date approvalDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date estimatedReturnDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date returnDate;
	
	@Enumerated(EnumType.STRING)
	private Status lendRequestStatus;
	
	
	@Enumerated(EnumType.STRING)
	private RequestStatus reqStatus;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private BookwormUser requester;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_requests_id", referencedColumnName = "id")
	private List<Book> books;
	

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Status getLendRequestStatus() {
		return lendRequestStatus;
	}

	public void setLendRequestStatus(Status lendRequestStatus) {
		this.lendRequestStatus = lendRequestStatus;
	}

	public BookwormUser getRequester() {
		return requester;
	}

	public void setRequester(BookwormUser requester) {
		this.requester = requester;
	}
	
	public RequestStatus getReqStatus() {
		return reqStatus;
	}
	
	public void setReqStatus(RequestStatus reqStatus) {
		this.reqStatus = reqStatus;
	}
}