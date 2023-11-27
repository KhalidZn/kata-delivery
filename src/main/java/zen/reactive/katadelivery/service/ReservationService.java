package zen.reactive.katadelivery.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import zen.reactive.katadelivery.core.DeliveryMode;
import zen.reactive.katadelivery.db.model.Reservation;
import zen.reactive.katadelivery.db.model.User;
import zen.reactive.katadelivery.db.repo.ReservationRepository;
import zen.reactive.katadelivery.db.repo.UserRepository;
import zen.reactive.katadelivery.web.dto.ReservationDto;

import java.time.LocalDate;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }


    public Mono<ReservationDto> saveReservation(ReservationDto reservationDto) {
        return userRepository.findByUsername(reservationDto.name())
                .flatMap(user-> reserve(reservationDto, user));
    }

    private Mono<ReservationDto> reserve(ReservationDto reservationDto, UserDetails user) {
        Reservation reservation = new Reservation();
        reservation.setDay(LocalDate.now());
        reservation.setMode(DeliveryMode.DELIVERY_TODAY.getValue());
        reservation.setUser((User) user);

        return reservationRepository.save(reservation).thenReturn(reservationDto);
    }


}
