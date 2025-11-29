package gobierno;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public class BecasDisponiblesDTOGobierno {
    public List<BecaDTOGobierno> becas;

    public BecasDisponiblesDTOGobierno(){}

    public BecasDisponiblesDTOGobierno(List<BecaDTOGobierno> becas) {
        this.becas = becas;
    }

    public List<BecaDTOGobierno> getBecas() {
        return becas;
    }

    public void setBecas(List<BecaDTOGobierno> becas) {
        this.becas = becas;
    }
}
