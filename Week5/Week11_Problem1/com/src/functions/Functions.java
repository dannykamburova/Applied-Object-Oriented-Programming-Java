package functions;

import services.Computable;

public class Functions {
    private class SinFunction implements Computable{
        @Override
        public double function(double x) {
            return Math.sin(Math.toRadians(x));
        }
    }

    public Computable getSinFunction(){
        return new SinFunction();
    }

    private class ExpFunction implements Computable{
        @Override
        public double function(double x) {
            return Math.exp(x);
        }
    }

    public Computable getExpFunction(){
        return new ExpFunction();
    }
}
