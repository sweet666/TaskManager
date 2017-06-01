package by.safronenko.controllers;

import by.safronenko.entities.Link;
import by.safronenko.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/links")
    public String listLinks(Model model) {

        List<Link> linkList = linkService.findAllLinks();
        model.addAttribute("linkList", linkList);

        return "links";
    }

    @RequestMapping(value = "/addlink", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("link") Link link) {

        linkService.addLink(link);

        return "redirect:/links";
    }
}
