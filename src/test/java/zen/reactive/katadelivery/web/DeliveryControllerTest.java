package zen.reactive.katadelivery.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import zen.reactive.katadelivery.core.DeliveryMode;
import zen.reactive.katadelivery.web.dto.TimeSlot;

@WebFluxTest(controllers = DeliveryController.class)
class DeliveryControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllDeliveryModes() {
        webTestClient.get().uri("/delivery/modes")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DeliveryMode.class)
                .contains(DeliveryMode.DELIVERY)
                .hasSize(4);
    }

    @Test
    void testGetTimeSlots() {
        DeliveryMode deliveryMode = DeliveryMode.DELIVERY_TODAY;

        webTestClient.get().uri("/delivery/time-slots?deliveryMode=" + deliveryMode)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TimeSlot.class)
                .contains(new TimeSlot("Lundi", "09:00-11:00"))
                .hasSize(2);
    }
}