/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.objects;

import com.albertos.controllers.EMFactory;
import com.albertos.controllers.IngredientJpaController;
import com.albertos.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hero
 */
@Entity
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ingredientName;
    private int quantity;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void subtractQuantity(int quantity) {
        this.quantity -= quantity;
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
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EMFactory.IngredientInventory[ id=" + id + " ]";
    }

    private static final IngredientJpaController controller
            = new IngredientJpaController(EMFactory.getEmf());

    public void save() {
        controller.create(this);
    }

    public void delete() {
        try {
            controller.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Ingredient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edit() {
        try {
            controller.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(Ingredient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
