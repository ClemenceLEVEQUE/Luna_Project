package com.luna.dao;

import java.util.List;
import com.luna.entities.Client;

public interface ClientDAO {

	public void insertClient(Client Art);

	public void updateClient(Client Art);

	public void removeClient(int idClient);

	public Client getClient(int idClient);

	public List<Client> getAllClient();

}
