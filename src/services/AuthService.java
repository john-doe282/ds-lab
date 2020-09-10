package services;

import entities.Client;
import entities.MarketPlace;
import entities.Owner;

import java.util.ArrayList;

public final class AuthService {
    private final MarketPlace marketPlace;

    public AuthService(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public void registerClient(Client client) {
        ArrayList<Client> clients = marketPlace.getClients();
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }
    public void registerOwner(Owner owner) {
        ArrayList<Owner> owners = marketPlace.getOwners();
        if (!owners.contains(owner)) {
            owners.add(owner);
        }
    }
}
