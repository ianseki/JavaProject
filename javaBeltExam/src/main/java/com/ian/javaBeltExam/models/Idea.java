package com.ian.javaBeltExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ideas")
public class Idea 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="Can not be empty")
	private String name;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="users_ideas",
		joinColumns = @JoinColumn(name="idea_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
	)
    private List<User> peopleWhoLikedIdea;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<User> getPeopleWhoLikedIdea() {
		return peopleWhoLikedIdea;
	}
	public void setPeopleWhoLikedIdea(List<User> peopleWhoLikedIdea) {
		this.peopleWhoLikedIdea = peopleWhoLikedIdea;
	}
    
}
