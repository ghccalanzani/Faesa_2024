package pilhas;

public class NoItem {
    private Item item;
    private NoItem noAbaixo;

    public NoItem(Item item) {
        this.item = item;
        this.noAbaixo = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NoItem getNoAbaixo() {
        return noAbaixo;
    }

    public void setNoAbaixo(NoItem noAbaixo) {
        this.noAbaixo = noAbaixo;
    }

    @Override
    public String toString() {
        return "NoItem{" +
                "item=" + item +
                ", noAbaixo=" + noAbaixo +
                "} ";
    }
}
