public class Motor {

    private TipoCombustivel tipoMotor;
    private int consumo; // em quilometros por unidade. Ex: Km/Lt
    private int consumoGasolina;
    private int consumoAlcool;
    private int quilometragem;

    public Motor(TipoCombustivel tipoMotor, int consumo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }

    public Motor(TipoCombustivel tipoMotor, int consumoGasolina, int consumoAlcool) {
        this.tipoMotor = tipoMotor;
        this.consumoGasolina = consumoGasolina;
        this.consumoAlcool = consumoAlcool;
    }

    public int getConsumo() {
        return this.consumo;
    }

    public int getConsumoGasolina() {
        return this.consumoGasolina;
    }

    public int getConsumoAlcool() {
        return this.consumoAlcool;
    }

    public TipoCombustivel getTipoMotor(){
        return this.tipoMotor;
    }

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public int combustivelNecessario(int distancia) {
        return distancia / consumo;
    }

    public int combustivelNecessarioGasolina(int distancia) {
        return distancia / consumoGasolina;
    }

    public int combustivelNecessarioAlcool(int distancia) {
        return distancia / consumoAlcool;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        // Verifica se é Flex, se for exibe o consumo de gasolina e de alcool
        if(this.tipoMotor == TipoCombustivel.FLEX) {
            return "Motor [consumoGasolina=" + consumoGasolina + ", consumoAlcool=" + consumoAlcool + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";  
        }
        return "Motor [consumo=" + consumo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
    }
}