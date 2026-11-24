# ComBancaire

<!-- Badges: add CI / license badges once a pipeline and a LICENSE file exist. -->

ComBancaire is a small Java console project (IntelliJ IDEA module, no build tool) that accesses a MySQL `bank` database through JDBC. It defines a `Customer` model, a singleton-style database access class and a repository to read customers. It appears to be a lab exercise on JDBC and the Singleton / Repository patterns.

> To be completed: describe the exact goal of the exercise.

## Main features

- `config.AccessSingleton.connecter()`: opens (once) a JDBC connection to `jdbc:mysql://localhost:3306/bank`.
- `referenciel.CustomerRepository.findByName(String name)`: returns the customer whose `nom` matches.
- `referenciel.CustomerRepository.findAll()`: returns all customers in a `TreeSet<Customer>`.
- `banque.Customer`: model with `nom`, `adresse` and `nombre_de_carte`.

## Screenshots / demo

Not applicable (console project without user interface).

## Prerequisites

- **JDK 25** (the IntelliJ project is configured with language level `JDK_25`)
- **MySQL** on `localhost:3306` with a `root` user and an empty password (e.g. XAMPP)
- **MySQL Connector/J 9.6.0** JAR (`mysql-connector-j-9.6.0.jar`)
- *(referenced but unused by the code)* `ojdbc8.jar` (Oracle JDBC driver)
- *(recommended)* IntelliJ IDEA

## Installation

```bash
git clone https://github.com/nour-agrebi-web/ComBancaire.git
cd ComBancaire
```

1. Download MySQL Connector/J 9.6.0 and place the JAR somewhere on your machine.
2. Open the folder in IntelliJ IDEA, then in **File > Project Structure > Libraries** point the `mysql-connector-j-9.6.0` library to your JAR (the committed configuration points to a path on the author's Desktop).
3. Create the database:

```sql
CREATE DATABASE bank;
```

> To be completed: the `customer` table script is not in the repository. The code reads the columns `nom`, `adresse` (by name) and a third column read as an integer (number of cards). A plausible definition, to be confirmed:
>
> ```sql
> CREATE TABLE customer (
>     nom VARCHAR(100),
>     adresse VARCHAR(255),
>     nombre_de_carte INT
> );
> ```

## Configuration / environment variables

No environment variables are used. Connection settings are hard-coded in [src/config/AccessSingleton.java](./src/config/AccessSingleton.java):

| Setting | Value |
| --- | --- |
| JDBC URL | `jdbc:mysql://localhost:3306/bank` |
| User | `root` |
| Password | *(empty)* |
| Driver | `com.mysql.cj.jdbc.Driver` |

## Running the project

From IntelliJ IDEA: run the `main` method of [src/test.java](./src/test.java).

From the command line (adapt the JAR path; on Windows replace `:` with `;` in the classpath):

```bash
javac -cp path/to/mysql-connector-j-9.6.0.jar -d out $(find src -name "*.java")
java -cp out:path/to/mysql-connector-j-9.6.0.jar test
```

`test.main` currently only creates a `Customer` object and prints nothing.

## Usage

Example of use of the repository (not present in `test.java`):

```java
CustomerRepository repo = new CustomerRepository();
Customer c = repo.findByName("Mr Radhouane");
```

## Tests

> To be completed: there are no automated tests; `test.java` is a manual entry point, not a unit test.

## Project structure

```text
ComBancaire/
├── ComBancaire.iml                  # IntelliJ module (libraries: KotlinJavaRuntime, mysql-connector-j-9.6.0, ojdbc8)
├── .idea/                           # IntelliJ project settings, data source "bank@localhost"
└── src/
    ├── test.java                    # main class
    ├── banque/Customer.java         # model
    ├── config/AccessSingleton.java  # JDBC connection
    └── referenciel/CustomerRepository.java
```

## Technologies

- Java (JDK 25 language level)
- JDBC, MySQL Connector/J 9.6.0
- MySQL
- IntelliJ IDEA

## Deployment

Not applicable.

## Contributing

> To be completed: no contribution guidelines exist.

## License

> To be completed: no `LICENSE` file is present.

## Authors / contacts

- Repository owner: [@nour-agrebi-web](https://github.com/nour-agrebi-web)

> To be completed: full names and contact details.

## Useful resources

- [JDBC basics (Oracle tutorial)](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
- [MySQL Connector/J documentation](https://dev.mysql.com/doc/connector-j/en/)

## Notes to complete

- The `customer` table schema and sample data are missing.
- The JDBC driver JARs are not in the repository and the IntelliJ libraries point to absolute paths on the author's machine; a build tool (Maven or Gradle) would make the dependency explicit.
- Known issues in the code:
  - the `Customer` constructor does not assign `nombre_de_carte`;
  - `Customer.toString()` always returns `null` (`nom.equals(this.nom)` is always true);
  - `Customer` does not implement `Comparable`, so `findAll()` will throw a `ClassCastException` when adding to the `TreeSet`;
  - the `user` / `pass` fields of `AccessSingleton` are never used.
- `ojdbc8` and the Kotlin runtime are declared as libraries but not used.
- No tests, contribution guide or `LICENSE` file.
