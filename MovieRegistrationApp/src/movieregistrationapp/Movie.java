
package movieregistrationapp;

/**
 *
 * @author user
 */
public class Movie {
    private String id;
    private String title;
    private int yearReleased;
    private int duration;
    private  String director ;
    private String genre;
   
    
    public Movie() {
  
    }

    public Movie(String id, String title,int yearReleased, int duration,String director,String genre) {
        this.id = id;
        this.title =title;
        this.yearReleased = yearReleased;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearReleased() {
        return yearReleased;
    }
    
    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String allAttributes() {
        return id + "\t" + title + "\t"  + Integer.toString(yearReleased)+"\t" +Integer.toString(duration)+"\t"+  director + "\t" + genre;
    }  
}
