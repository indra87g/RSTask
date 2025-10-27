# Task System
----
### Plugin Introduction
This is a plugin that can realize a variety of task functions
----
#### Implemented tasks
- [x] Player places block task
- [x] Player destroys block task
- [x] Player picks up item task
- [x] Player uses iron bucket task
- [x] Player eats item task
- [x] Player collects item task
- [x] Player drops item task
- [x] Player crafts item task
- [x] Player clicks on the ground with an item in hand task
- [x] DIY task (requires developer support)
----
#### Achievable tasks
- [x] Daily tasks
- [x] Main/side quests
- [x] Time-limited tasks
#### How to use
| Command       | Description   |
| --------   | -----:  |
| /c <task name (optional)>     | Player wakes up the task command (if the task name is set, the task UI will be opened directly)   |
| /sh <name/number (optional)> <quantity (optional)>        |   Save the item held by the player in TagItems.json   |
| /ic        |    Create task    |
| /del-task <task name>        |    Delete task    |

##### How to create the first task
1. Enter the command /ic to wake up the create task UI
2. Modify the configuration file
```yaml
# Task difficulty
Task difficulty: 1
# Task introduction
Task introduction: Law of survival: To get rich, you must first chop trees
# Task refresh time Player can receive the task again after x days
Refresh time (days): 0
# Task type
# Destroy: Player destroys block task
# Place: Player places block task
# Collect: Player collects item task
# Craft: Player crafts item task
# Obtain: Player obtains item task
# Eat:   Player eats item task
# Fetch water: Player uses iron bucket task
# Click: Player clicks on the ground with an item in hand task
# Custom: Custom tasks from other plugins
Task type: Collect

# If not null, it will be judged whether the player has completed the prerequisite tasks before receiving this task
Must be completed before this task: null

Task content:
  # Task branch @tag is the suffix Read the items (Nbt items) in the TagItem.json file
  6089@tag: 10
  # Ordinary items only judge the items of ID:special value
  17:1@item: 10

# Reward for the first time a player completes a task
First completion reward:
  Items:
  # The format must be id:special value:quantity@item or number@tag. Remember to add quotation marks
  - "264:0:1@item"
  # The format must be command:alias @p represents the player. Remember to add quotation marks
  Cmd: []
  # Money
  Money: 100
  # Task points
  Count: 10
Reward:
  Items:
  - "264:0:1@item"
  Cmd: []
  Money: 100
  # If the points are 0, this task is a one-time task and the player can only complete it once
  Count: 10
# 0 server-wide announcement 1: only send to players
Completion announcement type (0/1): 0
Announcement content: "§l§c[§bTask System§c]§eCongratulations §a%p §ecompleted the §d[ %s ]§etask"
Custom button image:
  Location: "local"
  Path: "textures/items/book_enchanted"
 ````