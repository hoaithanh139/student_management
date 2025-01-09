package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;
import lombok.*;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleId {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;

}
