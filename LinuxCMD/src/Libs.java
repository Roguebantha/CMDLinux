import java.io.*;
import java.util.*;

public class Libs
{
  static Scanner input = new Scanner(System.in);
  static boolean shouldIsleep = true;
  static boolean shouldIclear = true;
  public static  String[] array(String... elems)
  {
    return elems;
  }
/**
 * Change the level the user is on
 * @param The level to change to
 * @throws IOException
 */
public static void changeLevel(int a) throws IOException {
  writeFile("./.data/level",Integer.toString(a));
}
  /**
   * Continues to put the user into a terminal until they enter the correct key upon exiting the terminal.
   * @param The key that the user must enter to proceed.
   * @throws IOException
   * @throws InterruptedException
   */
  public static void checkKey(String secretKey,String hint) throws IOException, InterruptedException {
    String key;
    do {
        terminal(hint);
      System.out.println("Enter the secret key!");
      key = input.nextLine();
      if(!key.equals(secretKey))
        System.out.println("Nope, wrong.");
    }while(!key.equals(secretKey));
  }
public static void clear() throws InterruptedException {
  if(shouldIclear)
    System.out.print("\u001b[2J\u001b[H");
}
public static boolean createDir(File file) {
  return file.mkdir();
}
  public static boolean createDir(String file) {
    return new File(file).mkdir();
  }
  /**
   * Creates a file
   * @param File to create.
   * @return File as an object, analogous to objFile
   * @throws IOException
   */
public static File createFile(String f) throws IOException{
    final File file = new File(f);
    if (!file.exists())
      file.createNewFile();
    return file;
  }
  /**
   * Deletes a file
   * @param File to delete
   * @return Whether the file was deleted or not in boolean form
   */
  public static boolean deleteFile(String file) {
    return new File(file).delete();
  }
  public static boolean equals(String str, String[] strings) {
    for(final String element : strings)
      if(str.equals(element))
        return true;
    return false;
  }
  public static void forceDelete(File file) throws IOException
  {
      if(file.isDirectory())
        if(file.list().length==0)
           file.delete();
        else
        {
             final String files[] = file.list();
             for (final String temp : files)
               forceDelete(new File(file, temp));
             if(file.list().length==0)
                 file.delete();
        }
      else
        file.delete();
    }
  /**
   * Recursively deletes a file or folder
   * @param The file/folder to delete
   * @throws IOException
   */
  public static void forceDelete(String f) throws IOException {
    forceDelete(new File(f));
  }
  /**
   * @param File to create
   * @return The file as an object
   */
  public static File objFile(String file){

      return new File(file);
    }
  public static void print(String str) {
    System.out.println(str);
  }
  public static boolean[] processArgs(String[] arg) {
    if(arg.length == 0)
      return new boolean[3];
    final boolean[] args = new boolean[3];
    for(final String element : arg)
      if(element.equals("-d"))
        args[0] = true;
      else if(element.equals("-nc"))
        args[1] = true;
      else if (element.equals("-q"))
        args[2] = true;
    args[1] = !args[1];
    shouldIsleep= args[2] = !args[2];
    return args;
  }
  public static int randInt(int Min, int Max) {
    return Min + (int)(Math.random() * (Max - Min + 1));
  }
  public static String randomFile(double a) {
    final String alphabet = "qqwertyuioplkjhgfdsamnbvcxz0987654321!@#$%^&*()_+=-{}] \\\"\'/\n{|;:<>~`.,?";
    String str = "";
    final double half = a/2;
    final Random r = new Random();
    for(int i = (int) half; i != 0; i--)
      str += String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
    return str;
   }
  /**
   * @param File to read
   * @return The contents of the file
   * @throws IOException
   * @throws InterruptedException
   */
  public static String readFile(String file) throws IOException, InterruptedException{
    return run("cat " + file);
  }
  /**
   * Runs a Linux command. This method is deprecated. Use runFull() instead.
   * @param Command to run. Do not try using cd. It is not a program therefore, it will not run.
   * @return Output of the command
   * @deprecated
   * @throws IOException
   * @throws InterruptedException
   */
public static String run(String command) throws IOException, InterruptedException{
  String s;
  String fin = "";
  BufferedReader br;
  final Process p = Runtime.getRuntime().exec(command);
  p.waitFor();
  fin = (br = new BufferedReader(new InputStreamReader(p.getInputStream()))).readLine();
  while ((s = br.readLine()) != null)
    fin += "\n" + s;
  if(fin == null)
    fin = "";
  return fin;
 }
  /**
   * Runs a Linux command using bash scripting. Supports pipes.
   * @param Command to run. cd will not crash it, but neither will it work.
   * @return The output of the command.
   * @throws IOException
   * @throws InterruptedException
   */
  public static String runFull(String command) throws IOException, InterruptedException{
    writeFile("./.data/cmd",command);
    return script("./.data/cmd");
   }
  public static String script(String script) throws IOException, InterruptedException {
    String arg = "";
    if(-1 != script.indexOf(" ")) {
      arg = script.substring(script.indexOf(" ") +1,script.length());
      script = script.substring(0,script.indexOf(" "));
    }
    if(!new File("./" + script).exists())
      return "";
    run("chmod 755 ./" + script);
    if(arg.equals(""))
      return run("./" + script);
    return run("./" + script + " " + arg);
  }
  public static void sleep() throws InterruptedException {
    sleep(3);
  }
  /**
   * Sleeps for entered amount of seconds, if shouldIsleep == true
   * @param Number of seconds to sleep
   * @throws InterruptedException
   */
  public static void sleep(long i) throws InterruptedException {
    if(shouldIsleep)
      Thread.sleep(i * 1000);
  }
  /**
   * Runs a terminal until the user enters "exit".
   * @throws IOException
   * @throws InterruptedException
   */
  public static void terminal(String hint) throws IOException, InterruptedException {
    String line;
    while(true) {
      System.out.print("$");
      line = input.nextLine();
      if(line.equals("exit"))
        return;
      else if(line.equals("hint"))
        System.out.println(hint);
      else if(run("which " + line) == null)
        System.out.println("That command does not exist!");
      else
        System.out.println(runFull(line));
    }
  }
  /**
   * Keeps the user in a Linux shell until he enters the correct command or types "exit"
   * @param Command the user needs to enter
   * @return Whether the user ever entered the right command or not. Will return false if the user types "exit"
   * @throws IOException
   * @throws InterruptedException
   */
  public static boolean triggerTerminal(String str) throws IOException, InterruptedException {
    String line = "";
    while(!line.equals(str)) {
      System.out.print("$");
      line = input.nextLine();
      if(line.equals("exit"))
        return false;
      if(run("which " + line) == null) System.out.println("That command does not exist!");
      else if(!line.equals(str))
        System.out.println(runFull(line));
    }
    return true;
  }
    public static boolean triggerTerminal(String[] str) throws IOException, InterruptedException {
      String line = "";
      while(!equals(line,str)) {
        System.out.print("$");
        line = input.nextLine();
        if(line.equals("exit"))
          return false;
        if(run("which " + line) == null)
          System.out.println("That command does not exist!");
        else
          System.out.println(runFull(line));
      }
      return true;
    }
    /**
     * Writes to the file, overwriting all data previously in the file
     * @param File to write to
     * @param Content to put in the file
     * @throws IOException
     */
      public static void writeFile(String f, String content) throws IOException{

        final File  file = createFile(f);
        final FileWriter fw = new FileWriter(file.getAbsoluteFile());
        final BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
      }
}