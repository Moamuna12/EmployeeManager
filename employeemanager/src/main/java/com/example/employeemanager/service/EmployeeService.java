package com.example.employeemanager.service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//Ce code est un exemple d'un service Spring qui permet d'ajouter un objet Employee à un repository (employeRepo).

//La classe EmployeeService est annotée avec @Service, ce qui permet à Spring de l'initialiser et de la gérer comme
//un bean de service. Cette classe a une dépendance sur une instance de EmployeeRepo qui est injectée via son
//constructeur grâce à l'annotation @Autowired.
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    //La méthode addEmployee() prend en paramètre un objet Employee et lui attribue un code d'employé unique généré par
    //la méthode UUID.randomUUID().toString(). Ensuite, elle utilise la méthode save() du repository pour ajouter l'objet
    //Employee à la base de données et retourne l'objet Employee mis à jour, avec l'ID généré par la base de données.

    //L'utilisation de UUID.randomUUID().toString() permet de générer un code d'employé unique à chaque fois qu'un nouvel
    //employé est ajouté à la base de données. Cela permet d'éviter les conflits entre les employés et d'assurer que chaque
    //employé a un code unique.
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }





















}
