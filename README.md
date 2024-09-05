## [link to Fakebook_Android_App git repository](https://github.com/EliyahuYadegari/Fakebook_Android_App.git)
# Fakebook - Social Networking Android Application
Fakebook is a social networking Android application that allows users to create profiles, log in, post content, and interact with existing posts through likes and comments.
In its present iteration, the app allows for the registration of users and loads posts from a JSON file received from the server. Rerunning the application does not affect the user created, seeing as it's been added to the servers database.

## How to use?
#### 1. Prerequisites
Clone the repository to your local machine.
Ensure you have Android Studio installed.
#### 2. Installation
Open Android Studio.
Click on "Open an existing Android Studio project".
Navigate to the directory where you cloned the "AP-Project2-Android" repository and select it.
Wait for Android Studio to build the project.

## Usage
1. Once the project is opened in Android Studio, connect your Android device or start an emulator.
2. Run the server by opening the [servers repository](https://github.com/Shiranle07/Fakebook_Server.git) and entering "node app.js" in its terminal.
3. Get back to the apps repository and run the application by clicking the green "Run" button in Android Studio. The application will launch on your device or emulator.
   Register for a new account by completing all fields within the sign-up (fragmented). Once you have registered, log in using the email address and password you provided during registration. Upon logging in, you can access the feed page to view existing posts, like and comment on the posts.
   in the top left there's a plus button, which allows you to add a post, and in the top right theres a search button but it's not active yet.
   To access additional options, click the menu button located at the bottom of the screen, you will move to a page where you can switch to dark mode by clicking on a dedicated switch, or logout and return to the login page

## Workflow
First we read the task together in its entirety to ensure we correctly understood what was assigned to us. We brainstormed ideas for implementation and divided the general tasks among ourselves, which we then added to JIRA. 
Our initial task was to divide the work, and we decided that each of us would create a different page in the application. We utilized separate branches on GitHub for each feature, merging them using pull requests only after confirming that the code works as intended. 
The code is structured into layout files and Java classes for each page in the application. 
Additionally, we created separate layout files and Java classes for each component: log-in, sign-up, feed. for each of them there are also some supporting classes.

### what the app contains:
we created a log in, people can sign in from there. if they want to sign up they can do it in sign up, which is split into fragments (like in Facebook).
we created a class containing constraints for the sign up and used it to check its validity.
for each stage there is a verification that the input is valid, it returns an error after trying to create a new user with an existing users email. the validation mentioned- for signup it checks that it meets the requirements, for login it checks that the user exists and the password is correct.
restrictions: username must be an email- be of pattern letters@letters.letters. password must contain between 8-20 characters, at least one digit, one letter.
must put in a name- first and last which are letters only.
and must put a profile photo- from gallery or camera.
after signing up he's transferred to login for logging in.
after log in he's transferred to the apps feed, containing 10 json posts, each post contains a photo, a name of the poster, and a description.
he can add a post by pressing the plus button (top, third from left), and then he must (in orfer to post) choose a photo from gallery or camera, and write a description.
he can get to menu (three stripes) to see he's contact, move to dark mode, or log out.
he can comment on a post by pressing the comment button, then he can see previous comments or post new ones, plus he can like\edit\delete them.
he can like the post or "share" (doesn't share yet).
he can edit or delete the posts.
he can press on the  search icon which will open a place to input search (the search isn't implemented yet).
we built everything be creating a layout file for the activity\fragment, and then a java file for the activity\fragment, plus a java file for the adapter of the recycler view.
the xml contains the layout (views, buttons, etc), and the java file contains the logic of the activity\fragment.
the adapter contains the logic of the recycler view.

use branch main-part3 for the most updated code.





