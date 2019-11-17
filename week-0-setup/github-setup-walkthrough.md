# GitHub Repo Setup

Follow this walkthrough to setup your team's GitHub repo.

You can return to this walkthrough anytime by running this command:

```bash
teachme github-setup-walkthrough.md
```

## Getting Started

[GitHub](https://github.com/) is a Git repository host, which means that it's a website that allows you to store code. This is useful for [version control](https://en.wikipedia.org/wiki/Version_control), to release code as open source, or to collaborate with a team. You're going to use GitHub to store your team's projects.

Every member of your team needs a GitHub account, so make sure everyone registers.

After everyone has a GitHub account, then **one** teammate should continue this setup. Talk with your team to decide who should own this.

## Unlink Google's Repo

Right now, this code still points to Google's repository instead of your team's repository. To fix that, you're first going to remove the pointer to Google's repo.

Normally you wouldn’t need this step when forking a repo, but this will make it easier to collaborate with your team.

To unlink this directory from Google's repo, execute this command:

```bash
git remote remove origin
```

## Create a GitHub Repository

On [GitHub](https://github.com/), click on the `+` in the top-right and click on `new repository`. This will take you to a page to create your repo on GitHub. 

1. Enter a repository name. Something like `team-XX-codeu` is a fine name.
2. Set your repo is to public. This allows anyone to see your code.
3. Click the green `create repository` button!

At this point you should have an empty repo.



## Link Your Repo

In your GitHub repo page, find your repo's URL. It should end in `.git`, like `https://github.com/KevinWorkman/team-00-codeu.git`. Copy that URL.

To link this directory to your repo, execute this command:

```bash
git remote add origin YOUR_URL_HERE
```

Then to store this directory in your repo, run this command:

```bash
git push -u origin master
```

You should now see this code in your team's repo on GitHub!

## Add Collaborators

To give your teammates access to the repository, add them as collaborators.

1. Go to the `Settings` tab.
2. Select `Collaborators`.
3. Add your your teammates and Project Advisor using their GitHub usernames or email addresses.

Your team can now contribute to your project.

## Require Pull Requests

When your team writes code, you're going to use **pull requests** to do code reviews. To prevent accidentally modifying the code without going through a code review, set your repo to require pull requests.

1. Go to your GitHub repo page.
2. Click the `Settings` tab.
3. Select `Branches`.
4. In the `Branch protection rules` section, click the `Add rule` button, and then type `master` into the `Branch name pattern` text box.
5. Select `Require pull request reviews before merging` and `Include administrators`. 
6. Click `Save changes`.

## Modify README

To test that everything is connected, and to make it easier for your teammates to clone your repo, modify the `README.md` file.




