package com.article.jwtauth.user;


import com.article.jwtauth.role.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Role role;

    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String userName;
    private String password;
    private String name;
    private String surname;
    private Long roleId;
    private Boolean enabled = false;
    private Boolean credentialsNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean accountNonExpired = true;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
