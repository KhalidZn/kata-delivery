package zen.reactive.katadelivery.db.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import zen.reactive.katadelivery.db.model.Reservation;

@Repository
public interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {
}