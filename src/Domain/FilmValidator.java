package Domain;

public class FilmValidator {

    /** Validates a film.
     * @param film the reservation to validate.
     * @throws RuntimeException if there are validation errors.
     */

    public void validate (Film film) {
        if (film.getTicketPrice() <= 0)
            throw new RuntimeException("Ticket price must be greater than 0!");
    }

}
