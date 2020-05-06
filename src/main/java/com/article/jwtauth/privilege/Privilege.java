package com.article.jwtauth.privilege;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Privilege implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Long permissionId;
    private Long roleId;
    private String code;
    private String explanation;
}
