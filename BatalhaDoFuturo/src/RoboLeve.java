public abstract class RoboLeve implements Atacante, Voador {
    private int energia;
    @Override
    public void atacar() {
        System.out.println("Estou atacando!");
    }

    @Override
    public void voar() {
        System.out.println("Estou voando!");
    }

}
