package com.washiner.learning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotação @Entity indica que essa classe é uma entidade JPA.
@Entity
// Anotação @Table define o nome da tabela no banco de dados.
@Table(name = "employees")
public class Employee {

    // Anotação @Id indica que esse campo é a chave primária.
    @Id
    // Anotação @GeneratedValue define a estratégia de geração da chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação @Column define o nome da coluna no banco de dados e suas propriedades.
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Construtores, getters e setters são necessários para o JPA.
    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

