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
2. Set your repo to public. This allows anyone to see your code.
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
4. Click the `Add rule` button.
4. Type `master` into the `Branch name pattern` text box.
5. Select `Require pull request reviews before merging` and `Include administrators`. 
6. Click `Create`.
7. Click `Save changes`.

## Modify README

To test that everything is connected, and to make it easier for your teammates to clone your repo, modify the `README.md` file.

The `README.md` file contains the content that shows in your repo's GitHub page. Change it to mention your team's name, and change the Cloud Shell link to the next step.

Change the `This repo contains the projects you'll work on throughout CodeU.` line to your team's name, or your team number if you don't have a name yet.

Find this part of the `README.md` file:

```
cloudshell_git_repo=https://github.com/KevinWorkman/gcloud-tutorials.git
```

Change it to point to your repo instead.

Then find this part of the `README.md` file:

```
cloudshell_tutorial=week-0-setup/github-setup-walkthrough.md
```

You just completed that setup, so change it to point to the next step everyone should follow:

```
cloudshell_tutorial=week-0-setup/intro-walkthrough.md
```

The `README.md` file now belongs to your team. You should feel free to customize it and make it your own!

## Push Your Changes

To save your changes to your team's repo, first create a branch:

```bash
git checkout -b YOUR_BRANCH_NAME
```

(You can use anything you want for `YOUR_BRANCH_NAME`. I normally use something like `KevinDevelopment`.)

Add the `README.md` file to the set of changes you want to upload:

```bash
git add README.md
```

Then create a commit which describes the changes you just made:

```bash
git commit -m "Update README.md file to point to team's repo and next setup step."
```

Finally, push all of your changes to the shared repo:

```bash
git push origin YOUR_BRANCH_NAME
```

Your changes are now stored in a branch on your team's repo. Follow the instructions for creating a pull request on the CodeU website to send your changes to your team for review.

## Congratulations!

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

After you send your pull request, you're done with the GitHub repo setup!

You can keep working from the `gcloud-tutorials` directory, or you can delete it and click the `Open in Google Cloud Shell` button from your team's repo to jump to the next step.