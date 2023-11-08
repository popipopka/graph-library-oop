package graph.elements.nodes;

public class Node<T> {
    private final T name;
    private String label;

    public Node(T name) {
        checkArguments(name);
        this.name = name;
    }

    private void checkArguments(T name) {
        if(name.getClass() == String.class && ((String) name).isBlank()) {
            throw new NullPointerException("String name не может пустое или null");
        }
    }

    @Override
    public String toString() {
        String builder = name.toString();
        if(label != null) builder += " (" + label + ")";

        return builder;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
