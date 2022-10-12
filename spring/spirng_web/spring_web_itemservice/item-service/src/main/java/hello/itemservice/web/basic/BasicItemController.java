package hello.itemservice.web.basic;


import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String items(Model model){

        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);

        return "basic/items";

    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId,
                       Model model){
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item",findItem);
        return "basic/item";
    }
    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item){
        itemRepository.save(item);
        return "basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(
            @PathVariable Long itemId,
            Model model
    ){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String editItem(
            @PathVariable Long itemId,
            @ModelAttribute Item item
    ){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }



    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",22221,45));
        itemRepository.save(new Item("itemB",17521,25));
    }

}
