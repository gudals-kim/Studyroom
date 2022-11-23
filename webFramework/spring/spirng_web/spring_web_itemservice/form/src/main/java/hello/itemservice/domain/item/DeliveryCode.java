package hello.itemservice.domain.item;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Fast : 빠른배송
 * Normal : 일반 배송
 * slow : 느린배송
 */
@Data
@AllArgsConstructor
public class DeliveryCode {
    private String code;
    private String displayName;


}
