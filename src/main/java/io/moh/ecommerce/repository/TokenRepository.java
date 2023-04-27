package io.moh.ecommerce.repository;

import io.moh.ecommerce.model.AuthenticationToken;
import io.moh.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findTokenByUser(User user);

    AuthenticationToken findTokenByToken(String token);
}
