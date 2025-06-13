package com.practical.LibraryManagementSystem;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "library") public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate joinDate = LocalDate.now();

    private int issuedBooks;

    private boolean active = true;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    public int getIssuedBooks() { return issuedBooks; }
    public void setIssuedBooks(int issuedBooks) { this.issuedBooks = issuedBooks; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
