package a3;

public class potdegaletes {
    int capacitat;
    int galetes;

    public potdegaletes(int capacitat) {
        this.capacitat = capacitat;
        this.galetes = 0;
    }
}

public syncronized void agafaGaleta() {
    while (galetes == 0) {
        wait();
    }
    galetes--;
}