apply{
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.photoListDomain))
    "implementation"(project(Modules.network))

    "implementation"(Paging.paging3)
}