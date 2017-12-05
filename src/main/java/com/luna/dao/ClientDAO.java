package com.luna.dao;

import java.util.ArrayList;
import java.util.List;
import com.luna.entities.Client;

public interface ClientDAO {

	public void insertClient(Client Cli);

	public void updateClient(Client Cli);

	public boolean removeClient(int idClient);

	public Client getClient(int idClient);

	public ArrayList<Client> getAllClient();

}
