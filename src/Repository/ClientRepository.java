package Repository;

import Domain.Client;
import Domain.ClientValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRepository {

    private Map<String, Client> storage = new HashMap<>();
    private ClientValidator clientValidator;

    /**
     * Instantiates a repository for clients.
     * @param clientValidator is the validator used.
     */

    public ClientRepository(ClientValidator clientValidator) {
        this.clientValidator = clientValidator;
    }

    /**
     * Finds a client by ID.
     * @param id is the ID of the client to find.
     * @return the client with the given ID if he does exist.
     */

    public Client findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds a client to storage
     * @param client is the client to add.
     */

    public void insert(Client client) {
        if (storage.containsKey(client.getId()))
            throw new RuntimeException(String.format("A client with the ID %s already exists!", client.getId()));
        clientValidator.validate(client);
        storage.put(client.getId(), client);
    }

    /**
     * Updates a client from storage.
     * @param client is the client to update.
     */

    public void update(Client client) {
        if (!storage.containsKey(client.getId()))
            throw new RuntimeException(String.format("There is no client with the ID %s!", client.getId()));
        clientValidator.validate(client);
        storage.put(client.getId(), client);
    }

    /**
     * Removes a client from storage.
     * @param id is the ID of the client to remove.
     */

    public void remove(String id) {
        if (!storage.containsKey(id))
            throw new RuntimeException(String.format("There is no client with the ID %s!", id));
        storage.remove(id);
    }

    /**
     * @return a list of all clients.
     */

    public List<Client> getAll() {
        return new ArrayList<>(storage.values());
    }

}
