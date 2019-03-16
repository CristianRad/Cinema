import Domain.ClientValidator;
import Domain.FilmValidator;
import Domain.ReservationValidator;
import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.ReservationRepository;
import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        FilmValidator filmValidator = new FilmValidator();
        FilmRepository filmRepository = new FilmRepository(filmValidator);
        FilmService filmService = new FilmService(filmRepository);

        ClientValidator clientValidator = new ClientValidator();
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        ClientService clientService = new ClientService(clientRepository);

        ReservationValidator reservationValidator = new ReservationValidator(filmRepository);
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator, filmRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, clientRepository, filmRepository);

        Console console = new Console(filmService, clientService, reservationService);

        console.run();
    }

}
