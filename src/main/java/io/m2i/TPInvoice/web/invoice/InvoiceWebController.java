package io.m2i.TPInvoice.web.invoice;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.Invoice;
import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.entity.UserAuthDetails;
import io.m2i.TPInvoice.service.ClientService;
import io.m2i.TPInvoice.service.InvoiceService;
import io.m2i.TPInvoice.service.ProductService;
import io.m2i.TPInvoice.service.UserService;
import io.m2i.TPInvoice.web.client.ClientDTO;
import io.m2i.TPInvoice.web.client.ClientMapper;
import io.m2i.TPInvoice.web.product.ProductDTO;
import io.m2i.TPInvoice.web.product.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoices")
@AllArgsConstructor
public class InvoiceWebController {

    private InvoiceService invoiceService;
    private UserService userService;
    private ClientService clientService;
    private ProductService productService;
    private InvoiceMapper invoiceMapper;
    private ClientMapper clientMapper;
    private ProductMapper productMapper;

    @GetMapping
    public String listInvoices(@AuthenticationPrincipal UserAuthDetails userAuthDetails,
                               Model model) {

        List<InvoiceDTO> invoiceDTOList = invoiceService.getInvoiceListPerUser(userAuthDetails.getUser())
                .stream()
                .map(invoiceMapper::toDTO)
                .toList();

        model.addAttribute("invoiceList", invoiceDTOList);
        return "/invoice/invoice-list";
    }

    @GetMapping("/detail{id}")
    public String detailsInvoice(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        InvoiceDTO invoiceDTO = invoiceMapper.toDTO(invoiceService.getInvoiceById(id));
        model.addAttribute("invoice", invoiceDTO);
        return "/invoice/invoice-detail";
    }

    @GetMapping("/add")
    public String addInvoice(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails) {

        List<ClientDTO> clientListDTO = clientService.getClientListPerUser(userAuthDetails.getUser())
                .stream()
                .map(clientMapper::toDTO)
                .toList();
        List<ProductDTO> productListDTO = productService.getProductListPerUser(userAuthDetails.getUser())
                .stream()
                .map(productMapper::toDTO)
                .toList();

        model.addAttribute("invoice", new InvoiceDTO());
        model.addAttribute("clientList", clientListDTO);
        model.addAttribute("productList", productListDTO);

        return "/invoice/invoice-form";
    }

    @PostMapping("/add")
    public String addInvoice(Model model,
                             @AuthenticationPrincipal UserAuthDetails userAuthDetails,
                             @ModelAttribute InvoiceDTO invoiceDTO) {

        Invoice invoice = invoiceService.createInvoice(invoiceDTO);

        userService.addInvoice(userAuthDetails.getUser(), invoice);

        return "redirect:/invoices";

    }



}
