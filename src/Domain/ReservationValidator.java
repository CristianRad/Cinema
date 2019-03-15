package Domain;

import Repository.FilmRepository;

public class ReservationValidator {

    /** Validates a reservation.
     * @param reservation the reservation to validate.
     * @throws RuntimeException if there are validation errors.
     */

    private FilmRepository filmRepository;

    public void validate(Reservation reservation) {
        String idFilm = reservation.getIdFilm();
        if (idFilm.length() == 0 || Character.compare(idFilm.charAt(0), '\n') == 0)
            throw new RuntimeException("The film ID must not be null!");
        Film film = filmRepository.findById(idFilm);
        if (film == null)
            throw new RuntimeException("The ID of the film on the reservation does not exist!");
        else if (!film.isOnScreen())
            throw new RuntimeException("The film is not scheduled to run!");
    }

}
