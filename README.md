# JDBC Programme in Advanced Java

A hands-on programme on connecting Java applications to relational databases using **JDBC**.

## Objectives

- Connect to a database using `DriverManager`
- Perform CRUD operations with `PreparedStatement` and `ResultSet`
- Manage transactions (`commit`, `rollback`) and batch processing
- Call stored procedures with `CallableStatement`
- Apply good practices: `try-with-resources`, no SQL injection, no hard-coded credentials

## Prerequisites

- JDK 17+
- MySQL 8.0+ (or another RDBMS with its JDBC driver)
- MySQL Connector/J 8.x

## Setup

1. Add the driver to your classpath (or Maven dependency `mysql:mysql-connector-j`).
2. Run the schema script:
   ```bash
   mysql -u root -p < sql/schema.sql
   ```
3. Set the URL, username, and password in `DbConnection.java`:
   ```java
   String URL = "jdbc:mysql://localhost:3306/school_db";
   ```
4. Run `App.java`.

## Modules

| # | Topic |
|---|-------|
| 1 | Connecting to a database |
| 2 | CRUD operations |
| 3 | Transactions and batch processing |
| 4 | Stored procedures |

## Quick Example

```java
String sql = "SELECT id, name, marks FROM students WHERE course = ?";
try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
     PreparedStatement ps = con.prepareStatement(sql)) {
    ps.setString(1, "BTech CS");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getBigDecimal("marks"));
        }
    }
}
```

## Troubleshooting

- **No suitable driver found:** driver JAR is missing from the classpath.
- **Access denied:** check the username and password.
- **Communications link failure:** MySQL is not running or the port is wrong.

