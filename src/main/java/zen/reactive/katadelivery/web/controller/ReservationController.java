package zen.reactive.katadelivery.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import zen.reactive.katadelivery.service.ReservationService;
import zen.reactive.katadelivery.web.dto.ReservationDto;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping
    public Mono<ReservationDto> reserveSlot(@RequestBody ReservationDto reservationDto) {

        return reservationService.saveReservation(reservationDto);
    }
}
