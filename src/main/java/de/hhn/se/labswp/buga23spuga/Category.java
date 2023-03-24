package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Category")
public class Category implements Serializable {
    public Category() {
    }

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof Category))
            return false;
        Category category = (Category)aObj;
        if ((getName() != null && !getName().equals(category.getName())) || (getName() == null && category.getName() != null))
            return false;
        return true;
    }

    public int hashCode() {
        int hashcode = 0;
        hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
        return hashcode;
    }

    //ORM ZEUG
    /*
    private java.util.Set this_getSet (int key) {
        if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_CATEGORY_CONTENT) {
            return ORM_content;
        }

        return null;
    }

    @Transient
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };
    */

    //TABELLENSPALTEN UND VERBINDUNGEN ZU ANDEREN TABELLEN
    @Column(name="Name", nullable=false, length=255)
    @Id
    private String name;
/*
    @ManyToMany(mappedBy="ORM_category", targetEntity=de.hhn.se.labswp.buga23spuga.Course.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set content = new java.util.HashSet();

 */
    //GETTER UND SETTER
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    //ORM ZEUG
    /*
    public String getORMID() {
        return getName();
    }

    private void setORM_Content(java.util.Set value) {
        this.ORM_content = value;
    }

    private java.util.Set getORM_Content() {
        return ORM_content;
    }

    @Transient
    public final de.hhn.se.pmt.gruppea.model.CourseSetCollection content = new de.hhn.se.pmt.gruppea.model.CourseSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_CATEGORY_CONTENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_CATEGORY, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_MANY_TO_MANY);

    public String toString() {
        return String.valueOf(getName());
    }
    */
}
