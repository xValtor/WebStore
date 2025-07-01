package org.store.webstore.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    public enum Role {
        ADMIN,
        USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;

    @NotBlank(message = "Имя не может быть пустым")
    @Column(unique = true, nullable = false)
    @Size(min = 2,max =20)
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, message = "Пароль не может быть меньше 6 символов")
    private String password;

    @NotBlank(message = "email не может быть пустым")
    @Email(message = "Не корректный email")
    @Column(unique = true)
    private String email;

    private LocalDate created = LocalDate.now();

    private boolean enabled = false;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
