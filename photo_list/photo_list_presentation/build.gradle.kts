apply {
    from("$rootDir/compose-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))

    "implementation"(project(Modules.photoListDomain))

    "implementation"(Compose.paging3)
    "implementation"(Coil.coilCompose)
}