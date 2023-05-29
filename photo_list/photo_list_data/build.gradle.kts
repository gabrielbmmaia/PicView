apply{
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.photoListDomain))
    "implementation"(project(Modules.network))

    "implementation"(Paging.paging3)

    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
}