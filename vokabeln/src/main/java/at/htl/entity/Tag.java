package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long id;

    @Column(name = "TAG_NAME", length = 100)
    private String name;
}
