package listas;

public class LdeItem {
    private NoDuplaItem prim, ult;
    private int quant;

    public LdeItem(){
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }

    public NoDuplaItem getPrim() {
        return prim;
    }

    public NoDuplaItem getUlt() {
        return ult;
    }

    public int getQuant() {
        return quant;
    }

    public boolean eVazia() {
        return (this.quant == 0 ? true : false);
    }

    public boolean inserePrimeiro(Item item){
        return inserir(0, item);
    }

    private boolean inserePrim(Item item){
        NoDuplaItem novoNo = new NoDuplaItem(item);
        novoNo.setProximoNo(this.prim);
        this.prim.setAnteriorNo(novoNo);
        this.prim = novoNo;
        this.quant++;
        return true;
    }

    public boolean insereUltimo(Item item){
        return inserir(this.quant, item);
    }

    private boolean insereUlt(Item item){
        NoDuplaItem novoNo = new NoDuplaItem(item);
        novoNo.setAnteriorNo(this.ult);
        this.ult.setProximoNo(novoNo);
        this.ult = novoNo;
        this.quant++;
        return true;
    }

    public boolean inserir(int pos, Item item){
        if (pos < 0 || pos > quant) {
            return false;
        }
        if(this.eVazia()){
            NoDuplaItem novoNo = new NoDuplaItem(item);
            this.prim = novoNo;
            this.ult = novoNo;
            this.quant++;
            //(Não precisa apontar p/ null pois já foi criado com null)
            return true;
        }
        if(pos == 0){
            inserePrim(item);
        } else if (pos == this.quant) {
            insereUlt(item);
        } else{
            NoDuplaItem novoNo = new NoDuplaItem(item);
            NoDuplaItem noPosAtual = this.prim;
            for(int i = 0; i < pos; i++)
                noPosAtual = noPosAtual.getProximoNo();
            novoNo.setProximoNo(noPosAtual);
            novoNo.setAnteriorNo(noPosAtual.getAnteriorNo());
            noPosAtual.setAnteriorNo(novoNo);
            noPosAtual.getAnteriorNo().setProximoNo(novoNo);
            this.quant++;
        }
        return true;
    }

    public NoDuplaItem pesquisar(int codigoPesquisa){
        if (this.eVazia())
            return null;
        NoDuplaItem aux = this.prim;
        while (aux!=null) {
            if (aux.getItem().getCodigo() == codigoPesquisa) {
                return aux;
            }
            aux = aux.getProximoNo();
        }
        return null;
    }

    public NoDuplaItem removePrimeiro(){
        return remover(0);
    }

    private NoDuplaItem removePrim(){
        NoDuplaItem noRemovido = this.prim;
        this.prim = this.prim.getProximoNo();
        this.prim.setAnteriorNo(null);
        this.quant--;
        return noRemovido;
    }

    public NoDuplaItem removeUltimo(){
        return remover(this.quant - 1);
    }

    private NoDuplaItem removeUlt(){
        NoDuplaItem noRemovido = this.ult;
        this.ult = this.ult.getAnteriorNo();
        this.ult.setProximoNo(null);
        this.quant--;
        return noRemovido;
    }

    public NoDuplaItem remover(int pos){
        if (this.eVazia())
            return null;
        if (pos < 0 || pos >= quant)
            return null;
        NoDuplaItem noRemovido;
        if(this.quant == 1){
            noRemovido = this.prim;
            this.prim = null;
            this.ult = null;
            this.quant--;
            return noRemovido;
        }
        if(pos == 0)
            removePrim();
        if(pos == this.quant - 1)
            removeUlt();

        NoDuplaItem noPosAtual = this.prim;
        for(int i = 0; i < pos; i++)
            noPosAtual = noPosAtual.getProximoNo();
        noRemovido = noPosAtual;
        noPosAtual.getAnteriorNo().setProximoNo(noPosAtual.getProximoNo());
        noPosAtual.getProximoNo().setAnteriorNo(noPosAtual.getAnteriorNo());
        this.quant--;
        return noRemovido;
    }

    public NoDuplaItem removerDeterminadoNo(int codigoPesquisa){
        int pos = 0;
        boolean achou = false;
        if (this.eVazia())
            return null;
        NoDuplaItem aux = this.prim;
        while (aux != null) {
            if (aux.getItem().getCodigo() == codigoPesquisa) {
                achou = true;
                break;
            }
            aux = aux.getProximoNo();
            pos++;
        }
        if(achou){
            return remover(pos);
        } else
            return null;
    }

    public LdeItem concatenar(LdeItem novaLista) {
        if (this.eVazia()){
            this.prim = novaLista.getPrim();
            this.ult = novaLista.getUlt();
            this.quant = novaLista.getQuant();
            return this;
        }
        if (novaLista.eVazia())
            return this;

        this.ult.setProximoNo(novaLista.prim);
        novaLista.prim.setAnteriorNo(this.ult);
        this.ult = novaLista.ult;
        this.quant += novaLista.quant;
        return this;
    }

    public String mostrarElementos () {
        String temp = "";
        NoDuplaItem aux = this.prim;

        while (aux != null) {
            temp += aux.getItem().getCodigo() + " ";
            aux = aux.getProximoNo();
        }
        return temp;
    }

}
