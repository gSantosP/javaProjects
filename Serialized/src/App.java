import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro c1 = new Cachorro();
        c1.setNome("Pitoco");
        c1.setIdade(3);

        Cachorro c2 = new Cachorro();
        c2.setNome("Amora");
        c2.setIdade(2);

        Cachorro c3 = new Cachorro();
        c3.setNome("Alfredo");
        c3.setIdade(1);

        cachorros.add(c1);
        cachorros.add(c2);
        cachorros.add(c3);

        // Aqui salvamos em um arquivo
        FileOutputStream fo = null;

        try{
            fo = new FileOutputStream("Outputfile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(cachorros);
        }
        catch (FileNotFoundException e){
            System.out.println("ERRO" + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Erro" + e.getMessage());

        }
        // Recuperacao de arquivo serializado
        List<Cachorro> cachorro2 = null;
        FileInputStream fi = null;
        try{
            fi = new FileInputStream("Outputfile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            cachorro2 = (ArrayList) ois.readObject(); // Casting
        }
        catch (FileNotFoundException e){
            System.out.println("ERRO" + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Erro" + e.getMessage());

        }
        //imprimir
        for(Cachorro cachorro : cachorro2)
            System.out.println(cachorro.getNome() + " " + cachorro.getIdade());

    }
}
