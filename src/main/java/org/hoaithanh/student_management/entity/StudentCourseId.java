package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseId {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;

}
