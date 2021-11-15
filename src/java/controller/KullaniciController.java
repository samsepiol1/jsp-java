/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserFacade;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named("userCont")
@ViewScoped
public class UserController implements Serializable {

    private User user;
    @EJB
    private UserFacade us;

    public void create() {
        this.us.create(User);
        this.user = new User();
    }

    public List<User> getRead() {
        return this.us.findAll();
    }

    public void updateForm(User k) {
        this.User = k;
    }

    public void update() {
        this.us.edit(User);
        this.User = new User();
    }

    public void delete(User k) {
        this.us.remove(k);
    }

    public User getUser() {
        if (this.User == null) {
            return this.User = new User();
        }
        return User;
    }

    public void setUser(User User) {
        this.user = User;
    }

}
