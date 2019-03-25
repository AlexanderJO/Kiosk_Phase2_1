public abstract class Literature
{
    private String title;
    private String publisher;

    public Literature()
    {
        // Constructor only initialised.
    }

    /**
     * Returns the title of the literature.
     * @return the title of the literature.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the publisher of the literature.
     * @return the publisher of the literature.
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * Sets the title of the literature.
     * @param title of the literature.
     */
    protected void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the publisher of the literature.
     * @param publisher of the literature.
     */
    protected void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
}