package com.luna.entities;

public class User {
	private int id;
	private String Login;
	private String MdP;
	private int Rang;
	
	public User() {
		super();
	}

	public User(int id, String login, String mdP, int rang) {
		super();
		this.id = id;
		Login = login;
		MdP = mdP;
		Rang = rang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMdP() {
		return MdP;
	}

	public void setMdP(String mdP) {
		MdP = mdP;
	}

	public int getRang() {
		return Rang;
	}

	public void setRang(int rang) {
		Rang = rang;
	}
	
	
	}


