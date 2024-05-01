package filas;

public class FilaItemLse {
    private NoItem head, tail;
    private int quant;

    public FilaItemLse() {
        this.head = null;
        this.tail = null;
        this.quant = 0;
    }

    public boolean eVazia(){
        return (quant == 0 ? true : false);
    }

    public int size(){
        return this.quant;
    }

    public boolean enqueue(Item novoItem){
        NoItem novoNo = new NoItem(novoItem);
        if (eVazia()){
            this.head = novoNo;
            this.tail = novoNo;
            this.quant++;
            return true;
        } else {
            this.head.setProximoNo(novoNo);
            this.tail = novoNo;
            this.quant++;
            return true;
        }
    }

    public Item dequeue(){
        if (eVazia())
            return null;
        Item itemRemovido = this.head.getItem();
        if (this.quant == 1){
            this.head = null;
            this.tail = null;
            this.quant--;
            return itemRemovido;
        }
        this.head = this.head.getProximoNo();
        this.quant--;
        return itemRemovido;
    }

    public Item peek(){
        if (eVazia())
            return null;
        else
            return this.head.getItem();
    }
}
