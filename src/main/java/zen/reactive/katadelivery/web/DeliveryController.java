package zen.reactive.katadelivery.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import zen.reactive.katadelivery.core.DeliveryMode;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @GetMapping("/modes")
    public Flux<DeliveryMode> getAllDeliveryModes() {
        return Flux.just(DeliveryMode.values());
    }
}
