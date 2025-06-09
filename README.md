# Taskify

Taskify is a simple multiplatform TODO app built with [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform).

## Modules
- `shared` – Kotlin Multiplatform module containing the Compose UI and business logic.
- `androidApp` – Android application using the shared code.
- `iosApp` – iOS application wrapping the shared Compose UI in SwiftUI.

## Building
A system installation of **Gradle** is required. Run the following command to list available tasks:

```bash
gradle tasks --all
```

Xcode projects invoke `gradle` directly and do not rely on the wrapper scripts, avoiding large binary files in version control.
