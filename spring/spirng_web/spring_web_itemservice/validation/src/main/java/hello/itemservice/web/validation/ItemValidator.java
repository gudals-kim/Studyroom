package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
        //item == clazz
        //item == subItem
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        //검증 로직
        if (!StringUtils.hasText(item.getItemName())){
            //상품명 공백
            errors.rejectValue("itemName", "required");
        }
        if (item.getPrice() == null || item.getPrice()< 1000 || item.getPrice() >= 1000000){
            //상품 가격이 공백 또는 1,000 ~ 1,000,000 범위를 벗어날 경우
            errors.rejectValue("price","range",new Object[]{1000,1000000},null);
        }
        if (item.getQuantity() == null || item.getQuantity() > 9999){
            //상품 개수가 공백 또는 9,999 개 이상일 경우
            errors.rejectValue("quantity","max",new Object[]{9999},null);
        }
        // 특정 필드가 아닌 복합 룰 검증법
        if (item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                errors.reject("totalPriceMin",new Object[]{10000,resultPrice},null);
            }
        }
    }
}
