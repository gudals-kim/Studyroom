package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.domain.item.SaveCheck;
import hello.itemservice.domain.item.UpdateCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
public class ValidationItemControllerV4 {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v3/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v3/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v3/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated(SaveCheck.class) @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // 틀정 필드가 아닌 복합 룰 검증법
        if (item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                bindingResult.reject("globalError", "등록 상품의 총액이 10,000원 이상이어야 합니다. 현재 상품 등록 총액 = " + resultPrice + "원 입니다.");
            }
        }

        //bindingResult에 Error가 있다면
        if (bindingResult.hasErrors()){
            log.info("errors={}",bindingResult);
            return "validation/v3/addForm";
        }
        //이후는 성공(에러가 나지않은) 로직

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v3/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated(UpdateCheck.class) @ModelAttribute Item item, BindingResult bindingResult) {
        // 틀정 필드가 아닌 복합 룰 검증법
        if (item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                bindingResult.reject("globalError", "등록 상품의 총액이 10,000원 이상이어야 합니다. 현재 상품 등록 총액 = " + resultPrice + "원 입니다.");
            }
        }

        //bindingResult에 Error가 있다면
        if (bindingResult.hasErrors()){
            log.info("errors={}",bindingResult);
            return "validation/v3/editForm";
        }


        itemRepository.update(itemId, item);
        return "redirect:/validation/v4/items/{itemId}";
    }

}

