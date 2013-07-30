import java.io.File;
import java.io.IOException;


public class LinuxCMD extends Libs
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
    final String os = System.getProperty("os.name").toLowerCase();
    if(!os.equals("linux")){
      print(os +" is not supported!");
      return;
    }
    final boolean[] arg = processArgs(args);
    if(arg[0] || !new File("./.level").exists())
      changeLevel(1);
    clear();
    createFile(".cmd");
    runFull("chmod 755 .cmd");
    switch(returnLevel()) {
    case 1:
      print("Hello puny human. My name is TCIAL. My job is to foil you at every turn and render all of your puny hopes and dreams to dust. >:(");
      sleep();
      print("Oh wait, eerrrm...wrong personality...hang on, give me a second to unscramble my innards...");
      sleep(5);
      print("Og glofasdf regdflskj, fdsjlewio! :D");
      sleep();
      print("Wiat, waht?");
      sleep();
      print("Ah, there we go! Sorry about that. Nice to meet you! My name is TCIAL, and my job is to help you succeed at everything you do and help you achieve your dreams! :D");
      sleep(4);
      print("To be more specific, I'm to help you learn how the shell works on a Linux system, and how you can use it to enormous benefit.");
      sleep(4);
      print("Almost anything you can do from a GUI, you can do from a shell, and then some more things on top of that, which proves to be really helpful.");
      sleep(4);
      print("Alright, well for your first task, I want you to list the files in the directory. Do you know what a directory is? (Y/N)");
      if(input.nextLine().equals("N")){
        print("A directory is just another name for a folder, like system32 or My Documents. On a Linux system, an example might be the etc directory, or home.");
        print("Directories are arranged in a heirarchy, that is, there can be directories inside other directories in a sort of file tree.");
        print("In all these directories, there can be other files or folders/directories.");
        print("In fact, directories are just special kinds of files!");
        sleep();
      }
      print("The directory that I want you to list the contents of I'll make really simple for you.");
      sleep();
      print("I'm going to put you in a commandLine interface. This is where you can run commands from.");
      sleep();
      print("Listing all of the files in the directory is easy. All you have to do is type \"ls\" and press enter.");
      print("Try it!");
      if(!triggerTerminal("ls")) {
        print("Hope you come back soon!");
        return;
      }
      changeLevel(2);
      print("Good job! See, that wasn't hard at all.");
      sleep();
    case 2:
      print("Different commands can have arguments, that is, kind of like other commands after the first one.");
      print("With these arguments, you can specify options to refine the output the command gives you.");
      print("For example, by specifying the -l option after typing ls, you can make ls display all the permissions of the files too!");
      sleep(9);
      print("So now you need to try it! Use ls with an argument of -l.");
      triggerTerminal("ls -l");
      changeLevel(3);
    case 3:
      print("Well now, I see that you understand ls, and arguments. Now it's time to learn a new command!");
      sleep();
      clear();
      print("The command cd is located in nearly all command lines, regardless of the operating system.");
      print("\"cd\" stands for \"change directory\". And that's exactly what it does.");
      print("\"cd\" must take an argument which is the directory to change to.");
      sleep(9);
      print("At this point, I'm also going to teach you relative filepaths.");
      sleep();
      print("Or, do you already understand them? (Y/N)");
      if(input.nextLine().equals("N")){
        clear();
        print("Relative filepaths are, in my humble opinion, pretty straightforward.");
        print("In every folder, there are two folders that you can't see. They are called \".\", and \"..\".");
        sleep(6);
        print("The folder \".\" is simply the folder you're already in. This lets you reference your working directory.");
        print("The folder \"..\" is the folder above you in the heirarchical structure.");
        print("Running \"cd ..\" is the same as hitting the up button when in the file explorer in windows xp.");
        sleep(9);
        print("For example, right now, you ran this program from a folder, " + runFull("pwd") + " which is the same folder as \".\".");
        print("The folder above you is " + runFull("cd ..\npwd") + " which is the same folder as \"..\".");
      }
      print("You also need to understand how absolute filepaths work. Are you familiar with absolute filepaths? (Y/N)");
      if(input.nextLine().equals("N")){
        clear();
        print("Absolute filepaths are filepaths that do not use \".\" or \"..\" in them.");
        sleep();
        print("Absolute filepaths start at what is called the root directory.");
        print("In Windows, the root directory is called 'C:/', and in Linux, it's called merely '/'.");
        sleep(6);
        print("An absolute filepath starts with either C:/ or /, depending of course, on the operating system you're using.");
      }
      print("There's one other command you should know, and that is \"pwd\".");
      sleep();
      print("\"pwd\" stands for \"Print Working Directory\", and prints where you are in the file hierarchy, kind of like which folder you're looking at in the Windows Explorer.");
      print("I'm going to put you in a folder, and you have to navigate your way to another folder using only relative filepaths!");
      sleep(6);
      String folder = findFolder();
      resetDirectory();
      print("The folder you need to get to is: " + folder);
      print("Good luck!");
      locationTerminal(folder);
      changeLevel(4);
      print("Good job!");
    case 4:
      print("Well, you're on to another level!");
      print("This next level is very easy.");
      sleep();
      print("All you have to do is print \"Hello World\" on the terminal.");
      sleep();
      print("To do so, you will want to use the command \"echo\".");
      print("Echo takes an argument, which is what to print, and the argument, depending on the situation, should be enclosed in quotations.");
      sleep(6);
      print("In this case, either way will work.");
      if(!triggerTerminal(array("Hello World","\"Hello World\""))) {
        print("Hope you come back!");
        return;
      }
      print("See, that wasn't hard at all!");
      changeLevel(5);
    case 5:
      print("Alright, onto your next challenge.");
      sleep();
      print("You are to make a copy of the file \"file1.txt\" to the file \"file2.txt\", so that file2 holds the same data as file1.");
      sleep();
      print("To do this, you want to use the command cp, which stands for copy. cp takes two different arguments.");
      sleep();
      print("The first argument is the file to copy.");
      print("The second argument is the file to copy to.");
      sleep(6);
      print("Good luck!");
      if(!triggerTerminal("cp file1.txt file2.txt")) {
        print("Hope you come back!");
        return;
      }
      print("That wasn't that hard I hope!");
      deleteFile("file1.txt");
      changeLevel(6);
      sleep();
    case 6:
      print("The next few levels are going to be very similar.");
      print("For example, the next command you're going to learn is the mv command which stands for move.");
      sleep(5);
      print("Just like cp, mv takes two arguments. The first argument is the file to be moved.");
      sleep();
      print("The second argument is where to move it to.");
      sleep();
      print("I have deleted the file, \"file1.txt\". I want you to move \"file2.txt\" to \"file1.txt\".");
      print("It shouldn't be hard!");
      if(!triggerTerminal("mv file2.txt file1.txt")) {
        print("Hope you come back!");
        return;
      }
      print("Simple!");
      changeLevel(7);
    case 7:
      print("Now, I want you to remove the file \"file1.txt\".");
      print("To do this, you'll want to use the command rm, which stands for remove.");
      sleep(6);
      print("rm can take one argument. I'll let you guess what that argument is.");
      if(!triggerTerminal("rm file1.txt")) {
        print("Hope you come back!");
        return;
      }
      print("Easy right?");
      changeLevel(8);
    case 8:
      
    }
  }
}