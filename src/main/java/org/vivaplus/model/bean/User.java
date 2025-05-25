package org.vivaplus.model.bean;

import org.vivaplus.model.enums.Roles;

public class User {
    private String id;
    private String name;
    private String cip;
    private String password;
    private Roles role;

    public User(String id, String name, String cip, String password, String role) {
        this.id = id;
        this.name = name;
        this.cip = cip;
        this.password = password;
        try {
            this.role = Roles.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Role inválida: " + role);
        }
    }

    public User() {
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}