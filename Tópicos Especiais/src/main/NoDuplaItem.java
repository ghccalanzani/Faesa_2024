package main;

public class NoDuplaItem {
    private Item item;
    private NoDuplaItem proximoNo;
    private NoDuplaItem anteriorNo;

    public NoDuplaItem(Item item) {
        this.item = item;
        this.proximoNo = null;
        this.anteriorNo = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NoDuplaItem getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoDuplaItem proximoNo) {
        this.proximoNo = proximoNo;
    }

    public NoDuplaItem getAnteriorNo() {
        return anteriorNo;
    }

    public void setAnteriorNo(NoDuplaItem anteriorNo) {
        this.anteriorNo = anteriorNo;
    }

    @Override
    public String toString() {
        return super.toString() + "NoDuplaItem{" +
                "item=" + item +
                "}";
    }
}
