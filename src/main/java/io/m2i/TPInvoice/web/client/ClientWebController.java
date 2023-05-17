package io.m2i.TPInvoice.web.client;

import io.m2i.TPInvoice.entity.Client;
import io.m2i.TPInvoice.entity.User;
import io.m2i.TPInvoice.service.ClientService;
import io.m2i.TPInvoice.web.UserDTO;
import io.m2i.TPInvoice.web.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientWebController {

    private ClientService clientService;
    private UserMapper userMapper;

    @GetMapping
    public String listClients(@AuthenticationPrincipal User user, Model model) {
        List<Client> clientList = clientService.getClientListPerUser(user);
        model.addAttribute("clientList", clientList);
        return "/web/client-list";
    }




}
