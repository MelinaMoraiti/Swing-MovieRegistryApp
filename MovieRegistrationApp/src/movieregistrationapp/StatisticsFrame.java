
package movieregistrationapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class StatisticsFrame extends JFrame{
    private JButton backBtn;
    private JPanel topPanel;
    private ArrayList<Movie> movies;

    private JLabel statsLabel;
    
    public StatisticsFrame(ArrayList<Movie> movies) 
    {
        backBtn = new JButton("Back");
        topPanel =new JPanel();
        this.movies = movies;
        int oldMovieYear=0,newMovieYear=0;
        String OldMovieTitle="", newMovieTitle="";
        if(!movies.isEmpty()) {OldMovieTitle  = oldestMovie().getTitle(); oldMovieYear = oldestMovie().getYearReleased();}
        if(!movies.isEmpty()) {newMovieTitle  = newestMovie().getTitle(); newMovieYear = newestMovie().getYearReleased();}
        JLabel statsLabel = new JLabel();
        statsLabel.setText("<html><br>Total movies registered: " + noOfMovies()
                + "<br>Category with most movies: "  + mostMovies()
                + "<br>Newest movie: " + newMovieTitle + " (" + newMovieYear +")"
                +" <br>Oldest movie: " 
                +  OldMovieTitle +" (" + oldMovieYear +")" + "</html>" );
   
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        topPanel.add(backBtn);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(statsLabel,BorderLayout.CENTER);
        this.setSize(350, 250);
        this.setTitle("Statistics");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
      this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               goBack();
            }
       });
    
      backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
      });
    }
    private int noOfMovies()
    {
        return movies.size();
    }
    private Movie newestMovie()
    {
          int pos=0;
          int max = movies.get(pos).getYearReleased();
       
         for (Movie movie : movies) {
             if (movie.getYearReleased() > max  ) 
             {  max = movie.getYearReleased();
                pos = movies.indexOf(movie);
             }
          }
         return movies.get(pos);
    }
    
    private Movie oldestMovie()
    {
          int pos=0;
          int min = movies.get(pos).getYearReleased();
       
         for (Movie movie : movies) {
             if (movie.getYearReleased()<min  ) 
             {  min = movie.getYearReleased();
                pos = movies.indexOf(movie);
             }
          }
         return movies.get(pos);
      
    }
    private String mostMovies()
   {
       if(movies.isEmpty()) return "";
        int ActionCnt=0,biographyCnt=0,animationCnt=0,dramaCnt=0;
        int max;
        
        for (Movie movie : movies){
            if(movie.getGenre().equals("Action")) ActionCnt++;
            if (movie.getGenre().equals("Biography")) biographyCnt++;
            if (movie.getGenre().equals("Drama")) dramaCnt++;
            if (movie.getGenre().equals("Animation")) animationCnt++;
        }
        max = Math.max(Math.max(ActionCnt,biographyCnt),Math.max(dramaCnt,animationCnt));
        if (max == ActionCnt) return "Action" +" ("+ max + " movies"+")";
        if (max == biographyCnt) return "Biography" + " (" + max + " movies"+")";
        if (max == dramaCnt) return "Drama" +" ("+ max + " movies"+")";
        if (max == animationCnt) return "Animation " +" ("+ max + " movies"+")";
        return "";
   }
    private void goBack()
    {
        this.dispose();
    }
  
}
