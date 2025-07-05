package org.store.webstore.Controllers;

import org.hibernate.annotations.Source;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.store.webstore.Entities.Product;
import org.store.webstore.Services.WebStoreService;

@Controller
@RequestMapping("BestStore")
public class MainController {
    private final WebStoreService webStoreService;

    public MainController(WebStoreService webStoreService) {
        this.webStoreService = webStoreService;
    }

    @GetMapping
    public String BestStore(Model model) {
        model.addAttribute("products",webStoreService.getProducts() );
        return "index";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

}
