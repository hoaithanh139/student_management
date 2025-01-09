package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "student_courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId id;

    private BigDecimal midtermGrade;

    private BigDecimal finalGrade;

    private BigDecimal quizGrade;

    private BigDecimal finalScore;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

}
