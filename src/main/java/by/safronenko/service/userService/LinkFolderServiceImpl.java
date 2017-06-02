package by.safronenko.service.userService;

import by.safronenko.entities.LinkFolder;
import by.safronenko.repositories.LinkFolderRepository;
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
    private CurrentUser currentUser;

    public List<LinkFolder> findAllLinkFolders() {
        return linkFolderRepository.findLinkFolderByUsername(currentUser.getCurrentUser());
    }

}
