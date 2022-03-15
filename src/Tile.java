
public class Tile<T> 
{
    private T value;
    private int positionX, positionY;

    public Tile(T value, int positionX, int positionY)
    {
        this.value = value;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX()
    {
        return positionX;
    }
    public void setPositionX(int positionX)
    {
        this.positionX = positionX;
    }
    
    public int getPositionY()
    {
        return positionY;
    }
    public void setPositionY(int positionY)
    {
        this.positionY = positionY;
    }
    
    public T getValue()
    {
        return value;
    }
    public void setValue(T value)
    {
        this.value = value;
    }
}