Codility WebAutomation Task
=================

Selenium-cucumber : Automation Testing Using Java

Download or Clone a Framework
--------------
* Maven - https://github.com/pkhk2020/BDDTest.git

Configuring the framework locally
--------------
- Once framework downloaded or cloned to the local machine, run below commands.
- `git clone https://github.com/pkhk2020/BDDTest.git`
- `mvn clean compile` or `mvn clean install -DskipTests` (this will be bring all dependencies to local `.m2/repository` folder)
- Ensure `chromedriver.exe` in `BDDTest/drivers` location should be same version as your local chromebrowser version.
    you can download chromedrivers from [here](https://chromedriver.chromium.org/downloads)
 
Running or Executing the Test
--------------
- Navigate to resources `/Features/TestScriptDemo.feature`
- Run the script from feature file.
- Also can be run using `TestRunner.java` file using tag (Test)
- Also can be run using `mvn test "-Dbrowser=chrome"`
 
Running test using TestRunner
--------------
```
package com.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHtmlReport"},
        features = "classpath:Features",
        glue = {"com.steps"},tags = {"@Test"}
)

public class TestRunner {
}
```
Used below commands to upload in to Git Repository
----------------------
````
create a new repository on the command line
echo "# BDDTest" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/pkhk2020/BDDTest.git
git push -u origin main
````