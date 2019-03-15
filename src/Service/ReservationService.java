package Service;

import Domain.Reservation;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {

    private ReservationRepository reservationRepository;

    /**
     * Instantiates a service for reservations.
     * @param reservationRepository is the repository used.
     */

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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
