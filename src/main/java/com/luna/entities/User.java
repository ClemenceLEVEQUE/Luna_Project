package com.luna.entities;

public class User {
	private int id;
	private String login;
	private String mdp;
	private int rang;

	public User() {
		super();
	}

	public User(String login, String mdp, int rang) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.rang = rang;
	}
	
	public User(String login, String pwd) {
		this.login = login;
		this.mdp = pwd;
		this.rang = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdP() {
		return mdp;
	}

	public void setMdP(String mdp) {
		this.mdp = mdp;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}
}
