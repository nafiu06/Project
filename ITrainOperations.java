package interfaces;
import entity.*;

public interface ITrainOperations {
    public abstract void addTrain(int tNo, Train t);
    public abstract Train getTrain(int tNo);
    public abstract Train getTrainById(String id);
    public abstract void remove(int tNo);
}
