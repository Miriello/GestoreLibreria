package libreria;

import database.*;
import gestore.*;

public class Libreria extends LibreriaAbstract{
    public Libreria(GestoreFile gestoreFile, GestoreLibri gestoreLibri) {
        super(gestoreFile, gestoreLibri);
    }
    public Libreria(){
        super(new GestoreFileDat(), new GestoreLibriArray());
    }
}
