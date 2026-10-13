# Karat — Online Gaming Platform (Question №3)

> 🚧 [Solution.java](Solution.java) — `addMatchResult` / `getAverageScoreByOutcome` implemented;
> file contains a leftover `@Value` / `@DefaultValue(value =)` on `GameManager.matchResults` and does not compile yet.

## Part 1
We are building the back-end for an online gaming platform. The system tracks players and their
match history. Each match result records the outcome from that player's perspective.

- A **player** has: `playerId`, `username`.
- A **match result** has: `playerId`, `opponentId`, `outcome`, `score`, `timestamp`.
- **Outcome** is one of: `WIN`, `LOSS`, `DRAW`.
- **GameManager** manages players and match results and provides player statistics.

1. Read through and understand the code. Feel free to run it.
2. The test for `GameManager` is not passing due to a bug in the code. Fix the bug.

## Part 2
Extend the platform to record match results and compute per-player score statistics.

1. **`addMatchResult`** — store a match result. If the `playerId` does not refer to a known player, ignore it.
2. **`getAverageScoreByOutcome`** — return a map of each outcome to the player's average score for it.
   Only outcomes with at least one result appear; a player with no results gets an empty map.

Tests provided: `testGetPlayerStatistics`, `testAddMatchResult`, `testGetAverageScoreByOutcome`
(run with `java -ea Solution.java`).
