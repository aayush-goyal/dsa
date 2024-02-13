plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "dsa"
include("src:main:search")
findProject(":src:main:search")?.name = "search"
