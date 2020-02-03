public class Die
{
    // Instance variables
    int sides;
    // Constructor(s)
    public Die()
    {
        sides = 6;
    }
    public Die(int s)
    {
        sides = s;
    }
    // Methods
    public int roll()
    {
        return (int) (Math.random() * sides) + 1;
    }
    // weighted rolling WIP
    public int weightedRoll(int weight)
    {
        return (int) (Math.random() * (sides - weight)) + (weight + 1);
    }
}