# A*Search
A* Search algorithm applied to the Cannibals and Missionaries Problem

Original problem can be seen here: https://en.wikipedia.org/wiki/Missionaries_and_cannibals_problem

### Differences of my problem and the original problem:
Number of missionaries and cannibals are changed as 6 and the capacity of boat is changed as 5.

### Explanation of Used Heuristic
Admissible heuristic here we designed, checks all the possible next states and it selects the state that have the most number of CANNIBALS AND MISSIONARIES on left. Because, that state is heuristacally the closest one to the goal.

For example, if there are two possibilities, (3M and 3C) or (4M and 4C) on the east side. The admissible heuristic
function will choose second one because it is closer to the goal which is (6M and 6C) on the east side.

