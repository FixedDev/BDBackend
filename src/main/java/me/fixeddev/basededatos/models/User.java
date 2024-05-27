package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usersId")
    private Long usersId;

    @Column(nullable = false, name = "firstName")
    private String firstName;

    @Column(nullable = false, name = "lastNamePaternal")
    private String lastNamePaternal;

    @Column(nullable = false)
    private String lastNameMaternal;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    public User(Long usersId, String firstName, String lastNamePaternal, String lastNameMaternal, String email, String password, Role role) {
        this.usersId = usersId;
        this.firstName = firstName;
        this.lastNamePaternal = lastNamePaternal;
        this.lastNameMaternal = lastNameMaternal;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }


    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamePaternal() {
        return lastNamePaternal;
    }

    public void setLastNamePaternal(String lastNamePaternal) {
        this.lastNamePaternal = lastNamePaternal;
    }

    public String getLastNameMaternal() {
        return lastNameMaternal;
    }

    public void setLastNameMaternal(String lastNameMaternal) {
        this.lastNameMaternal = lastNameMaternal;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(usersId, user.usersId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastNamePaternal, user.lastNamePaternal) && Objects.equals(lastNameMaternal, user.lastNameMaternal) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, firstName, lastNamePaternal, lastNameMaternal, email, password, role);
    }

}