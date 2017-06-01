package by.safronenko.service;

import by.safronenko.entities.Link;
import by.safronenko.repositories.LinkRepository;
import by.safronenko.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private CurrentUser currentUser;

    public List<Link> findAllLinks() {
        return linkRepository.findLinkByUsername(currentUser.getCurrentUser());
    }

    public void addLink(Link link) {
        link.setUsername(currentUser.getCurrentUser());
        linkRepository.save(link);
    }

    public void deleteLink(int id) {
        linkRepository.delete(id);
    }

    public Link getLink(int id) {
        return linkRepository.findOne(id);
    }

}
