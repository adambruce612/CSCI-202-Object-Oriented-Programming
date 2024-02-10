package conch;

public class Main
{
    public static void main(String[] args)
    {
        MagicConch m = new MagicConch("In your dreams");
        MagicConch p = new MagicConch();

        System.out.println("m's special message is: " + m.getSpecialMessage());
        System.out.println("p's special message is: " + p.getSpecialMessage());

        NonMagicConch c = new NonMagicConch("Blah Blah Blah");
        NonMagicConch d = new NonMagicConch("Zzzzzzzzz");

        System.out.println("c.multiSpeech(): " + c.multiSpeech());
        System.out.println("d.multiSpeech(): " + d.multiSpeech());
    }
}
