apply{
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.seeMoreDomain))
    "implementation"(project(Modules.network))

    "implementation"(Paging.paging3)
}