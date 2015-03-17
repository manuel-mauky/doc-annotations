# doc annotations

This package contains some Java annotations that can be used to document your code.

For example if a Class/Method of your library is *unstable* and is likely to be changed in the future,
you could use the `@Unstable` annotation to express this issue. 


The idea for this package is based on the [@Beta][1] annotation that is part of the Google Guava library.

## Usage

All annotations in this module are marked with `RetentionPolicy.SOURCE`. This means that the annotation
is visible in your source code and when your JavaDoc is generated but not at runtime. This has the benefit
that you don't need the `doc-annotations.jar` on your classpath at runtime. 

When you use *maven* you can use the following dependency declaration:

```xml
<dependency>
    <groupId>eu.lestard</groupId>
    <artifactId>doc-annotations</artifactId>
    <version>0.1</version>
    <scope>provided</scope>
</dependency>
```

With *gradle*:

```groovy
dependencies {
    compile 'eu.lestard:doc-annotations:0.1'
}
```

Gradle doesn't support a "provided" (compile-time only) scope out of the box. With the configuration above gradle will use the
dependency at runtime too. 

If this is a problem for you see f.e. [this answer on StackOverflow](http://stackoverflow.com/a/25041082) for a workaround.




[1]: https://github.com/google/guava/blob/master/guava/src/com/google/common/annotations/Beta.java