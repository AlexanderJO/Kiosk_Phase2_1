public abstract class Periodical extends Literature
{
    private String genre;
    private int releases;

    /**
     * Constructor for the Periodical class.
     */
    public Periodical(String title, String publisher, String genre, int releases)
    {
        setTitle(title);
        setPublisher(publisher);
        this.releases = releases;
        this.genre = genre;
    }

    /**
     * Returns the genre of the periodical.
     * @return The genre of the periodical.
     */
    public String getGenre()
    {
        return genre;
    }

    public int getReleases()
    {
        return releases;
    }
}
