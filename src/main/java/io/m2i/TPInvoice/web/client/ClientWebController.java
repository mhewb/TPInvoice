package io.m2i.TPInvoice.web.client;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.UserAuthDetails;
import io.m2i.TPInvoice.service.ClientService;
import io.m2i.TPInvoice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientWebController {

    private UserService userService;
    private ClientService clientService;
    private ClientMapper clientMapper;

    @GetMapping
    public String listClients(@AuthenticationPrincipal UserAuthDetails userAuthDetails, Model model) {
        List<Client> clientList = clientService.getClientListPerUser(userAuthDetails.getUser());
        model.addAttribute("clientList", clientList);
        return "/client/client-list";
    }

    @GetMapping("/details{id}")
    public String detailsClient(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ClientDTO clientDTO = clientMapper.toDTO(clientService.getClientById(id));
        model.addAttribute("client", clientDTO);
        return "/client/client-detail";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new ClientDTO());
        return "/client/client-form";
    }

    @PostMapping("/add")
    public String addClient(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @ModelAttribute ClientDTO clientDTO) {
        Client client = userService.addClient(userAuthDetails.getUser(), clientMapper.fromDTO(clientDTO));
        return "redirect:/clients";
    }

    @GetMapping("/edit{id}")
    public String getEditClient(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ClientDTO clientDTO = clientMapper.toDTO(clientService.getClientById(id));
        model.addAttribute("client", clientDTO);
        return "/client/client-form";
    }

    @PostMapping("/edit{id}")
    public String postEditClient(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @ModelAttribute ClientDTO clientDTO) {
        clientService.editClient(clientMapper.fromDTO(clientDTO), userAuthDetails.getUser());
        return "redirect:/clients";
    }

    @GetMapping("/delete{id}")
    public String deleteClient(Model model, @AuthenticationPrincipal UserAuthDetails userAuthDetails, @RequestParam("id") Long id) {
        ClientDTO clientDTO = clientMapper.toDTO(clientService.getClientById(id));
        clientService.deleteClient(clientMapper.fromDTO(clientDTO), userAuthDetails.getUser());
        return "redirect:/clients";
    }





}
