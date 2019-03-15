package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository clientRepository;

    /**
     * Instantiates a service for clients.
     * @param clientRepository is the repository used.
     */

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Adds a client.
     * @param id is the ID of the client to add.
     * @param name is the name of the client to add.
     * @param surname is the surname of the client to add.
     * @param cnp is the CNP of the client to add.
     * @param birthday is the birthday of the client to add.
     * @param registrationDay is the registration day of the client to add.
     * @param points is the total of points on the card of the client to add.
     */

    public void addClient(String id, String name, String surname, String cnp, String birthday, String registrationDay, int points) {
        Client client = new Client(id, name, surname, cnp, birthday, registrationDay, points);
        clientRepository.insert(client);
    }

    /**
     * Updates a client.
     * @param id is the new ID of the client.
     * @param name is the new name of the client.
     * @param surname is the new surname of the client.
     * @param cnp is the new CNP of the client.
     * @param birthday is the new birthday of the client.
     * @param registrationDay is the new registration day of the client.
     * @param points is the new total of points on the card of the client.
     */

    public void updateClient(String id, String name, String surname, String cnp, String birthday, String registrationDay, int points) {
        Client client = new Client(id, name, surname, cnp, birthday, registrationDay, points);
        clientRepository.update(client);
    }

    /**
     * Removes a client.
     * @param id is the ID of the client to remove.
     */

    public void removeClient(String id) {
        clientRepository.remove(id);
    }

    /**
     * @return a list of all clients.
     */

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

}
