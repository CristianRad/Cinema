package Domain;

public class ClientValidator {

    /** Validates a reservation.
     * @param client the client to validate.
     * @throws RuntimeException if there are validation errors.
     */

    public void validate(Client client) {
        if (client.getCnp().length() != 13)
            throw new RuntimeException("The CNP must have exactly 13 digits!");
        String birthday = client.getBirthday();
        if ((birthday.charAt(0) < '0' || birthday.charAt(0) > '3') ||
                (birthday.charAt(0) == '3' && (birthday.charAt(1) < '0' || birthday.charAt(1) > '1')) ||
                ((birthday.charAt(0) > '0' && birthday.charAt(0) < '3') && (birthday.charAt(1) < '0' || birthday.charAt(1) > '9')) ||
                (birthday.charAt(2) != '.') ||
                (birthday.charAt(3) == '0' && (birthday.charAt(4) < '0' || birthday.charAt(4) > '9')) ||
                (birthday.charAt(3) == '1' && (birthday.charAt(4) < '0' || birthday.charAt(4) > '2')) ||
                (birthday.charAt(5) != '.') ||
                (birthday.charAt(6) == '1' && birthday.charAt(7) != '9') ||
                (birthday.charAt(6) == '2' && birthday.charAt(7) != '0') ||
                (birthday.charAt(7) == '9' && (birthday.charAt(8) < '2' || birthday.charAt(8) > '9')) ||
                (birthday.charAt(7) == '0' && (birthday.charAt(8) < '0' || birthday.charAt(8) > '1')) ||
                (birthday.charAt(9) < '0' || birthday.charAt(9) > '9'))
            throw new RuntimeException("The date of birth is not valid!");
        String regDay = client.getRegistrationDay();
        if ((regDay.charAt(0) < '0' || regDay.charAt(0) > '3') ||
                (regDay.charAt(0) == '3' && (regDay.charAt(1) < '0' || regDay.charAt(1) > '1')) ||
                ((regDay.charAt(0) > '0' && regDay.charAt(0) < '3') && (regDay.charAt(1) < '0' || regDay.charAt(1) > '9')) ||
                (regDay.charAt(2) != '.') ||
                (regDay.charAt(3) == '0' && (regDay.charAt(4) < '0' || regDay.charAt(4) > '9')) ||
                (regDay.charAt(3) == '1' && (regDay.charAt(4) < '0' || regDay.charAt(4) > '2')) ||
                (regDay.charAt(5) != '.') ||
                (regDay.charAt(6) == '1' && regDay.charAt(7) != '9') ||
                (regDay.charAt(6) == '2' && regDay.charAt(7) != '0') ||
                (regDay.charAt(7) == '9' && (regDay.charAt(8) < '4' || regDay.charAt(8) > '9')) ||
                (regDay.charAt(7) == '0' && (regDay.charAt(8) < '0' || regDay.charAt(8) > '1')) ||
                (regDay.charAt(9) < '0' || regDay.charAt(9) > '9'))
            throw new RuntimeException("The date of registration is not valid!");
    }

}
