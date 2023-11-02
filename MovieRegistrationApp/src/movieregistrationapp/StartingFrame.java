
package movieregistrationapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class StartingFrame extends JFrame{
    private ArrayList<Movie> movies= new ArrayList();
    private JLabel IDLabel;
    private JLabel titleLabel;
    private JLabel yearReleasedLabel;
    private JLabel durationLabel;
    private JLabel directorLabel;
    private JLabel genreLabel;
    
    private JTextField IDTf;
    private JTextField titleTf;
    private JTextField yearReleasedTf;
    private JTextField durationTf;
    private JTextField directorTf;
    private JList<String> genreList;
    String genres[] = {"Action","Animation","Drama","Biography"};
    private JScrollPane genreListScroll;
    
    private JButton exitBtn;
    private JButton saveBtn;
    private JButton statisticsBtn;
    private JButton aboutBtn;

 
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem saveItem;
    private JMenuItem statisticsItem;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    
    private JPanel centerPanel;
    private JPanel botPanel;
   public StartingFrame() 
   {      
       
        // Labels
        IDLabel = new JLabel ("Movie ID:");
        titleLabel = new JLabel("Movie Title:");
        yearReleasedLabel = new JLabel("Year movie released:");
        durationLabel = new JLabel("Time duration (in minutes):");
        directorLabel = new JLabel("Directed By:");
        genreLabel = new JLabel("Choose a genre:");
        // Text Fields
        IDTf = new JTextField(4);
        titleTf = new JTextField(20);
        yearReleasedTf = new JTextField(5);
        directorTf = new JTextField(20);
        durationTf = new JTextField(4);
        IDTf.setEnabled(false);

        genreList = new JList<>(genres);
        genreList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        genreListScroll = new JScrollPane(genreList);
        genreListScroll.setPreferredSize(new Dimension(120,130));
        
        exitBtn = new JButton("Quit");
        saveBtn = new JButton("Save");
        statisticsBtn = new JButton("Statistics");
        aboutBtn = new JButton("About");
        //Menu
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        statisticsItem = new JMenuItem("Show movies statistics");
        saveItem = new JMenuItem("Save to file");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        //Panels
        botPanel = new JPanel();
        centerPanel = new JPanel();
        
        //Menu adds
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        fileMenu.add(statisticsItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //Panel adds
        botPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.PAGE_AXIS));
        
        botPanel.add(saveBtn);
        botPanel.add(statisticsBtn);
        botPanel.add(aboutBtn);
        botPanel.add(exitBtn);
        
        centerPanel.add(IDLabel);
        centerPanel.add(IDTf);
        centerPanel.add(titleLabel);
        centerPanel.add(titleTf);
        centerPanel.add(yearReleasedLabel);
        centerPanel.add(yearReleasedTf);
        centerPanel.add(durationLabel);
        centerPanel.add(durationTf);
        centerPanel.add(directorLabel);
        centerPanel.add(directorTf);
        centerPanel.add(genreLabel);
        centerPanel.add(genreListScroll);
        
        this.add(centerPanel,BorderLayout.NORTH);
        
        this.add(botPanel,BorderLayout.SOUTH);
        
        this.setJMenuBar(menuBar);

        //setup & show the frame
        this.setSize(600, 450);
        this.setLocationRelativeTo(null);
        this.setTitle("Movie Registration Form");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
      
     
        //Listeners
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (checkFields()!=0)
                {
                    String genreSelected;
                    genreSelected = genreList.getSelectedValue();
                    Movie currentMovie = createMovie("");
                    addMovie(currentMovie);
                    saveToFile(genreSelected + ".txt",currentMovie);
                    resetFields();
                }
                else {
                     JOptionPane.showMessageDialog(
                    StartingFrame.this,
                    "Some fields are not filled!\n Please fill them and save again",
                    "Save Error",
                    JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFields()!=0)
                {
                    String genreSelected;
                    genreSelected = genreList.getSelectedValue();
                    Movie currentMovie = createMovie("");
                    addMovie(currentMovie);
                    saveToFile(genreSelected + ".txt",currentMovie);
                    resetFields();
                }
                else {
                     JOptionPane.showMessageDialog(
                    StartingFrame.this,
                    "Some fields are not filled!\nPlease fill them and save again",
                    "Save Error",
                    JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        statisticsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsFrame(movies);
            }
        });
        statisticsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsFrame(movies);
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
    }
   
    private void resetFields() {
        IDTf.setText("");
        titleTf.setText("");
        yearReleasedTf.setText("");
        durationTf.setText("");
        directorTf.setText("");
        genreList.clearSelection();
    }
    //Με το κλείσιμο της εφαρμογής σε περίπτωση που όλα τα πεδία έχουν συμπληρωθεί ο χρηστής ενημερώνεται και τον ρωτάει η εφαρμογή 
    //αν θέλει σίγουρα να κλείσει. Σε αντίθετη περίπτωση η εφαρμογή απλά τερματίζει χωρίς να εμφανίζει κάποιο μήνυμα.
    private void exitApp() {
        if (checkFields() == 1)
        { int i = JOptionPane.showConfirmDialog(StartingFrame.this, "You haven't saved. Are you sure you want to leave?");
          if (i == JOptionPane.YES_OPTION) {
            
            System.exit(0);
          } 
        }
        else System.exit(0);
    }
    private void addMovie(Movie movie)
    {
        if (movie!=null)   
        {
         movies.add(movie);
         //Σύμφωνα με την εκφώνηση. Το στοιχείο Κωδικός ταινίας δεν θα καταχωρείται από τον χρήστη αλλά θα αποδίδεται αυτόματα από την εφαρμογή.
         //Ουσιαστικά ως κωδκος (ID ) αποδίδεται η θέση που βρίσκεται η ταινία στη λίστα, που είναι αριθμός και μετατρέπεται σε αλφαριθμητικό (String).
         movie.setId(Integer.toString(movies.indexOf(movie)));
        }
    }

    private Movie createMovie(String movieID)
    {
        int yearReleased,duration;
        IDTf.setText(movieID);
        String title = titleTf.getText().trim();
        try{
         yearReleased = Integer.parseInt(yearReleasedTf.getText()); }
        catch (NumberFormatException exc){
            JOptionPane.showMessageDialog(
                            StartingFrame.this,
                             "Please enter number for duration of movie ",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
          duration = Integer.parseInt(durationTf.getText());}
        catch (NumberFormatException exc){
            JOptionPane.showMessageDialog(
                            StartingFrame.this,
                             "Please enter number for duration of movie ",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
            return null;
        }
     
        String director = directorTf.getText().trim();
        String genre = genreList.getSelectedValue();
       Movie movie = new Movie(movieID,title, yearReleased, duration,director,genre);
       return movie;
    }
    private int checkFields()
    { 
        String title = titleTf.getText().trim();
        String yearReleased = yearReleasedTf.getText();
        String duration = durationTf.getText().trim();
        String director = directorTf.getText().trim();
        String genre = genreList.getSelectedValue();
        if (title.isEmpty()) return 0;
        if (yearReleased.isEmpty()) return 0; 
        if (duration.isEmpty()) return 0; 
        if (director.isEmpty()) return 0; 
        if (genre == null) return 0; 
        return 1;
    }
     public void listReverse()
     {
         int i;
          for (i = movies.size();i >= 0;i--)
          {
              System.out.println(movies.get(i).allAttributes());
          }
     }
    private void saveToFile(String filePath,Movie movie) {

     if (movie!=null){
        try {
                    FileWriter file = new FileWriter(filePath,true);
                    BufferedWriter writer = new BufferedWriter(file);
                    writer.write(movie.allAttributes());
                    writer.newLine();
                    writer.close();

                    JOptionPane.showMessageDialog(
                            StartingFrame.this,
                             "Record saved to " + filePath,
                            "Save completed",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(saveBtn,
                            "Can't access " + filePath,
                            "File access error",
                            JOptionPane.ERROR_MESSAGE);
         }       
    }
}
    
}

