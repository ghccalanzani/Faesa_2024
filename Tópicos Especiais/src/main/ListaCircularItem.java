package main;

public class ListaCircularItem {
    private NoItem ult;
    private int quant;

    public ListaCircularItem(){
        this.ult = null;
        this.quant = 0;
    }

    public NoItem getUlt() {
        return ult;
    }

    public void setUlt(NoItem ult) {
        this.ult = ult;
    }

    public int getQuant() {
        return quant;
    }

    public boolean eVazia() {
        return (quant == 0 ? true : false);
    }

    public boolean insereInicio(Item item){
        NoItem novoNo = new NoItem(item);
        if (eVazia()){
            this.ult = novoNo;
            novoNo.setProximoNo(novoNo);
            this.quant++;
            return true;
        } else { //Serve para 1 único elemento tbm
            novoNo.setProximoNo(this.ult.getProximoNo());
            this.ult.setProximoNo(novoNo);
            this.quant++;
            return true;
        }
    }

    public boolean insereFinal(Item item){
        NoItem novoNo = new NoItem(item);
        if (eVazia()){
            this.ult = novoNo;
            novoNo.setProximoNo(novoNo);
            this.quant++;
            return true;
        } else { //Serve para 1 único elemento tbm
            novoNo.setProximoNo(this.ult.getProximoNo());
            this.ult.setProximoNo(novoNo);
            this.ult = novoNo;
            this.quant++;
            return true;
        }
    }

    public NoItem pesquisar(int codigoPesquisa){
        if (this.eVazia())
            return null;
        NoItem aux = this.ult.getProximoNo();
        for(int i = 0; i < quant; i++){
            if(aux.getItem().getCodigo() == codigoPesquisa)
                return aux;
            aux = aux.getProximoNo();
        }
        return null;
    }

    public NoItem removerPrimeiro(){
        if(eVazia())
            return null;
        NoItem aux = this.ult.getProximoNo(); //Aponta para o 1° nó ou para ele mesmo quando há só 1 nó
        if(quant == 1){
            this.ult = null;
            this.quant--;
        } else {
            this.ult.setProximoNo(aux.getProximoNo());
            this.quant--;
        }
        return aux;
    }

    public NoItem removerUltimo(){
        if(eVazia())
            return null;
        NoItem noRemovido = this.ult;
        NoItem aux = this.ult.getProximoNo();
        if(quant == 1){
            this.ult = null;
            this.quant--;
        } else {
            while (aux.getProximoNo() != this.ult)
                aux = aux.getProximoNo(); //Aux para no penúltimo nó
            aux.setProximoNo(this.ult.getProximoNo());
            this.ult = aux;
            this.quant--;
        }
        return aux;
    }
    public String mostrarElementos () {
        String temp = "";
        NoItem aux = this.ult.getProximoNo();
        do {
            temp += aux.getItem().toString() + " ";
            aux = aux.getProximoNo();
        } while (aux != this.ult.getProximoNo());
        return temp;
    }
}
