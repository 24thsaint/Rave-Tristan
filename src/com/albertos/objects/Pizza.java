/*
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 *  |      CENTRAL PHILIPPINE UNIVERSITY                   |
 *  |      Bachelor of Science in Software Engineering     |
 *  |      Jaro, Iloilo City, Philippines                  |
 *  |                                                      |
 *  |          This program is written by Rave, ©2015.     |
 *  |          You are free to use and distribute this.    |
 *  |          Reach me at: admin@blackout.biz.tm          |
 *  |                                                      |
 *  |               ~~~"CODE the FUTURE"~~~                |
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 */
package com.albertos.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
@Entity
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private double nineInchPizzaPrice;
    private double elevenInchPizzaPrice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.subtractQuantity(1);
    }

    public void removeIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            this.ingredients.remove(ingredient);
        }
    }

    public double getNineInchPizzaPrice() {
        return nineInchPizzaPrice;
    }

    public void setNineInchPizzaPrice(double nineInchPizzaPrice) {
        if (nineInchPizzaPrice <= 0) {
            this.nineInchPizzaPrice = 1;
        } else if (nineInchPizzaPrice >= 100000) {
            this.nineInchPizzaPrice = 100000;
        } else {
            this.nineInchPizzaPrice = nineInchPizzaPrice;
        }
    }

    public double getElevenInchPizzaPrice() {
        return elevenInchPizzaPrice;
    }

    public void setElevenInchPizzaPrice(double elevenInchPizzaPrice) {
        if (elevenInchPizzaPrice <= 0) {
            this.elevenInchPizzaPrice = 1;
        } else if (elevenInchPizzaPrice >= 100000) {
            this.elevenInchPizzaPrice = 100000;
        } else {
            this.elevenInchPizzaPrice = elevenInchPizzaPrice;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Blank name");
        } else {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.isEmpty() ? "No description" : description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName();
    }

}
