package com.de.hhn.labswp.loggedin;

public class Profil {

    String email;
    String password;
    String username;
    Boolean isOrganizer;
    String firstname;
    String lastnanme;
    String description;
    Boolean guest;


    public Boolean isGuest() {
        return guest;
    }

    public void setGuest(Boolean guest) {
        this.guest = guest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(Boolean organizer) {
        isOrganizer = organizer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnanme() {
        return lastnanme;
    }

    public void setLastnanme(String lastnanme) {
        this.lastnanme = lastnanme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profil(String email, String password, String username, Boolean isOrganizer, String firstname, String lastnanme, String description) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.isOrganizer = isOrganizer;
        this.firstname = firstname;
        this.lastnanme = lastnanme;
        this.description = description;
    }

    public Profil () {

    }
}
