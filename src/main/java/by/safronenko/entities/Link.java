package by.safronenko.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="LINKS")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="TITLE")
    private  String title;

    @Column(name="DIRECTLINK")
    private  String directLink;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne(fetch=FetchType.LAZY)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="LINKFOLDER_ID")
    private LinkFolder linkFolder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LinkFolder getLinkFolder() {
        return linkFolder;
    }

    public void setLinkFolder(LinkFolder linkFolder) {
        this.linkFolder = linkFolder;
    }

    public String getDirectLink() {
        return directLink;
    }

    public void setDirectLink(String directLink) {
        this.directLink = directLink;
    }
}
