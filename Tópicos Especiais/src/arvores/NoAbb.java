package arvores;

public class NoAbb {
    private Item item;
    private NoAbb esq, dir;

    public NoAbb(Item item) {
        this.item = item;
        this.esq = null;
        this.dir = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NoAbb getEsq() {
        return esq;
    }

    public void setEsq(NoAbb esq) {
        this.esq = esq;
    }

    public NoAbb getDir() {
        return dir;
    }

    public void setDir(NoAbb dir) {
        this.dir = dir;
    }
}
