public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, 5, 70);
        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, 8, 55);
        suv.setTanque(TipoCombustivel.FLEX, 55);
        Carro suvFlex = new Carro("SUVFlex", TipoCombustivel.FLEX, 8, 6, 65);
        Carro econo = new Carro("Economico", TipoCombustivel.GASOLINA, 20, 55);

        System.out.println("Tipos de veiculos:");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);

        // Basico
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);


        // Esportivo
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro esportivo com gasolina");
        esportivo.abastece(TipoCombustivel.GASOLINA, 45);
        System.out.println(esportivo);
        System.out.println("\nViajando com o carro esportivo");
        esportivo.viaja(100);
        System.out.println(esportivo);

        // Utilitario
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro utilitario com diesel");
        utilitario.abastece(TipoCombustivel.DIESEL, 70);
        System.out.println(utilitario);
        System.out.println("\nViajando com o carro utilitario");
        utilitario.viaja(250);
        utilitario.viaja(150);
        System.out.println(utilitario);

        // SUV
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv com gasolina");
        suv.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro suv");
        suv.viaja(200);
        System.out.println(suv);

        // SUVFlex
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suvflex com alcool");
        suvFlex.abastece(TipoCombustivel.ALCOOL, 65);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro suvflex");
        suvFlex.viaja(300);
        System.out.println(suvFlex);
        // Abastecendo novamente porém com gasolina
        System.out.println("\nAbastencendo carro suvflex com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 10);
        System.out.println(suvFlex);
        // Testando viajar com gasolina
        System.out.println("\nViajando com o carro suvflex");
        suvFlex.viaja(100);
        System.out.println(suvFlex);

        // Econo
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro economico com gasolina");
        econo.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(econo);

        System.out.println("\nViajando 5000Km com o carro economico");
        econo.viaja(1100);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1100);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1100);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1100);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 50);
        econo.viaja(600);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(econo);

        System.out.println("Diminuindo consumo e andando mais 5000 KM com o carro economico");
        econo.viaja(1000);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1000);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1000);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(1000);
        System.out.println(econo);

        econo.abastece(TipoCombustivel.GASOLINA, 50);
        econo.viaja(500);
        System.out.println(econo);

        System.out.println("Ultrapassando marca de 10000 Km de quilometragem");
        System.out.println("Carro anda 500 Km com consumo de 19/l e 180 Km com 18/l");
        econo.abastece(TipoCombustivel.GASOLINA, 55);
        econo.viaja(680);
        System.out.println(econo);

    }
}
