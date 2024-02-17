package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Feb 15, 2024
 */
@Entity
public class Weapon {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int damage;
	@ManyToOne
	private Unit unit;
	
	public Weapon() {
		super();
	}
	public Weapon(int id, String name, int damage) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
	}
	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
