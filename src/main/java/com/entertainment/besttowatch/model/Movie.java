package com.entertainment.besttowatch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table( name= "movies")
@Data
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "details", length=512)
	private String details;
	
	@Column(name = "ratings")
	private String ratings;
	
	@ManyToOne()
	@JoinColumn(name="platform_id")
	private Platform platform;
	
	@ManyToMany
	@JoinTable(name = "movies_actors",
    joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "id",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "actor_id", referencedColumnName = "id",
                    nullable = false, updatable = false)})
	@JsonIgnoreProperties("movies")
	private List<Actor> actors;

}
