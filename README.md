## 📦 Maven Project Setup

**Project Name:** mavensample  
**Description:** A simple Maven + Hibernate project with MySQL  
**Group ID:** `org.sample`  
**Artifact ID:** `mavensample`  
**Java Version:** 8  

### 🔧 `pom.xml` Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.sample</groupId>
  <artifactId>mavensample</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <name>mavensample</name>
  <description>A simple mavensample.</description>
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.6.15.Final</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.30</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
    </dependency>
  </dependencies>
</project>



## 🚀 Java Main Class

**File:** `App.java`  
**Package:** `org.sample.mavensample`  
**Purpose:** Initializes Hibernate and inserts a `Student` into the database

```java
package org.sample.mavensample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Project started!");

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Make sure file is in src/main/resources
                .buildSessionFactory();

        System.out.println(factory);
        System.out.println(factory.isClosed());

        Student st = new Student(1010, "Mayuri", "Dhule");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(st);
        tx.commit();

        session.close();
        factory.close();
    }
}




## 🧪 Unit Test Class

**File:** `AppTest.java`  
**Package:** `org.sample.mavensample`  
**Purpose:** Basic JUnit test to validate the application structure.

```java
package org.sample.mavensample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue(true);
    }
}




## ⚙️ Hibernate Configuration

**File:** `hibernate.cfg.xml`  
**Purpose:** Defines database connection, Hibernate properties, and entity mapping.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<hibernate-configuration>
    <session-factory>

        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/myhiber</property>
        <property name="connection.username">root</property>
        <property name="connection.password">1234</property>

        <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <property name="hbm2ddl.auto">update</property>
        <property name="show_sql">true</property>

        <mapping class="org.sample.mavensample.Student"/>
    </session-factory>
</hibernate-configuration>


## 🧑‍🎓 Student Entity Class

**File:** `Student.java`  
**Purpose:** A simple POJO annotated with `@Entity` to represent the `Student` table in the database.

```java
package org.sample.mavensample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;

    public Student() {
        // Default constructor required by Hibernate
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return id + " : " + name + " from " + city;
    }
}



