package com.movies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "movies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByPrice", query = "SELECT m FROM Movie m WHERE m.price = :price"),
    @NamedQuery(name = "Movie.findBySupersaver", query = "SELECT m FROM Movie m WHERE m.supersaver = :supersaver"),
    @NamedQuery(name = "Movie.findByAvability", query = "SELECT m FROM Movie m WHERE m.avability = :avability"),
    @NamedQuery(name = "Movie.findByPhoto", query = "SELECT m FROM Movie m WHERE m.photo = :photo"),
    @NamedQuery(name = "Movie.findByCategory", query = "SELECT m FROM Movie m WHERE m.category = :category")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 126)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "supersaver")
    private BigDecimal supersaver;
    @Column(name = "avability")
    private Short avability;
    @Size(max = 1024)
    @Column(name = "photo")
    private String photo;
    @Column(name = "category")
    private Integer category;
    @Transient
    public int quantity=0;
    
    public int getQuantity(){
        return this.quantity;
    }

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Movie(Integer id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSupersaver() {
        return supersaver;
    }

    public void setSupersaver(BigDecimal supersaver) {
        this.supersaver = supersaver;
    }

    public Short getAvability() {
        return avability;
    }

    public void setAvability(Short avability) {
        this.avability = avability;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movies.model.Movie[ id=" + id + " ]";
    }

}
