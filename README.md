# ☕ Java Interview Preparation

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![LeetCode](https://img.shields.io/badge/LeetCode-15_problems-FFA116?logo=leetcode&logoColor=white)
![Status](https://img.shields.io/badge/status-in_progress-blue)

Solutions, task statements and notes collected while preparing for Java developer interviews:
algorithm practice (LeetCode, Coderbyte) and real take-home / live-coding tasks from company interviews.

## 📑 Table of Contents

- [Legend](#-legend)
- [LeetCode](#-leetcode)
- [Coderbyte](#-coderbyte)
- [Company Interview Tasks](#-company-interview-tasks)
  - [Tesco](#tesco)
  - [BNP Paribas](#bnp-paribas)
  - [Karat](#karat)
  - [TestDome](#testdome)
- [How to Run](#-how-to-run)
- [Repository Structure](#-repository-structure)

## 🔖 Legend

| Icon | Meaning |
|:---:|---|
| ✅ | Solved on my own |
| 🤖 | AI-assisted solution |
| 🚧 | Work in progress / does not compile yet |
| 📄 | Task statement only |

## 🧩 LeetCode

Grouped by topic — full table in [LeetCode/README.md](LeetCode/README.md).

| Topic | Problems |
|---|---|
| **Arrays & Hashing** | [1. Two Sum](LeetCode/arrays-hashing/TwoSum.java) ✅ · [14. Longest Common Prefix](LeetCode/arrays-hashing/LongestCommonPrefix.java) 🤖 · [49. Group Anagrams](LeetCode/arrays-hashing/GroupAnagrams.java) ✅ · [128. Longest Consecutive Sequence](LeetCode/arrays-hashing/LongestConsecutiveSequence.java) ✅ · [217. Contains Duplicate](LeetCode/arrays-hashing/ContainsDuplicate.java) ✅ · [242. Valid Anagram](LeetCode/arrays-hashing/ValidAnagram.java) ✅ |
| **Two Pointers** | [26. Remove Duplicates from Sorted Array](LeetCode/two-pointers/RemoveDuplicatesSortedArray.java) ✅ · [125. Valid Palindrome](LeetCode/two-pointers/ValidPalindrome.java) ✅ · [167. Two Sum II](LeetCode/two-pointers/TwoSumII.java) ✅ 🤖 · [283. Move Zeroes](LeetCode/two-pointers/MoveZeroes.java) ✅ |
| **Stack** | [20. Valid Parentheses](LeetCode/stack/ValidParentheses.java) ✅ · [150. Evaluate RPN](LeetCode/stack/EvaluateReversePolishNotation.java) ✅ · [225. Stack using Queues](LeetCode/stack/ImplementStackUsingQueues.java) 🤖 · [1047. Remove Adjacent Duplicates](LeetCode/stack/RemoveAdjacentDuplicates.java) ✅ |
| **Linked List** | [92. Reverse Linked List II](LeetCode/linked-list/ReverseLinkedListII.java) ✅ |

## 🎯 Coderbyte

| Problem | Complexity (time) | Status |
|---|---|:---:|
| [LRU Cache](Coderbyte/LruCache.java) | O(n) | ✅ 🤖 |
| [Matching Characters](Coderbyte/MatchingCharacters.java) | O(n²) / O(n³) | ✅ |

## 🏢 Company Interview Tasks

### Tesco
| Task | Files | Status |
|---|---|:---:|
| Skill-Based Pay Calculator — weekly pay from contract rate + skill differential | [Task](Tesco/README.md) · [Solution](Tesco/SkillBasedPayCalculator.java) | 🚧 |

### BNP Paribas
| Task | Type | Status |
|---|---|:---:|
| [Product Filter and Sort REST API](BNP-Paribas/product-filter-sort-api.md) | Java / Spring REST | 📄 |
| [Companies With More Than 10,000 Employees](BNP-Paribas/companies-over-10000-employees.md) | SQL | 📄 |

### Karat
| Task | Files | Status |
|---|---|:---:|
| Online Gaming Platform — fix `GameManager` bug, add match results & average score by outcome | [Task](Karat/README.md) · [Solution](Karat/Solution.java) | 🚧 |

### TestDome
| Task | Topic | Status |
|---|---|:---:|
| [MovieRepository](TestDome/MovieRepository.java) | Spring JDBC (`JdbcTemplate`) | 🚧 |
| [ServiceAOP](TestDome/ServiceAOP.java) | Spring AOP (`@Aspect`) | 🚧 |

## ▶️ How to Run

Plain `.java` files, no build tool. Requires **JDK 25** (uses `java.lang.IO` and instance `main`).

```bash
# single-file source launch
java Coderbyte/LruCache.java
java Coderbyte/MatchingCharacters.java

# compile-check a solution
javac -d out LeetCode/stack/ValidParentheses.java
```

## 🗂 Repository Structure

<details>
<summary>Click to expand</summary>

```
Java-Interview-Preparation/
├── LeetCode/
│   ├── arrays-hashing/
│   ├── two-pointers/
│   ├── stack/
│   └── linked-list/
├── Coderbyte/
├── Tesco/
├── BNP-Paribas/
├── Karat/
└── TestDome/
```

</details>
