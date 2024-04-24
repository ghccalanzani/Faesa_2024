package listas;

public class LseItem {
    private NoItem prim, ult;
    private int quant;

    public LseItem () {
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }

    public NoItem getPrim() {
        return prim;
    }

    public NoItem getUlt() {
        return ult;
    }

    public int getQuant() {
        return quant;
    }

    public boolean eVazio() {
        if (quant==0) {
            return true;
        }
        return false;
    }

    public NoItem getNo (int pos) {
        NoItem aux;

        if (pos>=quant || pos<0) {
            return null;
        }
        // andar na lista ate a posicao pos
        aux = this.prim;
        for (int i=0; i<pos; i++) {
            aux = aux.getProximoNo();
        }
        return aux;
    }

    public void inserePrim (Item elem) {
        NoItem novo = new NoItem(elem);
        if (eVazio()) {
            this.ult = novo;
        }else {
            novo.setProximoNo(this.prim);
        }
        this.prim = novo;
        this.quant++;
    }

    public void insereUlt (Item elem) {
        NoItem novoNo = new NoItem(elem);
        if (this.eVazio()) {
            this.prim = novoNo;
        }else {
            this.ult.setProximoNo(novoNo);
        }
        this.ult = novoNo;
        this.quant++;
    }

    public boolean insere (Item elem, int pos) {
        NoItem novo, aux;
        if (pos<0 || pos > this.quant) {
            return false;
        }
        if (pos==0) {
            inserePrim(elem);
        }else if (pos == this.quant){
            insereUlt(elem);
        } else {
            novo = new NoItem(elem);
            aux = this.prim;
            for (int i=1; i<pos; i++) {
                aux = aux.getProximoNo();
            }
            novo.setProximoNo(aux.getProximoNo());
            aux.setProximoNo(novo);
            this.quant++;
        }
        return true;
    }

    public NoItem pesquisa (int num) {
        NoItem aux = this.prim;

        while (aux!=null) {
            if (aux.getItem().getCodigo()==num) {
                return aux;
            }
            aux = aux.getProximoNo();
        }
        return null;
    }

    public NoItem removePrim () {
        NoItem aux;
        if (eVazio()) {
            return null;
        }
        aux = this.prim;
        this.prim = this.prim.getProximoNo();
        if (quant==1) {
            this.ult = null;
        }
        quant--;
        return aux;
    }

    public NoItem removeUlt () {
        NoItem atual, aux;
        if (eVazio()) {
            return null;
        }
        aux = this.ult;
        if (quant==1) {
            this.prim = null;
            this.ult = null;
        }else {
            atual = this.prim;
            for (int i=0; i<quant-2; i++) {
                atual = atual.getProximoNo();
            }
            atual.setProximoNo(null);
            this.ult = atual;
        }
        quant--;
        return aux;
    }

    public NoItem remove (int cod) {
        NoItem atual, ant;
        if (eVazio()) {
            return null;
        }
        if (quant==1) {
            if (cod==this.prim.getItem().getCodigo()) {
                atual = this.prim;
                this.prim = null;
                this.ult = null;
                quant--;
                return atual;
            } else {
                return null;
            }
        } else {
            atual = this.prim;
            ant = this.prim;
            if (this.prim.getItem().getCodigo()==cod) {
                return removePrim();
            }
            while (atual!=null) {
                if (atual.getItem().getCodigo()==cod) {
                    ant.setProximoNo(atual.getProximoNo());
                    quant--;
                    return atual;
                }
                ant = atual;
                atual = atual.getProximoNo();
            }
            return null;
        }
    }

    public NoItem removePos (int pos) {
        NoItem atual, ant;
        if (pos<0 || pos >= quant) {
            return null;
        }
        if (pos==0) {
            return removePrim();
        }
        if (pos==this.quant-1) {
            return removeUlt();
        }
        ant = this.prim;
        for (int i=0; i<pos-1; i++) {
            ant = ant.getProximoNo();
        }
        atual = ant.getProximoNo();
        ant.setProximoNo(atual.getProximoNo());
        quant--;
        return atual;
    }

    public String toString () {
        String temp="";
        NoItem aux= this.prim;

        while (aux!=null) {
            temp += aux.getItem().getCodigo()+"  ";
            aux = aux.getProximoNo();
        }
        return temp;
    }

    public void concatenar (LseItem l2) {
        this.ult.setProximoNo(l2.prim);
        this.ult = l2.ult;
        quant += l2.getQuant();
        l2.prim = null;
        l2.ult = null;
        l2.quant=0;

    }


}
