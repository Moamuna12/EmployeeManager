package com.example.employeemanager.repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Un Repository (ou repo) est une couche d'abstraction entre l'application et la source de données (comme une base de données
// ou un service web). Il s'agit d'un composant clé de la conception d'une architecture logicielle de type Repository Pattern.

//Dans le contexte d'une application Java Spring, un Repository est une interface qui définit un ensemble de méthodes pour
//effectuer des opérations de lecture et d'écriture sur une source de données. Ces méthodes sont généralement associées
//à des opérations de CRUD (Create, Read, Update, Delete) pour un ou plusieurs types d'entités.
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //JpaRepository est une interface de Spring Data JPA
    // qui étend l'interface CrudRepository. Elle fournit une implémentation JPA (Java Persistence API) de base des opérations
    // CRUD (Create, Read, Update, Delete) pour une entité donnée.Elle permet de simplifier l'écriture de code pour accéder
    // à une base de données en réduisant le code boilerplate à écrire.
    //l'interface EmployeeRepo étend JpaRepository en spécifiant deux types de paramètres génériques : Employee, qui représente
    //l'entité pour laquelle nous souhaitons définir le Repository, et Long, qui représente le type de la clé primaire de l'entité.
    //Cela signifie que l'interface EmployeeRepo hérite de toutes les fonctionnalités de JpaRepository pour l'entité Employee,
    // y compris les opérations CRUD, la pagination et le tri.


    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);













}
