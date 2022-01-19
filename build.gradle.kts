plugins {
    `java-library`
    `maven-publish`
    signing
}

group = "eu.lestard"
version = "0.3"

val projectName="doc-annotations"
val projectDescription="A collection of Java annotations used to document your code"
val projectUrl="https://github.com/lestard/doc-annotations"
val projectScm="scm:git@github.com:lestard/doc-annotations.git"
val projectLicenseName="MIT License"
val projectLicenseUrl ="http://opensource.org/licenses/mit-license"
val projectLicenseDistribution="repo"
val projectDeveloperName="Manuel Mauky"

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
}

publishing {
    publications {
        create<MavenPublication>("doc-annotations") {
            artifactId = projectName
            from(components["java"])

            pom {
                name.set(projectName)
                description.set(projectDescription)
                url.set(projectUrl)
                licenses {
                    license {
                        name.set(projectLicenseName)
                        url.set(projectLicenseUrl)
                        distribution.set(projectLicenseDistribution)
                    }
                }
                developers {
                    developer {
                        id.set(projectDeveloperName)
                        name.set(projectDeveloperName)
                    }
                }
                scm {
                    connection.set(projectScm)
                    developerConnection.set(projectScm)
                    url.set(projectUrl)
                }
            }
        }
    }

    repositories {
        maven {
            val releasesRepoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

            val sonatypeUsername: String by project
            val sonatypePassword: String by project

            credentials {
                username = sonatypeUsername
                password = sonatypePassword
            }
        }
    }
}

signing {
    sign(publishing.publications["doc-annotations"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
