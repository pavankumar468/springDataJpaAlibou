package com.aliboucoding.SpringDataJPA_ALIBOU.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // represents java class as entity in db
@Data  // used to generate setters,getters,cons
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="AUTHOR_TBL")
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_seq",
            sequenceName = "author_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "author_seq"
    )
    /*@GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "author_table_gen"
    )
    @TableGenerator(
            name = "author_table_gen",
            table = "author_table_gen",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1

    )*/
    private Integer id;
    @Column(name = "f_name",length = 20)
    private String firstName;
    private String lastName;

    @Column(unique = true ,nullable = false)
    private String email;
    private int age;
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;
    @Column(
            insertable = false
    )
    private LocalDateTime lastModifiedAt;
}
