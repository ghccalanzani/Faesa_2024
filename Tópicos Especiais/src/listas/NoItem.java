package listas;

public class NoItem {
    private Item item;
    private NoItem proximoNo;

    public NoItem(Item item) {
        this.item = item;
        this.proximoNo = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NoItem getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoItem proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "NoItem{" +
                "item=" + item +
                ", proximoNo=" + proximoNo +
                "} ";
    }
}
