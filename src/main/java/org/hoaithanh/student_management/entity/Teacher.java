package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    private Integer teacherId;

    private String department;

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "userId", insertable = false, updatable = false)
    private User user;

}
