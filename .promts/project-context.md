# SpaceX Dragon Rockets Repository - Project Context

## Project Overview
This is a Java-based coding exercise project for implementing a SpaceX Dragon rockets repository system. It's a simple library (not REST API/web service) that manages rockets and missions with in-memory storage.

## Exercise Requirements
**Core Operations:**
1. Add new rocket (initial status: "On ground")
2. Assign rocket to mission (1 rocket = 1 mission max)
3. Change rocket status
4. Add new mission (initial status: "Scheduled")
5. Assign rockets to mission (1 mission = multiple rockets)
6. Change mission status
7. Get summary of missions by rocket count (descending alphabetical order for same count)

**Rocket Statuses:**
- "On ground" - initial, not assigned to mission
- "In space" - assigned to mission
- "In repair" - causes mission "Pending" status
- "In build" - special status

**Mission Statuses:**
- "Scheduled" - initial, no rockets assigned
- "Pending" - rockets assigned, one+ in repair
- "In Progress" - rockets assigned, none in repair
- "Ended" - final stage, no more rocket assignments

## Project Structure
- **Language**: Java
- **Build Tool**: Gradle (multi-project build)
- **Main Module**: `core` - contains the primary application logic
- **Package Structure**: `io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core`
- **Build Logic**: Custom convention plugins in `build-logic/`
- **Storage**: In-memory collections (no frameworks/databases)

## Development Guidelines
- Follow Google Java coding standards: https://google.github.io/styleguide/javaguide.html
- Use Test-Driven Development (TDD)
- Apply SOLID principles and clean code practices
- Focus on OO design quality
- Use minimal, focused implementations
- Maintain clean separation between main and test code
- Leverage Gradle's convention plugins for consistent builds

## Key Directories
- `core/src/main/java/` - Main application source code
- `core/src/test/java/` - Unit tests
- `build-logic/` - Custom Gradle convention plugins
- `.promts/` - Q CLI prompts and project documentation

## When Working on This Project
- Implement repository pattern for rockets and missions management
- Keep implementations minimal and efficient
- Follow the existing package structure under `io.github.aliaksandrrachko`
- Use appropriate Java patterns and conventions
- Focus on the 7 core operations and status management rules
- Consider edge cases and validation
- Maintain commit history showing TDD progress
