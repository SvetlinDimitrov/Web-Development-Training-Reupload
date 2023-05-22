package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import com.ltp.globalsuperstore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

    ItemService service = new ItemService();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", service.checkIfExists(id) ? service.getItemById(id) :new Item());
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {

        putSomeErrors(item, result);
        if (result.hasErrors()) return "form";

        String status = service.flashAttributeStatus(item);
        if(status.equals(Constants.SUCCESS_STATUS)){service.addItem(item);}
        redirectAttributes.addFlashAttribute("status", status);

        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "inventory";
    }



    private static void putSomeErrors(Item item, BindingResult result) {
        if(item.getDiscount() == null){
            item.setDiscount(0.0);
        }
        if(item.getDate() == null){
            result.rejectValue("date", "", "You should have date");
        }
        if(item.getPrice() == null){
            result.rejectValue("price", "", "You should have price");
        }
        if (item.getPrice() != null && Double.compare(item.getPrice() , item.getDiscount()) < 0) {
            result.rejectValue("price", "", "Price cannot be less than discount");
        }
    }

}
