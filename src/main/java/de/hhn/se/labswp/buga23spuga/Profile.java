package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Profile")
public class Profile implements Serializable {
    public Profile() {
    }

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof Profile))
            return false;
        Profile profile = (Profile)aObj;
        if ((getUsername() != null && !getUsername().equals(profile.getUsername())) || (getUsername() == null && profile.getUsername() != null))
            return false;
        return true;
    }

    public int hashCode() {
        int hashcode = 0;
        hashcode = hashcode + (getUsername() == null ? 0 : getUsername().hashCode());
        return hashcode;
    }

    //TABELLENSPALTEN UND VERBINDUNGEN ZU ANDEREN TABELLEN
    @Column(name="Username", nullable=false, length=255)
    @Id
    private String username;

    @Column(name="Email", nullable=true, length=255)
    private String email;

    @Column(name="Password", nullable=true, length=255)
    private String password;

    @Column(name="isorganizer", nullable=false)
    private boolean isOrganizer;

    @Column(name="Firstname", nullable=true, length=255)
    private String firstname;

    @Column(name="Lastname", nullable=true, length=255)
    private String lastname;

    @Column(name="Description", nullable=true, length=255)
    private String description;


    @OneToOne(mappedBy="profile", targetEntity= Courseorganizer.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private Courseorganizer organizer;

    @OneToOne(mappedBy="profile", targetEntity=de.hhn.se.labswp.buga23spuga.Visitor.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private de.hhn.se.labswp.buga23spuga.Visitor visitor;


    //GETTER UND SETTER
    public void setEmail(String value) {
        this.email = value;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getUsername() {
        return username;
    }

    /*
    public String getORMID() {
        return getUsername();
    }
    */


    public void setIsOrganizer(boolean value) {
        this.isOrganizer = value;
    }

    public boolean getIsOrganizer() {
        return isOrganizer;
    }

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }

    public String getLastname() {
        return lastname;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }

    public void setOrganizer(Courseorganizer value) {
        if (this.organizer != value) {
            Courseorganizer lorganizer = this.organizer;
            this.organizer = value;
            if (value != null) {
                organizer.setProfile(this);
            }
            if (lorganizer != null && lorganizer.getProfile() == this) {
                lorganizer.setProfile(null);
            }
        }
    }

    public Courseorganizer getOrganizer() {
        return organizer;
    }

    public void setVisitor(de.hhn.se.labswp.buga23spuga.Visitor value) {
        if (this.visitor != value) {
            de.hhn.se.labswp.buga23spuga.Visitor lvisitor = this.visitor;
            this.visitor = value;
            if (value != null) {
                visitor.setProfile(this);
            }
            if (lvisitor != null && lvisitor.getProfile() == this) {
                lvisitor.setProfile(null);
            }
        }
    }
    @JsonBackReference
    public de.hhn.se.labswp.buga23spuga.Visitor getVisitor() {
        return visitor;
    }

    public String toString() {
        return String.valueOf(getUsername());
    }

}