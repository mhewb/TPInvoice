package io.m2i.TPInvoice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LandingWebController {

    @GetMapping
    public String landing(Model model) {
        return "/web/landing";
    }

}
