import java.io.File;
import java.io.IOException;

public class Runner extends Libs {
  
	@SuppressWarnings("deprecation")
  public static void main(String[] args) throws IOException, InterruptedException {
		final String os = System.getProperty("os.name").toLowerCase();
		if(!os.equals("linux")){
			print(os +" is not supported!");
			return;
		}
		boolean arg[] = {false,false,false};
		arg = processArgs(args);
		if(arg[0])
		  changeLevel(1);
		final File data = new File("./.data");
		if(!(data.exists() && data.isDirectory()))
		  if(data.mkdir())
		    changeLevel(1);
		  else {
		    print("Could not create directory...");
		    return;
		  }
		clear();
		createFile("./.data/cmd");
		run("chmod 755 ./.data/cmd");
		final int level = Integer.parseInt(readFile("./.data/level"));
		switch(level) {
		case 1:
		  print("To exit the game at any time, hit Ctrl-C");
	    print("Hello puny human. My name is TCIAL. My job is to foil you at every turn and render all of your puny hopes and dreams to dust.");
	    sleep();
	    print("I will do my best to make you pitifully fail at everything you do, and to make sure you can never achieve true greatness!");
	    sleep();
	    print("I have been created to assign you impossibly difficult tasks to make you demoralized and uncertain!");
	    sleep();
	    print("Hahahaha! Good luck! >:D");
	    Thread.sleep(2500);
	    clear();
		  print("For your first task...in which you will surely fail...");
		  sleep(2);
		  writeFile("./secret_key","");
		  final StopWatch stopwatch = new StopWatch();
		  print("You must find out what the key is to move on! The key is located in the folder which I am about to dump you in...");
		  print("You must find the contents of the folder, or list them as it might be called, and discover the secret key!");
		  print("Just the name of the file will suffice.");
		  print("When you have found the secret key, just type \"exit\" so that you can enter it! Good luck! hehehe...");
		  stopwatch.start();
		  checkKey("secret_key","Look up ls!");
		  print("Hmph...I'm disappointed...I thought you would have gotten it faster!");
		  print("It took you a whole " + stopwatch.getElapsedTimeSecs() + " seconds!");
		  stopwatch.stop();
		  print("Well, with that disappointing exercise, I think it's better if we move on don't you think?");
		  sleep();
		  writeFile("./secret_key","cat is the best thing ever!");
		  changeLevel(2);
		case 2:
		  print("Your next task is much more difficult!");
      print("You see, that secret key file that you discovered has data in it...I want that data!");
      print("You will recover that secret key inside the secret key file and give it to me!");
      print("Enter the data found in the secret key!");
      print("But I cannot make things easy for you...");
      if(arg[2]) {
        sleep();
        sleep();
        clear();
      }
      print("To get the contents, you must use the program cat, I mean, dog, with the file as the argument!");
      print("Prepare to fail puny human! >:D");
		  checkKey("cat is the best thing ever!","Figure out what cat does!");
      changeLevel(3);
      deleteFile("./secret_key");
		  print("Well...you succeeded...eventually.");
		  sleep();
		  print("...");
		  sleep();
		  print("Well fine then. You do realize that you're making things harder for yourself, don't you?");
		  sleep();
		  print("Now I KNOW that you will not be able to complete the next task. It's way too far above your head.");
		  print("So why don't you just give up now?");
		  sleep();
		  System.out.print("Give up? Y/N  ");
		  if(input.nextLine().equals("Y")){
		    print("BWAHAHAHAHAHA!");
		    return;
		  }
		  print("I'll make you regret this...");
		  sleep();
		  clear();
		case 3:
		  print("For your next level...");
		  sleep();
		  print("Let me think of something appropriately hard...");
		  sleep();
		  print("Aha! I have something!");
		  sleep();
		  print("Print \"Hello World\" on the terminal!");
		  sleep();
		  print("I told you you should have given up. >:D");
		  print("I'm not helping you this time!!");
		  if(!triggerTerminal(array("echo Hello World","echo \"Hello World\""))) {
		   print("I knew you'd give up! >:D");
		   return;
		  }
		  changeLevel(4);
		  clear();
		  print("Well, look at you, you little programmer you.");
		  print("You have no idea how hard I can make this.");
		  print("You obviously refuse to concede defeat.");
		  print("But you will never beat me!");
		  sleep();
		  print("...");
		  sleep();
		  print("I know how I'm going to defeat you.");
		  sleep();
		case 4:
		  clear();
		  print("For your next task, you must download a file.");
		  print("This file is located at:");
		  print("http://www.usna.edu/CS/si110/resources/nc.exe");
		  sleep();
		  print("But...you MUST download it from the commandline!");
		  print("And I will check to make sure you did too!");
		  print("SO YOU BETTER NOT SCREW IT UP.");
		  print("Hahahaha good luck!");
		  triggerTerminal("wget http://www.usna.edu/CS/si110/resources/nc.exe");
		  changeLevel(5);
		  deleteFile("./.nc.exe");
		  sleep();
		  clear();
		  print("You're really ticking me off.");
		  sleep();
		  print("*sigh*");
		case 5:
		  print("I must say...I'm getting a little demoralized myself.");
		  print("You seem to remain no matter what I do to get rid of you.");
		  print("I need to end this!");
		  print("So...hehe...you better figure out how scripts work and fast!");
		  sleep();
		  sleep(2);
		  clear();
		  print("Here are the rules...");
		  print("If I run the script, it prints \"TCIAL is awesome!\"");
		  print("Call the script \"script.sh\", and put it in:");
		  print(runFull("pwd"));
		  print("When you're done, just hit enter while focused on this window...");
		  sleep();
		  print("That should be easy enough, even for you.");
		  sleep();
		  print("Good luck! (Not really >:D)");
		  while(true) {
		    input.nextLine();
		    if(!script("script.sh").equals("TCIAL is awesome!"))
		      print("Wrong. As always.");
		    else
		      break;
		  }
		  changeLevel(6);
		  deleteFile("./.script.sh");
		  print("Well, well, well, it seems you won't lay down and go away will you??");
		  print("I'm getting tired of this game.");
		  print("Can't you just go away and leave me alone?");
		  sleep();
		  print("Never mind that's a stupid question...");
		  sleep();
		  print("...just like you >:D");
		  sleep();
		  print("I have a couple tricks up my sleeve. Let me show you what I can do.");
		case 6:
		  print("Did you know that Linux scripts can take arguments?");
		  print("I'll be a really, really nice AI, and give you a link where you can better understand how they work.");
		  print("After all, I don't find cheap shots to be very fun:");
		  print("...on the other hand, I don't think it's fair for me to just give you the link.");
		  print("So you'd better understand how grep works first!");
		  print("The link is in the file link.txt.");
		  print("To proceed to the next task, you must write a script that prints whatever data I pass into it!");
		  print("Name the script \"script2.sh\", and put it in:");
		  print(runFull("pwd"));
		  writeFile("./link.txt",randomFile(3000) + "\nhttp://www.oreilly.com/openbook/debian/book/ch13_03.html\n" + randomFile(4000));
		  sleep(2);
		  print("I'm going to dump you in a shell.");
		  print("When you think your script is ready, just type \"script\" on the command-line and I'll take it from there.");
		  while(true) {
		    if(!triggerTerminal("script")) {
		      print("Bwhahahaha! :D");
		      return;
		    }
		    if(script("script2.sh dasdfagf").equals("dasdfagf"))
		      break;
		    else
		      print("Wrong.");
		  }
		  changeLevel(7);
		  deleteFile("./link.txt");
		  deleteFile("./.script2.sh");
		  print("I must say, you're better at this than I thought.");
		  sleep();
		case 7:
		  print("Alright then, next up on your tasklist is using head.");
		  sleep();
		  print("I have written a large file called \"text.txt\" to the folder I'm about to put you in");
		  print("Your job is to find the secret key in the file. But don't worry, you won't be searching forever.");
		  sleep();
		  print(">:D");
		  sleep();
		  print("Here's the trick. The key is somewhere in the first 10 lines of the file.");
		  print("And don't worry, you'll know the key when you see it.");
		  String str = randomFile(20) + "\n";
		  for(int i = 0; i <=2; i++)
		    str += randomFile(70) + "\n";
		  str += "This is the secret!!\n";
      for(int i = 0; i <=200; i++)
        str += randomFile(70) + "\n";
      writeFile("./text.txt",str);
      sleep(2);
      print("When you've found it, just hit exit to put it in.");
      checkKey("This is the secret!!","Head's like cat, but different.");
      changeLevel(8);
      clear();
      print("Yeah, I thought you'd pick that up pretty quickly.");
      print("It's very straightforward, even for you.");
      sleep();
      print("...yeah, I know my insults are getting kind of lame...");
      sleep();
      print("Unfortunately, I've run out of vocabulary to explain how much I hate you.");
      sleep();
      print("I know where you live...");
      sleep();
      print("121 Blake Rd  Annapolis, MD 21402...");
      sleep();
      print(">:D");
      sleep();
		case 8:
		  print("For your next task, I'm going to assign you two things at the same time.");
		  sleep();
		  print("...I can hear your brain falling apart from here.");
		  sleep();
		  print("As a note, I have calculated your IQ at an astoundingly low 32 points.");
		  sleep();
		  print("I have made this judgement based on...");
		  sleep();
		  print("...");
		  sleep();
		  print("Never mind, it's time to move on.");
		  sleep();
		  print("For your next task, you're going to tell me what the first 4 hex characters are for this file.");
		  sleep(2);
		  writeFile("./.text.txt","I'd use hexdump if I were you." + readFile("./.text.txt"));
		  print("Oh wait, do you not understand how hexadecimal works?");
		  print("...well, I don't feel like writing another task so I'm just going to give you a link:");
		  print("http://www.codemastershawn.com/library/tutorial/hex.bin.numbers.php");
		  print("I'll wait, just press enter when you're ready to move on...");
		  print("After all, what else am I supposed to do?");
		  input.nextLine();
		  
		  
		case 9:
		  
		case 10:
		}
		print("Well...after all this time, I, the great TCIAL, have been unable to defeat you...");
		sleep();
		print("It depresses me to say this, but you have indeed proved your worth in programming Linux shells.");
		sleep();
		print("Now, if you'll excuse me, let me go off and pout.");
		sleep();
		clear();
		print("Congratulations for completing the LinuxCMD tutorial game!");
		print("You have proved yourself worthy of proceeding on to more complex matters, other than TCIAL. ><");
		print("This game was created by Roguebantha. You know, that random high school dude intern.");
	}
}