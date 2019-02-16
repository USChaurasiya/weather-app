package com.us.wapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity Class To maintain the History of the User search.
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
@Entity
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="hId", strategy="increment")
	@GeneratedValue(generator="hId")
	private int id;

	@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade= CascadeType.DETACH)
    @JoinColumn(name = "u_id", nullable = false, unique = false)
	private User user;

	private String searchCity;

	private LocalDateTime historyTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSearchCity() {
		return searchCity;
	}

	public void setSearchCity(String searchCity) {
		this.searchCity = searchCity;
	}

	public LocalDateTime getHistoryTime() {
		return historyTime;
	}

	public void setHistoryTime(LocalDateTime historyTime) {
		this.historyTime = historyTime;
	}

}
