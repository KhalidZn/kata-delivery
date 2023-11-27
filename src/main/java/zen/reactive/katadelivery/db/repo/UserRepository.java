package zen.reactive.katadelivery.db.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import zen.reactive.katadelivery.db.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
  Mono<UserDetails> findByUsername(String username);
}