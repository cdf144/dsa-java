package GraphTree.Graph;

public class WeightedEdge implements Comparable<WeightedEdge> {
    private final int v;
    private final int w;
    private final double weight;

    public WeightedEdge(int v, int w, double weight) {
        if (v < 0 || w < 0) {
            throw new IllegalArgumentException("Invalid vertex index");
        }
        if (Double.isNaN(weight)) {
            throw new IllegalArgumentException("Weight is NaN");
        }

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return v;
        } else if (vertex == w) {
            return w;
        } else {
            throw new IllegalArgumentException("Invalid endpoint");
        }
    }

    @Override
    public int compareTo(WeightedEdge that) {
        return Double.compare(this.weight, that.weight);
    }
}
