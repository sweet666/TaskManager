package by.safronenko.entities;

import javax.persistence.*;

@Entity
@Table(name="LINKFOLDER")
public class LinkFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="FOLDER")
    private  String folder;

    @Column(name="USERNAME")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
