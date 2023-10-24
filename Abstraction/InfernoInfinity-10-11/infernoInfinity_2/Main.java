package infernoInfinity_2;

import infernoInfinity_2.core.Engine;
import infernoInfinity_2.data.Repository;
import infernoInfinity_2.data.WeaponRepository;

public class Main {

    public static void main(String[] args) {

        Repository repository = new WeaponRepository();
        Engine engine = new Engine(repository);

        engine.run();

    }

}
