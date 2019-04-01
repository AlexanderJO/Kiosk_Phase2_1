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
        this.genre = genre;
        this.releases = releases;
    }

    /**
     * Returns the genre of the periodical.
     * @return The genre of the periodical.
     */
    public String getGenre()
    {
        return this.genre;
    }

    public int getReleases()
    {
        return this.releases;
    }
}
