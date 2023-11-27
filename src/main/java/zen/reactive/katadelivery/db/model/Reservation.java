package zen.reactive.katadelivery.db.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document
@ToString
public class Reservation {

    @Id
    private String id;
    private LocalDate day;
    private LocalTime time;
    private String mode;
    @DBRef
    private User user;
}
