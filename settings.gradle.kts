pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokemonInterviewApp"
include(":app")
include(":navigation")
include(":splash:presentation")
include(":home:presentation")
include(":home:domain")
include(":home:data")
include(":signIn:presentation")
include(":signIn:domain")
include(":signIn:data")
include(":signUp:presentation")
include(":signUp:domain")
include(":signUp:data")
include(":splash:domain")
include(":splash:data")
include(":common:data")
include(":common:core")
