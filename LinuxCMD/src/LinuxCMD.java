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
    run("chmod 755 .cmd");
    print("Hello puny human. My name is TCIAL. My job is to foil you at every turn and render all of your puny hopes and dreams to dust. >:(");
    sleep();
    print("Oh wait, eerrrm...wrong personality...hang on, give me a second to unscramble my innards...");
    sleep();
    print("Og glofasdf regdflskj, fdsjlewio! :D");
    sleep();
    print("Wiat, waht?");
    sleep();
    print("Ah, there we go! Sorry about that. Nice to meet you! My name is TCIAL, and my job is to help you succeed at everything you do and help you achieve your dreams! :D");
    sleep();
    print("To be more specific, I'm to help you learn how the shell works on a Linux system, and how you can use to enormous benefit.");
    sleep();
    print("Almost anything you can do from a GUI, you can do from a shell, and then some more things on top of that, which proves to be really helpful.");
    sleep();
    print("Haha maybe one day, you'll learn how awk works and then you'll really have fun. XD");
    
  }

}
