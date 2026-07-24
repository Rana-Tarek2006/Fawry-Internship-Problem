# Fawry-Internship-Problem
Designed and implemented a Java-based Quantum Radar system using OOP principles.The system records vehicle data,applies extensible traffic rules via interfaces,detects multiple violations,calculates fines,and generates violation summaries.Features include support for different vehicle types,rule-based validation,and overall violation statistics.
## Features

- Object-Oriented Design
- Extensible traffic rule engine
- Multiple vehicle types
- Multiple violations per vehicle
- Fine generation
- Rule violation summary
- Console-based demonstration

## Design

The system follows the Open/Closed Principle by defining a `TrafficRule`
interface. New traffic rules can be added by implementing this interface
without modifying the `QuRadar` class.

## Project Structure

src/
└── quantumradar/
    ├── Main.java
    ├── model/
    └── rules/

## Technologies

- Java 
- LocalDate Class
- Encapsulation
- Polymorphism
- Interfaces
- Enums
