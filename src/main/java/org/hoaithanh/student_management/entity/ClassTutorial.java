package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassTutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
