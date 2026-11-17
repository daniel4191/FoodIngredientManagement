package kr.swdl.foodingredientmanagement.repository.entitiy;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Timestamp orderAt;

    private Timestamp appAt;

    private int totalPrice;

    private Integer userId;

    private Integer storeId;
}

