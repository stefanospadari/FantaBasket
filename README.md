# FantaBasket

Software engineering project developed by **Stefano Spadari**, **Luca Cimino** and **Federico Mingarelli** for the *Ingegneria del Software T* course during the Bachelor's Degree in Computer Engineering at the University of Bologna.

FantaBasket is a web application designed to manage fantasy basketball leagues, where users build teams composed of real players and compete against each other based on the real-world performances of those players during the championship season.

The platform allows users to:

* create and manage leagues,
* build team rosters,
* submit lineups,
* generate schedules,
* calculate matchdays,
* and visualize standings and player statistics.

The application was developed as a multi-layer client/server system composed of:

* a web frontend,
* Java backend services,
* persistent storage through a relational database,
* and ORM-based persistence management using Hibernate.

The project focuses on software engineering practices such as:

* architectural design,
* modularity,
* persistence management,
* access control,
* interaction with external systems,
* and separation between presentation, business logic and persistence layers.

---

# Main Features

The application includes functionalities such as:

* user registration and authentication,
* fantasy league creation and administration,
* automatic calendar generation,
* lineup management,
* automatic matchday calculation,
* rankings and statistics visualization,
* player and roster management,
* logging and access monitoring,
* integration with external systems for statistics and schedules.

The system also supports administrative functionalities for league management and log inspection.

---

# Architecture

The project was designed following a three-tier client/server architecture.

### Client Layer

* Angular-based web frontend
* User and administrator interfaces

### Server Layer

* Java backend services running on Apache Tomcat
* Business logic organized into dedicated controllers/modules

### Persistence Layer

* IBM DB2 relational database
* Hibernate ORM for persistence abstraction and database management

The architecture was designed with particular attention to:

* modularity,
* maintainability,
* scalability,
* and separation of concerns.

---

# Technologies

* Java
* Angular
* Apache Tomcat
* Hibernate ORM
* IBM DB2
* HTML / CSS / JavaScript

---

# Running the Project

Before running the application:

* update the path to `hibernate-mapping-3.0.dtd` inside every `.hbm.xml` file located in:

```text
web/WEB-INF/classes/hibernate
```

* verify the path to `hibernate.cfg.xml` inside:

```text
utils/HibernateUtil.java
```

* edit:

```text
ant/environment.properties
```

* insert the DB2 database credentials (`username` and `password`)

---

# Educational Context

This project was developed as part of the *Ingegneria del Software T* course and focused on the design and implementation of a full-stack software system following software engineering methodologies and architectural design principles.
