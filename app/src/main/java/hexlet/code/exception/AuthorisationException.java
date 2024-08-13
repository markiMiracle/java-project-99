package hexlet.code.exception;

import hexlet.code.dto.AuthRequest;

public class AuthorisationException extends RuntimeException {

    public AuthorisationException(String message) {
        super(message);
    }
}
