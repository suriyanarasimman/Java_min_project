
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Try {
    JFrame frame = new JFrame("GRAPHICS");
    JPanel pass = new JPanel();
    JPanel mainpanel = new JPanel();
    JPanel switch1 = new JPanel();
    JPanel morsecodetoenglish = new JPanel();
    JPanel englishtomorsecode= new JPanel();
    JLabel us=new JLabel("user");
    JLabel pa=new JLabel("password");

    JCheckBox o=new JCheckBox("Remember me ");
    ImageIcon image = new ImageIcon("C:\\Users\\94445\\IntelliJIDEAProjects\\fianl\\src\\all\\img1.png");
    JLabel img=new JLabel(image);
    ImageIcon image2 =new ImageIcon("C:\\Users\\94445\\IntelliJIDEAProjects\\fianl\\src\\all\\img2.jpg");
    JLabel img2=new JLabel(image2);
    ImageIcon image3 =new ImageIcon("C:\\Users\\94445\\IntelliJIDEAProjects\\fianl\\src\\all\\img3.jpg");
    JLabel img3=new JLabel(image3);
    ImageIcon image4 =new ImageIcon("C:\\Users\\94445\\IntelliJIDEAProjects\\fianl\\src\\all\\img3.jpg");
    JLabel img4=new JLabel(image4);
    JButton etm = new JButton("English");
    JButton mte = new JButton("Morse");
    JButton entry = new JButton("SUBMIT");
    JTextField user = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JTextArea textArea = new JTextArea(20,20);
    JTextField textfield = new JTextField(20);
    JTextArea textArea2 = new JTextArea(20,20);
    JTextField textfield2 = new JTextField(20);
    JButton etmm = new JButton("conve english to morse");
    JButton mtee = new JButton("conve morse to english");
    JButton back1 = new JButton("BACK");
    JButton back2 = new JButton("BACK");
    JButton logout = new JButton("logout");
    CardLayout c = new CardLayout();

    String raw,finall,f,raw2,finall2,f2,use,pas,t,t2;
    Try(){
        mainpanel.setLayout(c);
        mainpanel.add(switch1,"1");
        mainpanel.add(englishtomorsecode,"3");
        mainpanel.add(morsecodetoenglish,"2");
        mainpanel.add(pass,"4");
        pass.setBackground(Color.GREEN);
        frame.add(mainpanel);
        pass.setLayout(null);
        c.show(mainpanel,"4");
        pass.add(user);
        pass.add(password);
        pass.add(entry);
        pass.add(pa);
        pass.add(us);
        pass.add(o);
        pass.add(img2);
        img2.setBounds(50,150,350,450);
        o.setBounds(235,55+40,130,60);
        pa.setBounds(10,25+20,90,20+20);
        us.setBounds(10,5,110,20+20);
        password.setBounds(110,25+20,170,20+20);
        user.setBounds(110,5,170,20+20);
        entry.setBounds(110,55+40,100,60);
        entry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                use=(String)user.getText();
                pas=(String)password.getText();
                t="admin";
                t2="admin";

               if(use.equals(t) ) {
                   if(pas.equals(t2)){
                   c.show(mainpanel,"1");}
               }
            }
        });
        switch1.setLayout(null);
        switch1.setBackground(Color.RED);
        switch1.add(img);
        img.setBounds(40,180,400,400);
        switch1.add(etm);
        etm.setBounds(30,30,100,100);
        switch1.add(mte);
        mte.setBounds(170,30,100,100);
        switch1.add(logout);
        logout.setBounds(330,10,100,60);
        englishtomorsecode.add(textArea);

        englishtomorsecode.add(textfield);
        englishtomorsecode.add(img3);
        img3.setBounds(5,140,400,650);
        morsecodetoenglish.add(textArea2);
        textArea2.setBounds(5+5,0+5,200,350);
        textArea.setBounds(5+5,0+5,200,350);
        morsecodetoenglish.add(textfield2);
        textfield.setBounds(220,10, 200,30);
        textfield2.setBounds(220,10, 200,30);
        englishtomorsecode.add(etmm);
        etmm.setBounds(215,60,200,50);
        englishtomorsecode.add(back1);
        back1.setBounds(250,120,100,50);
        morsecodetoenglish.add(back2);
        back2.setBounds(250,120,100,50);
        morsecodetoenglish.add(mtee);
        mtee.setBounds(215,60,200,50);
        morsecodetoenglish.add(img4);
        img4.setBounds(5,140,400,650);
        morsecodetoenglish.setLayout(null);
        englishtomorsecode.setLayout(null);

        frame.setVisible(true);
        //frame.setLayout();
        frame.setSize(450+30,450+100+55);

        etm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(mainpanel,"3");
            }
        });

        mte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(mainpanel,"2");
            }
        });

        etmm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raw=textArea.getText();
                f=textfield.getText();
                finall=stringToMorse(raw);
                file();
            }
        });
        mtee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raw2=textArea2.getText();
                f2=textfield2.getText();
                finall2=stringToEnglish(raw2);
                file2();
            }
        });
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(mainpanel,"1");
            }
        });

        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(mainpanel,"1");
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(mainpanel,"4");
                if(!o.isSelected())
                password.setText("");
            }
        });
    }




    public static String stringToMorse( String text )
    {

        String newText = "";
        String selectedChar;
        String convertedChar;
        for (int i = 0; i < text.length(); i++)
        {

            //Select the next character
            selectedChar = text.charAt(i) + "";

            // Convert the character
            convertedChar = encode(selectedChar);

            if (convertedChar.equals(" ")) // " " separates each word represented in english code
            {
                newText = newText + "| ";
            }
            // Add the converted text, and add a space
            else
            {
                newText = newText + convertedChar;
                if (!convertedChar.equals(" "))
                {
                    newText = newText + " ";
                }
            }
        }

        return newText;
    }

    public static String stringToEnglish( String text )
    {
        String newEnglish = ""; //sets string for newEnglish
        String selectedEnglish; //sets string for selectedEnglish
        String convertedEnglish; //sets string for convertedEnglish
        String[] morseChars = text.split(" ");
        for (int i = 0; i < morseChars.length; i++)
        {
            //Select the next Morse character
            selectedEnglish = morseChars[i];
            boolean endsWithWordSeparator = selectedEnglish.endsWith("|");
            if(endsWithWordSeparator) selectedEnglish = selectedEnglish.substring(0, selectedEnglish.length() - 1);
            // Convert the string
            convertedEnglish = decode(selectedEnglish);

            newEnglish = newEnglish + convertedEnglish;
            if (endsWithWordSeparator)
            {
                newEnglish = newEnglish + " ";
            }
        }

        return newEnglish;
    }







    public static String encode (String toEncode)
    {
        String morse = toEncode;

        if (toEncode.equalsIgnoreCase("a"))
            morse = ".-";
        if (toEncode.equalsIgnoreCase("b"))
            morse = "-...";
        if (toEncode.equalsIgnoreCase("c"))
            morse = "-.-.";
        if (toEncode.equalsIgnoreCase("d"))
            morse = "-..";
        if (toEncode.equalsIgnoreCase("e"))
            morse = ".";
        if (toEncode.equalsIgnoreCase("f"))
            morse = "..-.";
        if (toEncode.equalsIgnoreCase("g"))
            morse = "--.";
        if (toEncode.equalsIgnoreCase("h"))
            morse = "....";
        if (toEncode.equalsIgnoreCase("i"))
            morse = "..";
        if (toEncode.equalsIgnoreCase("j"))
            morse = ".---";
        if (toEncode.equalsIgnoreCase("k"))
            morse = "-.-";
        if (toEncode.equalsIgnoreCase("l"))
            morse = ".-..";
        if (toEncode.equalsIgnoreCase("m"))
            morse = "--";
        if (toEncode.equalsIgnoreCase("n"))
            morse = "-.";
        if (toEncode.equalsIgnoreCase("o"))
            morse = "---";
        if (toEncode.equalsIgnoreCase("p"))
            morse = ".--.";
        if (toEncode.equalsIgnoreCase("q"))
            morse = "--.-";
        if (toEncode.equalsIgnoreCase("r"))
            morse = ".-.";
        if (toEncode.equalsIgnoreCase("s"))
            morse = "...";
        if (toEncode.equalsIgnoreCase("t"))
            morse = "-";
        if (toEncode.equalsIgnoreCase("u"))
            morse = "..-";
        if (toEncode.equalsIgnoreCase("v"))
            morse = "...-";
        if (toEncode.equalsIgnoreCase("w"))
            morse = ".--";
        if (toEncode.equalsIgnoreCase("x"))
            morse = "-..-";
        if (toEncode.equalsIgnoreCase("y"))
            morse = "-.--";
        if (toEncode.equalsIgnoreCase("z"))
            morse = "--..";
        if (toEncode.equalsIgnoreCase("0"))
            morse = "-----";
        if (toEncode.equalsIgnoreCase("1"))
            morse = ".----";
        if (toEncode.equalsIgnoreCase("2"))
            morse = "..---";
        if (toEncode.equalsIgnoreCase("3"))
            morse = "...--";
        if (toEncode.equalsIgnoreCase("4"))
            morse = "....-";
        if (toEncode.equalsIgnoreCase("5"))
            morse = ".....";
        if (toEncode.equalsIgnoreCase("6"))
            morse = "-....";
        if (toEncode.equalsIgnoreCase("7"))
            morse = "--...";
        if (toEncode.equalsIgnoreCase("8"))
            morse = "---..";
        if (toEncode.equalsIgnoreCase("9"))
            morse = "----.";
        if (toEncode.equalsIgnoreCase("."))
            morse = ".-.-";
        if (toEncode.equalsIgnoreCase(","))
            morse = "--..--";
        if (toEncode.equalsIgnoreCase("?"))
            morse = "..--..";

        return morse;
    }

    public static String decode (String toEncode) {
        String morse = toEncode;

        if (toEncode.equalsIgnoreCase(".-"))
            morse = "a";
        if (toEncode.equalsIgnoreCase("-..."))
            morse = "b";
        if (toEncode.equalsIgnoreCase("-.-."))
            morse = "c";
        if (toEncode.equalsIgnoreCase("-.."))
            morse = "d";
        if (toEncode.equalsIgnoreCase("."))
            morse = "e";
        if (toEncode.equalsIgnoreCase("..-."))
            morse = "f";
        if (toEncode.equalsIgnoreCase("--."))
            morse = "g";
        if (toEncode.equalsIgnoreCase("...."))
            morse = "h";
        if (toEncode.equalsIgnoreCase(".."))
            morse = "i";
        if (toEncode.equalsIgnoreCase(".---"))
            morse = "j";
        if (toEncode.equalsIgnoreCase("-.-"))
            morse = "k";
        if (toEncode.equalsIgnoreCase(".-.."))
            morse = "l";
        if (toEncode.equalsIgnoreCase("--"))
            morse = "m";
        if (toEncode.equalsIgnoreCase("-."))
            morse = "n";
        if (toEncode.equalsIgnoreCase("---"))
            morse = "o";
        if (toEncode.equalsIgnoreCase(".--."))
            morse = "p";
        if (toEncode.equalsIgnoreCase("--.-"))
            morse = "q";
        if (toEncode.equalsIgnoreCase(".-."))
            morse = "r";
        if (toEncode.equalsIgnoreCase("..."))
            morse = "s";
        if (toEncode.equalsIgnoreCase("-"))
            morse = "t";
        if (toEncode.equalsIgnoreCase("..-"))
            morse = "u";
        if (toEncode.equalsIgnoreCase("...-"))
            morse = "v";
        if (toEncode.equalsIgnoreCase(".--"))
            morse = "w";
        if (toEncode.equalsIgnoreCase("-..-"))
            morse = "x";
        if (toEncode.equalsIgnoreCase("-.--"))
            morse = "y";
        if (toEncode.equalsIgnoreCase("--.."))
            morse = "z";
        if (toEncode.equalsIgnoreCase("-----"))
            morse = "0";
        if (toEncode.equalsIgnoreCase(".----"))
            morse = "1";
        if (toEncode.equalsIgnoreCase("..---"))
            morse = "2";
        if (toEncode.equalsIgnoreCase("...--"))
            morse = "3";
        if (toEncode.equalsIgnoreCase("....-"))
            morse = "4";
        if (toEncode.equalsIgnoreCase("....."))
            morse = "5";
        if (toEncode.equalsIgnoreCase("-...."))
            morse = "6";
        if (toEncode.equalsIgnoreCase("--..."))
            morse = "7";
        if (toEncode.equalsIgnoreCase("---.."))
            morse = "8";
        if (toEncode.equalsIgnoreCase("----."))
            morse = "9";
        if (toEncode.equalsIgnoreCase("|"))
            morse = "";

        return morse;
    }
    public void  file() {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f), "utf-8"));
            writer.write(finall);
        } catch (IOException ex) {
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }

    public void  file2() {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f2), "utf-8"));
            writer.write(finall2);
        } catch (IOException ex) {
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }




    public static void main(String args[]) {
        new Try();
    }


}

