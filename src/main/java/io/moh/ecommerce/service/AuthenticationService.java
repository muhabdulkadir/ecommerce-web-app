package io.moh.ecommerce.service;

import io.moh.ecommerce.config.MessageStrings;
import io.moh.ecommerce.exceptions.AuthenticationFailException;
import io.moh.ecommerce.model.AuthenticationToken;
import io.moh.ecommerce.model.User;
import io.moh.ecommerce.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    @Autowired
    private TokenRepository repository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return repository.findTokenByUser(user);
    }

    // check if the token is valid
    public void authenticate(String token) throws AuthenticationFailException {
        if (Objects.isNull(token)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if (Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }

    private User getUser(String token) {
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        return Objects.nonNull(authenticationToken) ? authenticationToken.getUser() : null;
    }
}
