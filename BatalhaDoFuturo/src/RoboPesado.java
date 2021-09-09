public abstract class RoboPesado implements Defensor, Atacante {
    private int energia;
    @Override
    public void atacar() {
        System.out.println("Estou atacando!");
    }

    @Override
    public void defender() {
        System.out.println("Estou defendendo!");
    }




}
