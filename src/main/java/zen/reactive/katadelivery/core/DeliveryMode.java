package zen.reactive.katadelivery.core;

public enum DeliveryMode {
    DRIVE("DRIVE"),
    DELIVERY("DELIVERY"),
    DELIVERY_TODAY("DELIVERY_TODAY"),
    DELIVERY_ASAP("DELIVERY_ASAP");

    private final String value;

    DeliveryMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
