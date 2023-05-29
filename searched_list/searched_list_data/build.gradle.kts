apply{
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.network))
    "implementation"(project(Modules.searchedDomain))

    "implementation"(Paging.paging3)
}