package io.m2i.TPInvoice.web.product;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.entity.UserAuthDetails;
import io.m2i.TPInvoice.service.ProductService;
import io.m2i.TPInvoice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductWebController {

    private UserService userService;
    private ProductService productService;
    private ProductMapper productMapper;

    @GetMapping
    public String listClients(@AuthenticationPrincipal UserAuthDetails userAuthDetails, Model model) {
        List<Product> productList = productService.getProductListPerUser(userAuthDetails.getUser());
        model.addAttribute("productList", productList);
        return "/product/product-list";
    }

    @GetMapping("/details{id}")
    public String detailsProduct(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ProductDTO productDTO = productMapper.toDTO(productService.getProductById(id));
        model.addAttribute("product", productDTO);
        return "/product/product-detail";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "/product/product-form";
    }

    @PostMapping("/add")
    public String addProduct(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @ModelAttribute ProductDTO productDTO) {
        Product product = userService.addProduct(userAuthDetails.getUser(), productMapper.fromDTO(productDTO));
        return "redirect:/products";
    }

    @GetMapping("/edit{id}")
    public String getEditProduct(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ProductDTO productDTO = productMapper.toDTO(productService.getProductById(id));
        model.addAttribute("product", productDTO);
        return "/product/product-form";
    }

    @PostMapping("/edit{id}")
    public String postEditProduct(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @ModelAttribute ProductDTO productDTO) {
        productService.editProduct(productMapper.fromDTO(productDTO), userAuthDetails.getUser());
        return "redirect:/products";
    }

    @GetMapping("/delete{id}")
    public String deleteProduct(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ProductDTO productDTO = productMapper.toDTO(productService.getProductById(id));
        productService.deleteProduct(productMapper.fromDTO(productDTO), userAuthDetails.getUser());
        return "redirect:/products";
    }





}
