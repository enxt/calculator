# Calculator

### Previous execute
Execute this command to install external jar library in .m2:
```
mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator \
-DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
```

### Execution

For jar creation you must run:
```
mvn clean package
```

This generate the jar package in the target folder, to run service:
```
java -jar target/calculator-1.0.0.jar
```

Alternatively you can run this without create package:
```
mvn clean spring-boot:run
```
