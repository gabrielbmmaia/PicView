object Compose {
    const val composeVersion = "1.3.0"
    const val composeCompilerVersion = "1.4.3"
    const val composeMaterialVersion = "1.1.0"
    const val composePagingVersion = "1.0.0-alpha19"

    const val paging3 = "androidx.paging:paging-compose:$composePagingVersion"

    const val material3 = "androidx.compose.material3:material3:$composeMaterialVersion"
    const val material3Window = "androidx.compose.material3:material3-window-size-class:$composeMaterialVersion"

    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val navigationVersion = "2.5.3"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.6.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.6.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}