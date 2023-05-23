apply{
    from("$rootDir/base-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.photoListDomain))

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.gsonConverter)

    "implementation"(Paging.paging3)

    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
}