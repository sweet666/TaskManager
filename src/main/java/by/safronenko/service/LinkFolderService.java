package by.safronenko.service;


import by.safronenko.entities.LinkFolder;

import java.util.List;

public interface LinkFolderService {

    List<LinkFolder> findAllLinkFolders();

    void addLinkFolder(LinkFolder linkFolder);

    void deleteLinkFolder(int id);
}
