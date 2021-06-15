package staticstructure.queue;

/**
 * @author Magaiver Santos
 */
public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<Car> driveTrue = new MyQueue<>();

        driveTrue.enqueue(new Car("BMW", "IMR-3470"));
        driveTrue.enqueue(new Car("Cadillac", "IVY-8094"));
        driveTrue.enqueue(new Car("Hyundai", "IOV-5236"));
        driveTrue.enqueue(new Car("Maserati", "IMA-1301"));
        driveTrue.enqueue(new Car("Porsche", "ICC-3525"));


        System.out.println("Carros na fila ---> " + driveTrue.toString());
        System.out.println("                 ");
        System.out.println("Quantidade de veiculos a ser atendido ---> " + driveTrue.getSize());
        System.out.println("                 ");
        System.out.println("Próximo a ser atendido ---> " + driveTrue.peek());
        System.out.println("                 ");
        System.out.println("Atender o veiculo ---> " + driveTrue.dequeue());
        System.out.println("                 ");
        System.out.println("Quantidade de veiculos a ser atendido ---> " + driveTrue.getSize());
        System.out.println("                 ");
        System.out.println("Próximo a ser atendido ---> " + driveTrue.peek());
        System.out.println("                 ");
        Car car = new Car("Ferrari", "ABC-1234");
        driveTrue.enqueue(car);
        System.out.println("Novo veiculo na fila ---> " + driveTrue.toString());
        System.out.println("                 ");


    }

    public static class Car {
        private String plate;
        private String marca;

        public Car(String marca, String plate) {
            this.plate = plate;
            this.marca = marca;
        }

        public String getPlate() {
            return plate;
        }

        public void setPlate(String plate) {
            this.plate = plate;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        @Override
        public String toString() {
            return "Carros{ " +
                    "marca='" + marca + '\'' +
                    ", placa='" + plate + '\'' +
                    '}';
        }
    }
}
