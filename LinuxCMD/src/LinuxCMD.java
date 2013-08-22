import java.io.File;
import java.io.IOException;


public class LinuxCMD extends Libs
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
    if(args.length != 0 && (args[0].equals("--help") || args[0].equals("-h") || args[0].equals("-help"))) {
      print("This program needs Linux to run");
      print("Options:");
      print(" -q    Quick Mode    Does not sleep in between sentences.");
      print(" -nc   No clearing   Does not clear the screen. Use this if you see unprintable chars appearing.");
      return;
    }
    final String os = System.getProperty("os.name").toLowerCase();
    if(!os.equals("linux")){
      print(os +" is not supported!");
      return;
    }
    if(!new File("./Fdha1fhds90f4").mkdir()) {
      print("I need write permission on my working directory to work! Exiting!");
      return;
    }
    deleteFile("./Fdha1fhds90f4");
    final boolean[] arg = processArgs(args);
    if(arg[0] || !new File("./.level").exists())
      changeLevel(1);
    clear();
    createFile(".cmd");
    runFull("chmod 755 .cmd");
    switch(root() ? 14 : returnLevel()) {
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
      if(!triggerTerminal(array("echo Hello World","\"echo Hello World\""))) {
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
      writeFile("file1.txt","Copy me!");
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
      sleep();
      print("You can also use rm wih the -r command, which lets you delete folders regardless of whether or not they're empty, and -f, which deletes without prompting.");
      sleep(6);
      print("\"rm -rf\" is probably the most dangerous command on the Unix commandline, as it will delete everything in its path to completion. Use carefully!");
      sleep(7);
      print("Speaking of deleting folders...");
      sleep();
      changeLevel(8);
    case 8:
      print("The next command to learn is called the \"rmdir\" command.");
      print("This stands for \"Remove directory\".");
      sleep(6);
      print("Use rmdir with an empty folder/directory as the argument to delete the folder.");
      print("The folder MUST be empty, otherwise it won't be deleted.");
      createDir("deleteMe");
      sleep(6);
      print("You are to delete the folder called \"deleteMe\".");
      sleep();
      print("Good luck!");
      if(!triggerTerminal("rmdir deleteMe")) {
        print("Hope you come back!");
        return;
      }
      changeLevel(9);
      print("Good job!");
      sleep();
      clear();
      print("The sibling of rmdir is mkdir, which creates a folder, and works in the same style as rmdir.");
      sleep();
    case 9:
      print("The next command you need to learn is called cat.\nYou can use cat to print the contents of a file to the commandline.");
      sleep(6);
      writeFile("file1.txt","secretKey");
      print("I've recreated file1.txt. Tell me what the secret key is inside file1.txt.");
      sleep();
      print("When you're ready to enter the key, just type \"exit\".");
      checkKey("secretKey","Use cat!");
      changeLevel(10);
      print("Good job!");
      sleep();
      print("Look, you already have gone through all of unit 1!");
      sleep();
    case 10:
      print("Next, I'm going to teach you some more complex commands, that are also very useful.");
      sleep();
      print("The next command you're going to learn is called man.");
      print("Man stands for \"manual\", and prints a README on any given command.");
      sleep(6);
      print("The command that you should look up is passed in as an argument, for example, you can use \"man whoami\" to see the README for the command whoami.");
      sleep(5);
      //print("I'm not going to give you a mission for this command, but you should understand how it works and be able to use it.");
      //sleep(5);
      print("Unfortunately, due to the way my terminal works, it's impossible for me to make man work correctly.");
      System.out.println(numberOfTerminals());
      input.nextLine();
      if(numberOfTerminals() > 1) 
        print("Fortunately, I'm detecting you already have another terminal open so I won't bother opening another one.");
      else {
        print("...except that I actually can by spawning another terminal, which I will now do.");
        sleep(5);
        runFull("gnome-terminal");
        print("You have just been given access to a full-featured Linux terminal in the spawned window.");
      }
      sleep();
      print("I suggest you do not close that window but just keep it open because we will need to use it later");
      sleep();
      print("I'll try not to open another terminal window if you already have one open.");
      sleep();
      writeFile("file.txt","Hello, how are you?\nAre there numbers on the left of this line?\nIf there are, good job!");
      print("For now, I want you to look at the man page of cat, and figure out how to number the lines.");
      print("Then I want you to come back to this window where I will have a terminal open, and use that option with cat to read the file \"file.txt\".");
      print("Good luck!");
      triggerTerminal("cat -n file.txt");
      deleteFile("file.txt");
      print("Good job!");
      sleep();
    case 11:
      print("On to level 11!");
      sleep();
      print("For the next level, you're going to learn a basic use of nano, which is a text editor, kind of like notepad.");
      sleep();
      print("Nano is very easy to use,");
      
      
      
    }
  }
}