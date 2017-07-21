package by.safronenko.service;

import by.safronenko.entities.Link;
import by.safronenko.entities.LinkFolder;
import by.safronenko.repositories.LinkFolderRepository;
import by.safronenko.repositories.LinkRepository;
import by.safronenko.service.LinkFolderService;
import by.safronenko.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("linkFolderService")
@Transactional
public class LinkFolderServiceImpl implements LinkFolderService {

    @Autowired
    private LinkFolderRepository linkFolderRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private CurrentUser currentUser;

    public List<LinkFolder> findAllLinkFolders() {
        return linkFolderRepository.findLinkFolderByUsername(currentUser.getCurrentUser());
    }

    public void addLinkFolder(LinkFolder linkFolder) {
        linkFolder.setUsername(currentUser.getCurrentUser());
        linkFolderRepository.save(linkFolder);
    }


    public void deleteLinkFolder(int id){
        
        List<Link> links = linkRepository.findLinkWithFolder(currentUser.getCurrentUser());

        for (Link link : links) {
            if (link.getLinkFolder().getId() == id)
                linkRepository.delete(link);
        }

        linkFolderRepository.delete(id);
    }


    public LinkFolder getLinkFolder(int id) {
        return linkFolderRepository.findOne(id);
    }

}
