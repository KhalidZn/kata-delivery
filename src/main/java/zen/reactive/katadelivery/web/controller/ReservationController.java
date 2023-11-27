package zen.reactive.katadelivery.web.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import zen.reactive.katadelivery.web.dto.ReservationDto;

import java.security.Principal;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @PostMapping
    public Mono<ReservationDto> reserveSlot(Mono<Principal> principal,
                                            @RequestBody ReservationDto reservationDto) {

        return principal
                .map(Principal::getName)
                .map(name -> new ReservationDto(reservationDto.slotId(), name));
    }
}
