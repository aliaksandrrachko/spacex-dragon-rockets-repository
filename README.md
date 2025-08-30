# SpaceX Dragon Rockets Repository

## Overview
A Java library for managing SpaceX Dragon rockets and missions. This is a coding exercise implementation using in-memory storage and following Test-Driven Development (TDD) principles.

## Functionality

### Core Operations
1. **Add new rocket** - Creates rocket with initial status "On ground"
2. **Assign rocket to mission** - Each rocket can be assigned to only one mission
3. **Change rocket status** - Update rocket's current status
4. **Add new mission** - Creates mission with initial status "Scheduled"
5. **Assign rockets to mission** - Multiple rockets can be assigned to one mission
6. **Change mission status** - Update mission's current status
7. **Get missions summary** - Returns missions ordered by rocket count, then alphabetically (descending)

### Rocket Statuses
- **On ground** - Initial status, not assigned to any mission
- **In space** - Rocket is assigned to a mission
- **In repair** - Rocket needs repair, causes mission to be "Pending"
- **In build** - Rocket is under construction

### Mission Statuses
- **Scheduled** - Initial status, no rockets assigned
- **Pending** - Has assigned rockets, but one or more are in repair
- **In Progress** - Has assigned rockets, none are in repair
- **Ended** - Mission completed, no more rockets can be assigned

### Business Rules
- Rockets can only be assigned to one mission at a time
- Missions can have multiple rockets
- If any assigned rocket is "In repair", the mission becomes "Pending"
- Rockets cannot be assigned to "Ended" missions

## Example Output
```
Transit – In progress – Dragons: 3
  Red Dragon – On ground
  Dragon XL – In space
  Falcon Heavy – In space
Luna1 – Pending – Dragons: 2
  Dragon 1 – On ground
  Dragon 2 – On ground
Vertical Landing – Ended – Dragons: 0
Mars – Scheduled – Dragons: 0
Luna2 – Scheduled – Dragons: 0
Double Landing – Ended – Dragons: 0
```

## Technical Details
- **Language**: Java
- **Build Tool**: Gradle
- **Storage**: In-memory collections
- **Architecture**: Repository pattern
- **Testing**: TDD approach with comprehensive unit tests
- **Code Standards**: Google Java Style Guide

## Development Assumptions
- **Solo Development**: This project is developed by a single developer without branching strategies
- **AI Assistance**: Amazon Q (AWS AI assistant) Claude 3.5 Sonnet is used to help with code implementation, design decisions, and best practices
- **Commit Strategy**: Direct commits to main branch with clear, incremental progress following TDD principles
- **Simple Identifiers**: To keep the solution simple, models use string names as identifiers instead of UUIDs (rockets and missions are identified by their names as shown in the requirements)
- **Repository Pattern Only**: This implementation focuses solely on the repository pattern for data access. Cross-repository business rules (like "mission becomes Pending when any rocket is In repair") would be handled by a service layer in a complete application, not by the repositories themselves

---

SIX Coding Exercise
