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
@Table(name ="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_at")
    private Timestamp orderAt;

    @Column(name = "app_at")
    private Timestamp appAt;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "store_id")
    private Integer storeId;
}

