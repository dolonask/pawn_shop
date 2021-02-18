package kg.megacom.services.impl;

import kg.megacom.exceptions.ClientNotFound;
import kg.megacom.models.Client;
import kg.megacom.services.ClientService;

import java.util.ArrayList;
import java.util.Collections;

public class ClientServiceImpl implements ClientService {

    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public Client createClient(String name, String idCard) {
        Client client = new Client(name, idCard);
        clients.add(client);
        return client;
    }

    @Override
    public Client findClientByIdCard(String idCard) {

        for (Client client: clients) {
            if (client.getIdCard().equals(idCard)){
                return client;
            }
        }

        throw new ClientNotFound("Клиент не найден. ID Card = " + idCard);
    }

    @Override
    public boolean blockClient(String idCard) {
        Client client = findClientByIdCard(idCard);
        client.setBlocked(true);



        //clients.set(clients.indexOf(client), client);
        return true;
    }

    @Override
    public void showClients() {
        for (Client client: clients) {

            System.out.println("ID = " + client.getId() +". NAME = " + client.getName() + ". ID CARD = " + client.getIdCard() + ". BLOCKED = " + client.isBlocked());


        }
    }
}
