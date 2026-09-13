# Streaky SMP Plugins

Minecraft Paper server plugins for the Streaky SMP network. Each plugin lives
in its own repository with its own build, documentation and tests.

## Plugins

| Plugin | Repository | Description | Status |
|---|---|---|---|
| **ServerCore** | [streaky-smp/ServerCore](https://github.com/streaky-smp/ServerCore) | Economy, server shop, auction house, land claims, player shops, spawn plots with rent, teleports, statistics and leaderboards | 250 tests passing |

## Adding a new plugin

1. Create a new repo under the `streaky-smp` org: `streaky-smp/<PluginName>`
2. Use [ServerCore](https://github.com/streaky-smp/ServerCore) as a reference — it has the Maven build, `build.ps1` and release workflow already set up
3. Each plugin should be self-contained: own `pom.xml`, own `build.ps1`, own `.github/workflows/release.yml`
4. Add a row to the table above
5. Target platform: Paper 26.2+ / Java 25

## Build structure

Every plugin follows the same layout:

```
PluginName/
  pom.xml              # Maven build
  build.ps1            # Local build script (sets JAVA_HOME, runs mvn)
  src/
    main/java/         # Plugin source
    main/resources/    # plugin.yml, config.yml, etc.
    test/java/         # JUnit 5 tests
  .github/workflows/
    release.yml        # Builds on tag push, creates GitHub Release
  README.md            # Plugin-specific docs
```

## Releasing

Tag a version and push — CI builds the jar and creates a GitHub Release:

```bash
git tag v1.0.0
git push origin v1.0.0
```

This project follows [Semantic Versioning](https://semver.org/):
- **MAJOR** — breaking changes
- **MINOR** — new features, backward compatible
- **PATCH** — bug fixes, drop-in replacement
