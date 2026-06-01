plugins {
    id("multiloader-base")
    id("java-library")
    id("net.fabricmc.fabric-loom")
    id("io.freefair.lombok") version "9.2.0"
}

// This is the critical missing part – define the Loom configuration
loom {
    // We are in a common project that will be used by both Fabric and NeoForge
    // So we only need the mappings, not the full environment
    // This attaches the Minecraft classes to the compile classpath
    runConfigs {}
}

dependencies {
    // Add Minecraft with official Mojang mappings – this provides all Minecraft classes
    minecraft("com.mojang:minecraft:${BuildConfig.MINECRAFT_VERSION}")
    mappings(loom.officialMojangMappings())

    compileOnly("net.uku3lig:ukulib-common:${BuildConfig.UKULIB_VERSION}")

    // Mixin dependencies
    compileOnly("net.fabricmc:sponge-mixin:0.17.0+mixin.0.8.7")
    compileOnly("io.github.llamalad7:mixinextras-common:0.5.1")
    annotationProcessor("io.github.llamalad7:mixinextras-common:0.5.1")
}

tasks.jar { enabled = false }
