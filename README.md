# Setup

### New Project
* enter the
  * name as `db-practice`
  * location
  * choose `gradle`
  * and choose `kotlin`

### Git
open the terminal and run
```bash
git init .
```
open the `.gitignore` file and at the top of the `### IntelliJ IDEA ###` section add:
```gitignore
.idea/
```
then you can
```bash
git add .
git commit -m 'init'
```

### Edit run config
* go to `Run > Edit Configurations...`
* on the bottom select `Edit configuration templates`
* make sure `Application` is selected
* select `modify options`
* `Add VM options`
* add `--enable-native-access=ALL-UNNAMED`

### Add SQL Driver
in `build.gradle.kts` in `dependencies` add
```
implementation("org.xerial:sqlite-jdbc:3.45.1.0")
implementation("org.slf4j:slf4j-simple:2.0.12")
```
So the `dependencies` should look like this:
```kotlin
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.xerial:sqlite-jdbc:3.45.1.0")
    implementation("org.slf4j:slf4j-simple:2.0.12")
}
```
Go to `View > Tool Windows > Gradle`
Select `db-practice`, right click, and select `Sync Gradle Project`

### Test the DB
Create a file with a main method in `src > main > java` with the following body

****Make sure to replace `ABSOLUTE_PATH_TO_DB_FILE` with the path to your db file*

****you will have to import `import java.sql.*;` as well*
```
String url = "jdbc:sqlite:ABSOLUTE_PATH_TO_DB_FILE";
try {
    DriverManager.getConnection(url);
    System.out.println("Connected to SQLite!");
} catch (SQLException e) {
    e.printStackTrace();
}
```

Run the program and check that it says `Connected to SQLite!`

If you see an error
```
java.sql.SQLException: No suitable driver found for jdbc:sqlite:ABSOLUTE_PATH_TO_DB_FILE
```
go back and check the `Add SQL Driver` and `Test the DB` sections