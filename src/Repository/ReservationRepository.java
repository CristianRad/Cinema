package Repository;

import Domain.Reservation;
import Domain.ReservationValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationRepository {

    private Map<String, Reservation> storage = new HashMap<>();
    private ReservationValidator reservationValidator;

    /**
     * Instantiates a repository for reservations.
     * @param reservationValidator is the validator used.
     */

    public ReservationRepository(ReservationValidator reservationValidator) {
        this.reservationValidator = reservationValidator;
    }

    /**
     * Finds a reservation by ID.
     * @param id is the ID of the reservation to find.
     * @return the reservation with the given ID if it does exist.
     */

    public Reservation findById(String id) { return storage.get(id); }

    /**
     * Adds a reservation to storage.
     * @param reservation is the reservation to add.
     */

    public void insert(Reservation reservation) {
        if (storage.containsKey(reservation.getId()))
            throw new RuntimeException(String.format("A reservation with the ID %s already exists!", reservation.getId()));
        reservationValidator.validate(reservation);
        storage.put(reservation.getId(), reservation);
    }

    /**
     * Updates a reservation from storage.
     * @param reservation is the reservation to update.
     */

    public void update(Reservation reservation) {
        if (!storage.containsKey(reservation.getId()))
            throw new RuntimeException(String.format("There is no reservation with the ID %s!", reservation.getId()));
        reservationValidator.validate(reservation);
        storage.put(reservation.getId(), reservation);
    }

    /**
     * Removes a reservation from storage.
     * @param id is the ID of the reservation to remove.
     */

    public void remove(String id) {
        if (!storage.containsKey(id))
            throw new RuntimeException(String.format("There is no reservation with the ID %s!", id));
        storage.remove(id);
    }

    /**
     * @return a list of all reservations.
     */

    public List<Reservation> getAll() { return new ArrayList<>(storage.values()); }

}
