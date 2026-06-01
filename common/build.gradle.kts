plugins {
    id("multiloader-base")
    id("java-library")
    id("net.fabricmc.fabric-loom")
    id("io.freefair.lombok") version "9.2.0"
}

loom {
    // Correct way to set mappings in Kotlin DSL
    mappings = loom.officialMojangMappings()
}

dependencies {
    minecraft("com.mojang:minecraft:${BuildConfig.MINECRAFT_VERSION}")

    compileOnly("net.uku3lig:ukulib-common:${BuildConfig.UKULIB_VERSION}")

    compileOnly("net.fabricmc:sponge-mixin:0.17.0+mixin.0.8.7")
    compileOnly("io.github.llamalad7:mixinextras-common:0.5.1")
    annotationProcessor("io.github.llamalad7:mixinextras-common:0.5.1")
}

tasks.jar { enabled = false }
