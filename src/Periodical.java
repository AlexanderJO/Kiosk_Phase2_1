public class Periodical extends Literature
{
    private String genre;
    private String type;
    private int releases;

    public Periodical(String title, String publisher, String genre, String type, int releases)
    {
        super(title, publisher);
        this.genre = genre;
        this.type = type;
        this.releases = releases;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getType()
    {
        return type;
    }

    public int getReleases()
    {
        return releases;
    }
}
