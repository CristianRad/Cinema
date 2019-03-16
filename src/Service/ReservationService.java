package Service;

import Domain.Client;
import Domain.Reservation;
import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {

    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;
    private FilmRepository filmRepository;

    /**
     * Instantiates a service for reservations.
     * @param reservationRepository is the repository used.
     */

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, FilmRepository filmRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.filmRepository = filmRepository;
    }

    /**
     * Adds a reservation.
     * @param id is the ID of the reservation.
     * @param idFilm is the ID of the film on the reservation.
     * @param idCardClient is the ID of the client on the reservation.
     * @param date is the date when the reservation was made.
     * @param time is the time when the reservation was made.
     */

    public void addReservation(String id, String idFilm, String idCardClient, String date, String time) {
        Reservation reservation = new Reservation(id, idFilm, idCardClient, date, time);
        reservationRepository.insert(reservation);
        if (clientRepository.getClientStorage().containsKey(idCardClient)) {
            Client cardClient = clientRepository.findById(idCardClient);
            int bonusPoints = cardClient.getPoints();
            cardClient.setPoints(bonusPoints + (int)filmRepository.getFilmStorage().get(idFilm).getTicketPrice() / 10); }
    }

    /**
     * Updates a reservation.
     * @param id is the new ID of the reservation.
     * @param idFilm is the new ID of the film on the reservation.
     * @param idCardClient is the new ID of the client on the reservation.
     * @param date is the new date when the reservation was made.
     * @param time is the new time when the reservation was made.
     */

    public void updateReservation(String id, String idFilm, String idCardClient, String date, String time) {
        Reservation reservation = new Reservation(id, idFilm, idCardClient, date, time);
        reservationRepository.update(reservation);
    }

    /**
     * Removes a reservation.
     * @param id is the ID of the reservation to remove.
     */

    public void removeReservation(String id) {
        reservationRepository.remove(id);
    }

    /**
     * @return a list of all reservations.
     */

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAll();
    }

}
