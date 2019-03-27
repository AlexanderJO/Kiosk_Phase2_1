public abstract class Periodical extends Literature
{
    private String genre;
    private int releases;

    public Periodical(String title, String publisher, String genre, int releases)
    {
        setTitle(title);
        setPublisher(publisher);
        this.genre = genre;
        this.releases = releases;
    }

    /**
     * Returns the releases of the periodical.
     * @return the releases of the periodical.
     */
    protected int getReleases()
    {
        return releases;
    }

    protected String getGenre()
    {
        return this.genre;
    }
}
