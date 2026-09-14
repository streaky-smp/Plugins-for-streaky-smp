# Streaky SMP Plugins

Minecraft Paper server plugins for the Streaky SMP network. Each plugin lives
in its own repository with its own build, documentation and tests.

## Plugins

| Plugin | Repository | Build | Description |
|---|---|---|---|
| **ServerCore** | [streaky-smp/ServerCore](https://github.com/streaky-smp/ServerCore) | ![Build](https://github.com/streaky-smp/ServerCore/actions/workflows/build.yml/badge.svg) | Economy, server shop, auction house, land claims, player shops, spawn plots with rent, teleports, statistics and leaderboards |

## Workflows

Shared workflow templates live in [`template/.github/workflows/`](template/.github/workflows/)
and are also mirrored in [`workflows/`](workflows/) for quick copies.
When creating a new plugin, copy the entire [`template/`](template/) directory into the new repo:

```bash
# Set up a new plugin from the template:
cp -r template/ <PluginName>/
# Then rename PluginName references in pom.xml, plugin.yml, etc.
```

| Workflow | File | Trigger | What it does |
|---|---|---|---|
| Build & Test | [`build.yml`](template/.github/workflows/build.yml) | Push to `main`, PRs | Builds the plugin, runs all tests. Fails the build if any test fails. |
| Release | [`release.yml`](template/.github/workflows/release.yml) | Tag push (`v*`) | Builds, runs tests, creates a GitHub Release with the jar attached. |

```bash
# Set up a new plugin with both workflows:
mkdir -p <PluginName>/.github/workflows
cp workflows/build.yml <PluginName>/.github/workflows/
cp workflows/release.yml <PluginName>/.github/workflows/
```

## Adding a new plugin

1. Create a new repo under the `streaky-smp` org: `streaky-smp/<PluginName>`
2. Copy the entire [`template/`](template/) directory into the new repo and rename it
3. Update the `pom.xml`, `plugin.yml` and class names to match your plugin
4. Use [ServerCore](https://github.com/streaky-smp/ServerCore) as a full reference implementation
5. Each plugin should be self-contained: own `pom.xml`, own `build.ps1`, own docs
6. Add a row to the plugins table above (include the build badge)
7. Target platform: Paper 26.2+ / Java 25

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
    build.yml          # CI: build + test on push/PR
    release.yml        # Release: build + GitHub Release on tag push
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
