package objetosNegocio.mock;

public class GobiernoMock {

    private static GobiernoMock instancia;


    public GobiernoMock(){}
    public static GobiernoMock getInstance(){
        if(instancia==null){
            instancia= new GobiernoMock();
        }
        return instancia;
    }

}
