package by.safronenko.controllers;

import by.safronenko.entities.Link;
import by.safronenko.entities.LinkFolder;
import by.safronenko.service.LinkFolderService;
import by.safronenko.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private LinkFolderService linkFolderService;

    @RequestMapping("/links")
    public String listLinks(Model model) {

        List<Link> linkList = linkService.findAllLinks();
        List<LinkFolder> linkFolderList = linkFolderService.findAllLinkFolders();
        model.addAttribute("linkList", linkList);
        model.addAttribute("linkFolderList", linkFolderList);

        return "links";
    }

    @RequestMapping(value = "/addlink", method = RequestMethod.POST)
    public String addLink(@ModelAttribute("link") Link link, @ModelAttribute("linkFolder") LinkFolder linkFolder) {

        link.setLinkFolder(linkFolderService.getLinkFolder(linkFolder.getId()));
        linkService.addLink(link);

        return "redirect:/links";
    }

    @RequestMapping(value = "/links/delete/{linkId}")
    public String deleteLink(@PathVariable("linkId") int linkId) {

        linkService.deleteLink(linkId);

        return "redirect:/links";
    }

    @RequestMapping(value = "/links/get/{linkId}")
    public ModelAndView getLink(@PathVariable("linkId") int linkId) {
        ModelAndView modelAndView = new ModelAndView();
        Link link = linkService.getLink(linkId);
        List<LinkFolder> linkFolderList = linkFolderService.findAllLinkFolders();
        modelAndView.addObject("link", link);
        modelAndView.addObject("linkFolderList", linkFolderList);
        modelAndView.setViewName("editLink");

        return modelAndView;
    }

    @RequestMapping(value = "/links/get/update/{linkId}", method = RequestMethod.POST)
    public String updateLink(@ModelAttribute("link") Link link, @PathVariable("linkId") int linkId) {
        link.setId(linkId);
        linkService.addLink(link);

        return "redirect:/links";
    }

    @RequestMapping(value = "/addlinkfolder", method = RequestMethod.POST)
    public String addLinkFolder(@ModelAttribute("linkFolder") LinkFolder linkFolder) {
        linkFolderService.addLinkFolder(linkFolder);

        return "redirect:/links";
    }

    @RequestMapping(value = "/links/deletefolder/{linkFolderId}")
    public String deleteLinkFolder(@PathVariable("linkFolderId") int linkFolderId) {

        linkFolderService.deleteLinkFolder(linkFolderId);

        return "redirect:/links";
    }


}
