package extensions;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        List<? extends Number> foo1 = new ArrayList<Number>();
        List<? extends Number> foo2 = new ArrayList<Integer>();
        List<? extends Number> foo3 = new ArrayList<Double>();

        List<Integer> foo4 = new ArrayList();
        List<Double> foo5 = new ArrayList();

        foo1 = foo4;
        foo1 = foo5;


    }

}
