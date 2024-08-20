public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;
    private TipoCombustivel combustivel_atual;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoGasolina, int consumoAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoGasolina, consumoAlcool);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    public void setMotor(TipoCombustivel tipoCombustivel, int consumoMotor) {
        motor = new Motor(tipoCombustivel, consumoMotor);
    }

    public void setTanque(TipoCombustivel tipoCombustivel, int capacidadeTanque) {
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        if(combustivel_atual == null) {
            combustivel_atual = tipoCombustivel;
        }
        if((motor.getTipoMotor() == TipoCombustivel.FLEX && tanque.getTipoCombustivel() == TipoCombustivel.FLEX) && (tipoCombustivel == TipoCombustivel.GASOLINA || tipoCombustivel == TipoCombustivel.ALCOOL)) {
            combustivel_atual = tipoCombustivel;
        } else {
            if(combustivel_atual != tipoCombustivel) {
                System.out.println("\nAVISO: Não é possível abastecer este carro com " + tipoCombustivel + "\n");
                return 0;
            }
        }

        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = combustivelNecessarioLogica(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        motor.atualizaQuilometrosRodados(distancia); //Atualizando a quantidade de quilometros rodados
        motor.atualizaConsumoPLitro();
        
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            int combustivelNecessario = combustivelNecessarioLogica(distancia);
            tanque.gasta(combustivelNecessario);
            return true;
        }
        return false;
    }

    // Função criada para verificar se o carro é FLEX e com qual combustível foi abastecido
    public int combustivelNecessarioLogica(int distancia) {
        if (motor.getTipoMotor() == TipoCombustivel.FLEX && tanque.getTipoCombustivel() == TipoCombustivel.FLEX) {
            if (combustivel_atual == TipoCombustivel.GASOLINA) {
                return motor.combustivelNecessarioGasolina(distancia);
            }
            else if (combustivel_atual == TipoCombustivel.ALCOOL) {
                return motor.combustivelNecessarioAlcool(distancia);
            }
            else {
                return 0;
            }
        }
        return motor.combustivelNecessario(distancia);
    }

    @Override
    public String toString() {
        // Se for abastecido exibir qual combustível o carro está utilizando
        if (combustivel_atual != null) {
            return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque + "\n  Utilizando o Combustível=" + combustivel_atual;
        }
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
