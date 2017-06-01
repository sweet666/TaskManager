package by.safronenko.service;

import by.safronenko.entities.Link;

import java.util.List;


public interface LinkService {

    List<Link> findAllLinks();

    void addLink(Link link);

    void deleteLink(int id);

    Link getLink(int id);
}
