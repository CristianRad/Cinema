package Repository;

import Domain.Film;
import Domain.FilmValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmRepository {

    private Map<String, Film> storage = new HashMap<>();
    private FilmValidator filmValidator;

    /**
     * Instantiates a repository for films.
     * @param filmValidator is the validator used.
     */

    public FilmRepository(FilmValidator filmValidator) {
        this.filmValidator = filmValidator;
    }

    /**
     * Finds a film by ID.
     * @param id is the ID of the film to find.
     * @return the film with the given ID if it does exist.
     */

    public Film findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds a film to storage.
     * @param film is the film to add.
     */

    public void insert(Film film) {
        if (storage.containsKey(film.getId()))
            throw new RuntimeException(String.format("A film with the ID %s already exists!", film.getId()));
        filmValidator.validate(film);
        storage.put(film.getId(), film);
    }

    /**
     * Updates a film from storage
     * @param film is the film to update.
     */

    public void update(Film film) {
        if (!storage.containsKey(film.getId()))
            throw new RuntimeException(String.format("There is no film with the ID %s!", film.getId()));
        filmValidator.validate(film);
        storage.put(film.getId(), film);
    }

    /**
     * Removes a film from storage.
     * @param id is the ID of the film to remove.
     */

    public void remove(String id) {
        if (!storage.containsKey(id))
            throw new RuntimeException(String.format("There is no film with the ID %s!", id));
        storage.remove(id);
    }

    /**
     * @return a list of all films.
     */

    public List<Film> getAll() {
        return new ArrayList<>(storage.values());
    }

}
