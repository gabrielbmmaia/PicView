apply{
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))

    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
}