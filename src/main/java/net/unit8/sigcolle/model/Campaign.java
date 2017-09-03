package net.unit8.sigcolle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

/**
 * @author kawasima
 */
@Entity
@Data
public class Campaign implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    private String title;

    // Markdown description
    private String statement;

    private Long goal;

    private Long createUserId;

    List<Order> orders = new ArrayList<>();

    private Long totalAmount;

    public Campaign() {
    }

    private Long calcPayments(){
        for(Order order:orders){
            totalAmount += order.getAmount();
        }
        return totalAmount;
    }
}
