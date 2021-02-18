package kg.megacom.services;

import kg.megacom.models.Client;
import kg.megacom.services.impl.ClientServiceImpl;

public interface ClientService {

    ClientService INSTANCE = new ClientServiceImpl();

    Client createClient(String name, String idCard);
    Client findClientByIdCard(String idCard);
    boolean blockClient(String idCard);
    void showClients();


}
