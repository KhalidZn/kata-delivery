package zen.reactive.katadelivery.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import zen.reactive.katadelivery.core.DeliveryMode;
import zen.reactive.katadelivery.web.dto.TimeSlot;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @GetMapping("/modes")
    public Flux<DeliveryMode> getAllDeliveryModes() {
        return Flux.just(DeliveryMode.values());
    }

    @GetMapping("/time-slots")
    public Flux<TimeSlot> getTimeSlots(@RequestParam DeliveryMode deliveryMode) {

        return switch (deliveryMode){
            case DELIVERY_TODAY, DELIVERY_ASAP ->  Flux.just(
                    new TimeSlot("Lundi", "09:00-11:00"),
                    new TimeSlot("Lundi", "13:00-15:00")
            );
            case DRIVE , DELIVERY -> Flux.just(
                    new TimeSlot("Mardi", "10:00-12:00"),
                    new TimeSlot("Mercredi", "14:00-16:00")
            );
            default -> Flux.empty();
        };
    }

}
