# Git / GitHub Protocol — Teaching Project `compassMap`

> This document describes the **daily Git and GitHub workflow** for the teaching project.

- **Repository:** [https://github.com/AlbertProfe/compassMap](https://github.com/AlbertProfe/compassMap)

---

## 1. Teacher Workflow

| Action               | Details                                                                        |
| -------------------- | ------------------------------------------------------------------------------ |
| **Branch**           | Always works on `master` (local and remote)                                    |
| **Local repository** | Cloned or forked from `https://github.com/AlbertProfe/compassMap`              |
| **Daily routine**    | Commit changes and **push to remote** every day                                |
| **Goal**             | Keep the remote `master` branch as the single source of truth for all students |

**Teacher commands (example):**

```bash
git add .
git commit -m "Daily update: [short description]"
git push origin master
```

---

## 2. Student Workflow

### Step 1 — Fork the repository (once)

1. Go to [https://github.com/AlbertProfe/compassMap](https://github.com/AlbertProfe/compassMap)
2. Click the **Fork** button (top right)
3. Create your personal fork.  
   **Example:** `https://github.com/FrancescaStudent/compassMap`

> Your fork is your personal copy. You will push your work to **your fork**, never to the teacher’s repository.

---

### Step 2 — Clone on the first day

Students clone the **teacher’s repository** the first day:

```bash
gh repo clone AlbertProfe/compassMap
cd compassMap
```

> Alternative (classic):

```bash
git clone https://github.com/AlbertProfe/compassMap.git
cd compassMap
```

After cloning, add your own fork as a remote (recommended):

```bash
git remote add myfork https://github.com/FrancescaStudent/compassMap.git
```

Check remotes:

```bash
git remote -v
```

You should see something like:

```
origin    https://github.com/AlbertProfe/compassMap.git (fetch)
origin    https://github.com/AlbertProfe/compassMap.git (push)
myfork    https://github.com/FrancescaStudent/compassMap.git (fetch)
myfork    https://github.com/FrancescaStudent/compassMap.git (push)
```

---

### Step 3 — Work **only** on local branches (never on `master`)

**Rule:** Students must **never** commit or work directly on the `master` branch.

#### Create a new feature branch every time you start work

```bash
# Make sure you are up to date first (see Step 4)
git checkout master
git pull origin master

# Create and switch to a new branch
git checkout -b feature/my-task-name
# or
git switch -c feature/my-task-name
```

**Good branch naming examples:**

- `feature/add-login`
- `feature/exercise-03`
- `fix/typo-in-readme`
- `docs/update-protocol`

#### Daily work on your branch

```bash
git add .
git commit -m "Clear and meaningful commit message"
```

Push your branch to **your fork**:

```bash
git push myfork feature/my-task-name
```

---

### Step 4 — Sync every day (mandatory)

Students **must sync and pull every day** before starting work.

#### Recommended daily sync sequence

```bash
# 1. Go to master
git checkout master

# 2. Pull the latest changes from the teacher
git pull origin master

# 3. Switch back to your feature branch
git checkout feature/my-task-name

# 4. Merge (or rebase) the updated master into your branch
git merge master
# or (cleaner history)
git rebase master
```

If you have conflicts, resolve them carefully, then:

```bash
git add .
git commit -m "Merge/rebase master into my branch"
```

---

## 3. Summary of Rules for Students

| Rule                     | Description                                               |
| ------------------------ | --------------------------------------------------------- |
| **Fork**                 | Create your own fork (e.g. `FrancescaStudent/compassMap`) |
| **Clone**                | First day: `gh repo clone AlbertProfe/compassMap`         |
| **Never work on master** | Always create and use feature branches                    |
| **Sync daily**           | `git pull origin master` every day before starting        |
| **Push to your fork**    | Never push to the teacher’s repository                    |
| **Commit messages**      | Clear, meaningful, and in English or the project language |

---

## 4. Quick Reference Commands

```bash
# Daily start
git checkout master
git pull origin master
git checkout -b feature/new-task   # or switch to existing branch

# After working
git add .
git commit -m "What I did today"
git push myfork feature/new-task

# End of day / before leaving
git checkout master
git pull origin master
```

---

## 5. Common Mistakes to Avoid

- Working and committing directly on `master`
- Forgetting to pull from the teacher every day
- Pushing to `origin` (teacher’s repo) instead of your own fork
- Creating branches from an outdated `master`
- Not resolving merge conflicts carefully

---

**Remember:**  
The teacher’s `master` branch is the official source of truth.  
Your job is to keep your local copy synchronized and to develop features safely on separate branches.

Happy coding! 🚀
