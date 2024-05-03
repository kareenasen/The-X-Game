## Getting Started

Welcome to the X-Game! Here is a guideline to help you understand the Java code and run the game in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Running the Game

On GitHub, click on the "code" button. Then, copy the HTTPS link or click the double square icon to copy the link automatically. Once the link is cloned, enter your Visual Studio Code IDE
homepage and select "Clone Git Repository". After choosing that option, a search group tab bar should appear at the top. Paste the HTTPS link (CTRL V). Then, select the option: clone from URL. Select the destination on your computer where you would like the repository to be located. Once the location has been selected, click "Select the repository destination". Then select "Open". The entire folder of the X-Game code should appear. You should be able to view the different folders. Click on the SRC dropdown menu bar. Click on "Play.java" to open the file; select the dropdown menu of the play button and select "Run Code". Once the code is run, ensure the bottom tab of the IDE has the terminal tab open. Then type "java Play [board-size shape-length depth]". Change the board-size, shape-length, and depth dimensions. For a classic tic-tac-toe computer game, I like to type in the command: "java Play 3 3 3". Enjoy playing and navigating the X-Game!

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

