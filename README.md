# BakuLib
## Overview
This is a Maven library which defines a set of classes that make Bakugan-oriented development simpler, easier
and more streamlined.

## Usage
Simply run `mvn clean install` and add the following dependency to your `pom.xml`:
```
<dependency>
    <groupId>nz.bakuganrerolled</groupId>
    <artifactId>bakulib</artifactId>
    <version>{version}</version>
</dependency>
```
Substituting `{version}` with the latest version of the Maven package. Check the Releases page for this.

## Documentation
This project uses Javadoc for in-line documentation concerning classes and methods. If you would prefer a more user-friendly
view of the Javadoc comments, you can simply run `mvn javadoc:javadoc`. Then, you can open the `index.html` file under 
`target/site/apidocs/` and view the Javadoc documentation in your preferred web browser.
