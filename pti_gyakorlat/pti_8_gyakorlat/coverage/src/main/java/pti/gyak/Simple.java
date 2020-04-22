package pti.gyak;

public class Simple {
    long func(int a, int b, int c) {
        switch(a) {
            case 354:
                return a;
            case 698:
                return -a;
            default:
                return Math.min(b, c);
        }
    }
}
